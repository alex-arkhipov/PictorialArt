package com.alexarkhipov.works.pictorialart.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	boolean saveFile(MultipartFile f);

	String getFileName(MultipartFile f);
}
