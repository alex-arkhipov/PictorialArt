package com.alexarkhipov.works.pictorialart.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alexarkhipov.works.pictorialart.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public boolean saveFile(MultipartFile f) {
		String property = "java.io.tmpdir";
		String tempDir = System.getProperty(property);

		boolean result = true;

		try {
			f.transferTo(new File(tempDir + f.getOriginalFilename()));
		} catch (IOException e) {
			result = false;
		}
		return result;
	}

	@Override
	public String getFileName(MultipartFile f) {
		return f.getOriginalFilename();
	}

}
