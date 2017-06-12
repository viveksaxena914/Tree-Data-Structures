package BST;

import java.util.Arrays;

import BST.BinarySearchTree.Traversal;

public class Client {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.createBST(Arrays.asList(7,4,12,2,6,9,8,11,3,5));
		System.out.println(bst.traverse(Traversal.PREORDER));
		System.out.println(bst.traverse(Traversal.INORDER));
		System.out.println(bst.traverse(Traversal.POSTORDER));
		System.out.println(KthNodeBST.getKthValue(bst.getTree(), 3, true));
		System.out.println(KthNodeBST.getKthValue(bst.getTree(), 5, false));
	}

}
