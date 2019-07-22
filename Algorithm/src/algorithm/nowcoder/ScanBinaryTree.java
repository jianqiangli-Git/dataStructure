package algorithm.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import resource.tree.TreeNode;
import resource.tree.CompleteBinaryTree;
public class ScanBinaryTree {

	/**从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		CompleteBinaryTree bt = new CompleteBinaryTree();
		TreeNode root = bt.createCompleteBinaryTree(arr);
		Solution18 s = new Solution18();
		ArrayList<Integer> arrList = s.PrintFromTopToBottom(root);
		System.out.println(arrList.toString());
	}

}

class Solution18 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	ArrayList<Integer> arrList = new ArrayList<Integer>();
    	if(root==null){
    		return arrList;    //对于{} 返回 []
    	}
    	q.add(root);
    	while(!q.isEmpty()){
    		TreeNode node = q.poll();
    		arrList.add(node.val);
    		if(node.left!=null){
    			q.add(node.left);
    		}
    		if(node.right!=null){
    			q.add(node.right);
    		}
    	}
        return arrList;
    }
}