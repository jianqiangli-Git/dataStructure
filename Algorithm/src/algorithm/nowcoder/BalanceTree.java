package algorithm.nowcoder;

import resource.tree.TreeNode;
import resource.tree.CompleteBinaryTree;
import java.lang.Math;

public class BalanceTree {

	/**判断一个二叉树是不是平衡二叉树
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		CompleteBinaryTree bt = new CompleteBinaryTree();
		TreeNode root = bt.createCompleteBinaryTree(arr);
		Solution16 s = new Solution16();
		System.out.print("二叉树层次遍历：");
		bt.levelOrder(root);
		System.out.println();
		System.out.print("是否是平衡二叉树：");
		boolean is = s.IsBalanced_Solution(root);
		System.out.println(is);
	}

}

//class Solution16 {
//    public boolean IsBalanced_Solution(TreeNode root) {
//    	if(root==null){
//    		return true;   //如果是空节点显然是平衡二叉树
//    	}
//    	
//    	if(Math.abs(getDepth(root.lchild)-getDepth(root.rchild))<=1 && IsBalanced_Solution(root.lchild)&&IsBalanced_Solution(root.rchild)){
//    		return true;
//    	}
//    	return false;
//    }
//    
//    public int getDepth(TreeNode root){
//    	if(root==null){
//    		return 0;
//    	}
//    	int nleft = getDepth(root.lchild);   //得到左子树的高度
//    	int nright = getDepth(root.rchild);  //得到右子树的高度
//    	return Math.max(nleft, nright)+1;    //树的高度为左子树和右子树的最大值再加上根节点这一层的高度 1
//    }
//}

//优化
//上面的方法每次都要重复计算左右子树的高度，效率不高
class Solution16 {
    public boolean IsBalanced_Solution(TreeNode root) {
    	return getDepth(root) != -1;  //-1 代表不平衡，不等于 -1 返回true代表是平衡二叉树
    }
    
    public int getDepth(TreeNode root){
    	if(root==null){
    		return 0;   //如果是空树，返回 0 表示是平衡二叉树
    	}
    	int nleft = getDepth(root.lchild);   //得到左子树的高度
    	if(nleft == -1){                     //检查左子树是否是平衡二叉树，如果不是则直接返回 -1
    		return -1;
    	}
    	int nright = getDepth(root.rchild);   //得到右子树的高度
    	if(nright == -1){
    		return -1;
    	}
    	return Math.abs(nleft-nright)>1 ? -1 : Math.max(nleft, nright)+1;  //如果左右子树平衡(左右子树高度差小于1)，就返回子树的高度
    }
}
