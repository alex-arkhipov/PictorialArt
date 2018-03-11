package com.alexarkhipov.works.pictorialart.model;

import java.util.ArrayList;
import java.util.List;

public class Gender {
	public final short value;
	public final String name;

	public Gender(int v, String n) {
		value = (short) v;
		name = n;
	}
	
	public static List<Gender> getSexes() {
		ArrayList<Gender> sexes = new ArrayList<>();
		Gender man = new Gender(1, "Man");
		Gender woman = new Gender(2, "Woman");
		sexes.add(man);
		sexes.add(woman);
		return sexes;
	}
}
