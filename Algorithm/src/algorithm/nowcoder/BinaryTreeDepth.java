package algorithm.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

import resource.tree.TreeNode;
import resource.tree.CompleteBinaryTree;

public class BinaryTreeDepth {

	/**输入一棵二叉树，求该树的深度。
	 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		CompleteBinaryTree bt = new CompleteBinaryTree();
		TreeNode root = bt.createCompleteBinaryTree(arr);
		System.out.print("层次遍历：");
		bt.levelOrder(root);
		System.out.println();
		Solution15 s = new Solution15();
		int depth = s.TreeDepth(root);
		System.out.println("深度为："+depth);
	}

}

//递归法
//class Solution15 {
//    public int TreeDepth(TreeNode root) {
//        if(root==null){
//        	return 0;
//        }
//        int nLeft = TreeDepth(root.lchild);
//        int nRight = TreeDepth(root.rchild);
//        return nLeft>nRight ? (nLeft+1):(nRight+1);  // nLeft > nRight ? nLeft : nRight 将会返回 0
//    }
//}
//非递归法(利用队列实现)
class Solution15 {
	public int TreeDepth(TreeNode root) {
		  if(root==null){
		  	return 0;
		  }
		  Queue<TreeNode> q = new LinkedList<TreeNode>();
		  q.offer(root);
		  int depth = 0, count = 0, nextCount = 1;  //nextCount 记录上一层中元素的个数，初始化为1，为根节点
		  while(!q.isEmpty()){
			  TreeNode node = q.poll();  //出队
			  count++;                   //记录出队个数
			  if(node.left!=null){
				  q.offer(node.left);  //如果当前节点有左右孩子，将左右孩子入队
			  }
			  if(node.right!=null){
				  q.offer(node.right);
			  }
			  
			  if(count == nextCount){    //如果出队个数达到上一层元素的个数
				  nextCount = q.size();  //重新记录当前层的个数,上一层的结点都出队了，其下一层的孩子节点也正好都入队
				  count = 0;             //出队个数更新为0
				  depth++;               //深度加 1
			  }
		  }
		  return depth;
		}
}
