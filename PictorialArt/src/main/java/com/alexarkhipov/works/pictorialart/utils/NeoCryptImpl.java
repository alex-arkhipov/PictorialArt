package com.alexarkhipov.works.pictorialart.utils;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class NeoCryptImpl implements NeoCrypt {

	private final int hashIterations;
	private final int hashLength;

	public NeoCryptImpl(int hashIterations, int hashLength) {
		this.hashIterations = hashIterations;
		this.hashLength = hashLength;
	}

	@Override
	public String generatePasswordHash(String password) {
		char[] chars = password.toCharArray();
		byte[] salt;
		byte[] hash;

		try {
			salt = getSalt();

			PBEKeySpec spec = new PBEKeySpec(chars, salt, hashIterations, hashLength * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			hash = skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			// TODO: make hash using MD5 algorithm
			salt = new byte[] { 1, 1, 1, 1 };
			hash = new byte[] { 1, 1, 1, 1 };
		}
		return hashIterations + ":" + toHex(salt) + ":" + toHex(hash);
	}

	@Override
	public boolean validatePasswordHash(String password, String storedHash) {
		String[] parts = storedHash.split(":");
		int iterations = Integer.parseInt(parts[0]);
		byte[] salt = fromHex(parts[1]);
		byte[] hash = fromHex(parts[2]);
		int diff = 0;

		try {
			PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, hash.length * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] testHash = skf.generateSecret(spec).getEncoded();

			diff = hash.length ^ testHash.length;
			for (int i = 0; i < hash.length && i < testHash.length; i++) {
				diff |= hash[i] ^ testHash[i];
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			// TODO: Check MD5 here
			for (byte b : salt) {
				if (b != 1) {
					diff = 1;
					break;
				}
			}
			for (byte b : hash) {
				if (b != 1) {
					diff = 1;
					break;
				}
			}
		}
		return diff == 0;
	}

	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}

	private static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}

	private static byte[] fromHex(String hex) {
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return bytes;
	}
}
