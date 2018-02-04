package com.alexarkhipov.works.pictorialart.utils;

public interface NeoCrypt {
	public String generatePasswordHash(String password);

	public boolean validatePasswordHash(String password, String hash);
}
