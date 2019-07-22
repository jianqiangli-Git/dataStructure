package algorithm.nowcoder;

import java.util.Stack;

import resource.tree.CompleteBinaryTree;
import resource.tree.TreeNode;

public class MirrorOfBinaryTree {

	/**操作给定的二叉树，将其变换为源二叉树的镜像
	 * 		8
     *	   / \
     *	  6  10
     *   / \ / \
     *	5  7 9 11
     * 输出
     *      8
     *	   / \
     *	  10  6
     *	 / \ / \
     *	11 9 7  5
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {8,6,10,5,7,9,11};
		CompleteBinaryTree cbt = new CompleteBinaryTree();
		TreeNode root = cbt.createCompleteBinaryTree(arr);
		System.out.println("层次遍历为：");
		cbt.levelOrder(root);
		MirrorOfBinaryTree mbt = new MirrorOfBinaryTree();
		mbt.Mirror(root);
		System.out.println("镜像二叉树为：");
		cbt.levelOrder(root);
	}
	
	//如果当前节点有左右孩子，就将左右孩子保存(队列或者栈),供下次访问。然后将左右孩子交换顺序
	public void Mirror(TreeNode root) {
        if(root == null){
        	return ;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        while(!s.isEmpty()){
        	TreeNode node = s.pop();
        	if(node.left != null){
        		s.push(node.left);
        	}
        	if(node.right != null){
        		s.push(node.right);
        	}
        	if(node.left != null || node.right != null){  //判断当前节点有左孩子或者右孩子(反正不为空节点，避免出现空指针异常),就交换左右孩子
        		TreeNode temp = node.left;
        		node.left = node.right;
        		node.right = temp;
        	}      	
        }       
    }
	
	//递归实现
    public void Mirror1(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
         
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
         
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }
}
