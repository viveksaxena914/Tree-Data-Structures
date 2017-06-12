package BST;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Nodes.TreeNode;

public class BinarySearchTree<T extends Comparable<T>> {

	public enum Traversal {
		PREORDER, INORDER, POSTORDER
	};

	private TreeNode<T> tree = null;

	public BinarySearchTree() {
	}

	public List<TreeNode<T>> traverse(Traversal type) {
		List<TreeNode<T>> list = new ArrayList<>();
		switch (type) {
		case PREORDER:
			preorder(list, this.tree);
			break;
		case INORDER:
			inorder(list, this.tree);
			break;
		case POSTORDER:
			postorder(list, this.tree);
			break;
		default:
			break;
		}

		return list;
	}

	private void preorder(List<TreeNode<T>> list, TreeNode<T> root) {
		if (root != null) {
			list.add(root);
			preorder(list, root.getLeft());
			preorder(list, root.getRight());
		}
	}

	private void inorder(List<TreeNode<T>> list, TreeNode<T> root) {
		if (root != null) {
			inorder(list, root.getLeft());
			list.add(root);
			inorder(list, root.getRight());
		}
	}

	private void postorder(List<TreeNode<T>> list, TreeNode<T> root) {
		if (root != null) {
			postorder(list, root.getLeft());
			postorder(list, root.getRight());
			list.add(root);
		}
	}

	public TreeNode<T> createBST(Collection<T> elements) {
		for (T t : elements) {
			put(t);
		}
		
		return tree;
	}

	public void put(T t) {
		
		if (t == null) {
			return;
		}
		
		TreeNode<T> newTreeNode = new TreeNode<T>(t);
		if (tree == null) {
			tree = newTreeNode;
		} else {
			TreeNode<T> cur = tree;
			while (true) {
				int value = t.compareTo(cur.getData());
				if (value < 0) {
					if (cur.getLeft() == null) {
						cur.setLeft(newTreeNode);
						break;
					} else {
						cur = cur.getLeft();
					}
				} else {
					if (cur.getRight() == null) {
						cur.setRight(newTreeNode);
						break;
					} else {
						cur = cur.getRight();
					}
				}
			}
		}
	}

	public TreeNode<T> getTree() {
		return tree;
	}
}
