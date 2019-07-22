package datastructure.traverse;

import java.util.Stack;

import resource.tree.TreeNode;
import resource.tree.CompleteBinaryTree;
public class DepthFirstSearch {

	/**深度优先遍历的实现(利用栈实现)
	 * 无向图
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		CompleteBinaryTree bt = new CompleteBinaryTree();
		TreeNode root = bt.createCompleteBinaryTree(array);
		//把树转换为邻接矩阵
		int[][] adj = {{0,1,1,0,0,0},    //adj.length 是行数
					   {1,0,0,1,1,0},    //adj[i].length 是第i行的元素数(列数)
			       	   {1,0,0,0,0,1},
			       	   {0,1,0,0,0,0},    
			           {0,1,0,0,0,0},
			           {0,0,1,0,0,0}}; 
		
		//打印邻接矩阵
//		for(int i=0;i<adj.length;i++){
//			for(int j=0;j<adj[i].length;j++){
//				System.out.print(adj[i][j]+" ");
//				
//			}
//			System.out.println();
//		}
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.DFS(root);
		
	}
	
	//基于邻接矩阵的DFS
	//当前节点的孩子都压栈(BFS是孩子入队)
	public void DFS(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.add(root);
		while(!s.isEmpty()){
			TreeNode n = s.pop();
			System.out.print(n.val+" ");
			if(n.right!=null){   //右孩子先入栈后出栈，就会先访问左孩子
				s.add(n.right);
			}
			if(n.left!=null){
				s.add(n.left);
			}			
		}
	}

}
