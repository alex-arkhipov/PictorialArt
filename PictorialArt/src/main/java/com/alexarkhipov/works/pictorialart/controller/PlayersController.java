package com.alexarkhipov.works.pictorialart.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alexarkhipov.works.pictorialart.model.Players;
import com.alexarkhipov.works.pictorialart.service.PlayersService;
import com.alexarkhipov.works.pictorialart.utils.NeoCrypt;

class Sex {
	public Sex(int v, String n) {
		value = (short) v;
		name = n;
	}

	public final short value;
	public final String name;
}

@Controller
@RequestMapping(value = "/player")
public class PlayersController {
	private static final Logger logger = LoggerFactory.getLogger(PlayersController.class);
	public static final String NEW_PLAYER = "newplayer";

	@Autowired
	private PlayersService playersService;

	@Autowired
	private NeoCrypt neoCrypt;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Players>> players() {

		List<Players> a = playersService.getPlayers();
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	// @RequestMapping(value = "/" + NEW_PLAYER, method = RequestMethod.GET)
	// public String newplayer() {
	// return NEW_PLAYER;
	// }

	@RequestMapping(value = "/" + NEW_PLAYER, method = RequestMethod.GET)
	public String newPlayer(@ModelAttribute("player") Players player) {

		return NEW_PLAYER;
	}

	@RequestMapping(value = "/" + NEW_PLAYER, method = RequestMethod.POST)
	public String newplayerProcess(/* final Model model, */ @ModelAttribute("player") @Valid Players player,
			BindingResult errors) {
		logger.debug(player.toString());
		if (errors.hasErrors()) {
			return NEW_PLAYER;
		}

		// TODO: check that such player exist
		player.setHash(neoCrypt.generatePasswordHash(player.getPassword()));
		playersService.savePlayer(player);
		return "redirect:/player/" + player.getNickname();
	}

	@RequestMapping(value = "/{playernickname}", method = RequestMethod.GET)
	public String showPlayerProfile(@PathVariable String playernickname, Model model) {
		// TODO: get player info
		// Players pl = mock(Players.class);
		// when(pl.getName()).thenReturn("Alex Arkhipov");
		Players pl = playersService.getPlayer(playernickname);
		model.addAttribute("player", pl);
		return "profile";
	}
}
