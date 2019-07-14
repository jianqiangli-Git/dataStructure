package datastructure.traverse;

import java.util.LinkedList;
import java.util.Queue;

import resource.tree.TreeNode;
import resource.tree.BinaryTree;
public class BreadthFirstSearch {

	/**广度优先遍历的实现(利用队列)
	 * 无向图
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.createBinaryTree(array);
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.BFS(root);
	}
	
	public void BFS(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			System.out.print(node.data+" ");
			if(node.lchild!=null){
				q.add(node.lchild);
			}
			if(node.rchild!=null){
				q.add(node.rchild);
			}
		}
	}

}
