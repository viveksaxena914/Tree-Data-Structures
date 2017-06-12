package BST;

import Nodes.TreeNode;

public class KthNodeBST {

	public static <T> TreeNode<T> getKthValue(TreeNode<T> node, int kth,
			boolean isMaxRequired) {
		KthNode<T> kthNode = new KthNode<>(kth);
		return (isMaxRequired) ? getKthMaxValue(node, kthNode)
				: getKthMinValue(node, kthNode);
	}

	/*
	 * Inorder traversal gives the ascending order of elements. Doing reverse of
	 * inorder will give the descending order.
	 */
	private static <T> TreeNode<T> getKthMaxValue(TreeNode<T> node,
			KthNode<T> kthNode) {
		
		if (node != null && kthNode.kthNode == null) {
			getKthMaxValue(node.getRight(), kthNode);

			if (kthNode.kthNode == null) {
				if (kthNode.kth == 1) {
					kthNode.kthNode = node;
				} else {
					kthNode.kth--;
				}
			}
			getKthMaxValue(node.getLeft(), kthNode);
		}

		return kthNode.kthNode;
	}

	private static <T> TreeNode<T> getKthMinValue(TreeNode<T> node,
			KthNode<T> kthNode) {

		if (node != null && kthNode.kthNode == null) {
			getKthMinValue(node.getLeft(), kthNode);

			if (kthNode.kthNode == null) {
				if (kthNode.kth == 1) {
					kthNode.kthNode = node;
				} else {
					kthNode.kth--;
				}
			}
			getKthMinValue(node.getRight(), kthNode);
		}

		return kthNode.kthNode;
	}

	private static class KthNode<T> {
		int kth;
		TreeNode<T> kthNode;

		public KthNode(int kth) {
			super();
			this.kth = kth;
			this.kthNode = null;
		}

	}
}
