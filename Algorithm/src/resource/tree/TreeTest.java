package resource.tree;

import resource.tree.BinarySearchTree;
public class TreeTest {

	/**各种二叉树的测试类
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {5,1,7,3,9,2,6,8};
		BinarySearchTree bst = new BinarySearchTree(arr);
		System.out.print("前序遍历：");
		bst.preOrder(bst.root);
		System.out.println();
		System.out.print("中序遍历：");
		bst.inOrder(bst.root);
	}

}
