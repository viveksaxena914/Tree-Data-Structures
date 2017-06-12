package com.vivek.merkletree;

public class Client {
	// Output : 3b7e1e6ba3b82975d7802511d8c7fabbe7a5d112d0dd112fbcfbb7e6417a3214
	public static void main(String[] args) {
		String[] txns = new String[] { "a", "b", "c", "d", "e" };
		MerkleTree tree = MerkleTree.createTree(txns);
		System.out.println("Merkle Root : " + tree.getMerkleRoot());
	}
}
