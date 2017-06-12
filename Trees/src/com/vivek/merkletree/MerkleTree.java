package com.vivek.merkletree;

import java.security.MessageDigest;

public class MerkleTree {

	private static final String ALGORITHM = "SHA-256";

	private final String[] transactions;

	private MerkleTree(String[] transactions) {
		super();
		this.transactions = transactions;
	}

	public static MerkleTree createTree(String[] transactions) {
		return new MerkleTree(transactions);
	}

	public String getMerkleRoot() {
		if (this.transactions != null && this.transactions.length > 0) {
			return (this.transactions.length == 1) ? getSHA2HexValue(this.transactions[0])
					: getMerkleRoot(this.transactions, this.transactions.length);
		}

		throw new RuntimeException("Transaction required !");
	}

	private String getMerkleRoot(String[] hashes, int len) {
		if (len == 1) {
			return hashes[0];
		}

		int newIndex = 0;
		for (int i = 0; i < len; i++) {
			String first = hashes[i];
			String key = (++i < len) ? first + hashes[i] : first;
			hashes[newIndex++] = getSHA2HexValue(key);
		}
		return getMerkleRoot(hashes, newIndex);
	}

	private String getSHA2HexValue(String key) {
		try {
			byte[] cipherBytes;
			MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
			messageDigest.update(key.getBytes());
			cipherBytes = messageDigest.digest();
			StringBuilder sb = new StringBuilder(2 * cipherBytes.length);

			for (byte b : cipherBytes) {
				sb.append(String.format("%02x", b & 0xff));
			}

			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String[] getTransactions() {
		return transactions;
	}
}
