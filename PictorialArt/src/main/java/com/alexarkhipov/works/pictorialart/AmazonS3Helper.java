package com.alexarkhipov.works.pictorialart;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class AmazonS3Helper {

	private static final String BUCKET_NAME = "alexarkhipov-pictorial";
	private static final String FOLDER_NAME = "Pictures";
	private static final String SEPARATOR = "/";

	private static final String IMAGE_URL_START = "https://s3.eu-central-1.amazonaws.com/";
	private static final String IMAGE_URL_END = ".jpg";
	private static final String IMAGE_URL_TEMPLATE = IMAGE_URL_START + BUCKET_NAME + SEPARATOR + FOLDER_NAME
			+ SEPARATOR;

	private static final Logger logger = LoggerFactory.getLogger(AmazonS3Helper.class);

	/*
	 * public void saveFile() { AmazonS3 s3client = new
	 * AmazonS3Client(awsCredentials);
	 * logger.debug("AmazonS3Helper::saveFile invoked!");
	 * 
	 * String fileName = FOLDER_NAME + SEPARATOR + "American_symbol.jpg";
	 * s3client.putObject( new PutObjectRequest(BUCKET_NAME, fileName, new
	 * File("D:\\Images\\Fun\\American_symbol.jpg"))); }
	 */

	public boolean saveFile(MultipartFile image) {
		try {
			AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build();
			String key = FOLDER_NAME + SEPARATOR + image.getOriginalFilename();
			InputStream is = image.getInputStream();

			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentLength(image.getSize());
			meta.setContentType("image/jpg");

			s3.putObject(BUCKET_NAME, key, is, meta);
		} catch (Exception e) {
			logger.error("Error uploading file to S3: " + e.getMessage());
			return false;
		}
		return true;
	}

	public String getImageUrl(String imageName) {
		StringBuilder sb = new StringBuilder().append(IMAGE_URL_TEMPLATE).append(imageName).append(IMAGE_URL_END);
		return sb.toString();
	}

}
