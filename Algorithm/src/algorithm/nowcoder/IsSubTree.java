package algorithm.nowcoder;

import resource.tree.TreeNode;

public class IsSubTree {

	/**输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean result = false;
		if(root1 != null && root2 != null){  //如果两棵树中又一个为空，就会直接返回 result = false
			if(root1.val == root2.val){    //如果当前节点的值相同，就判断root2所在的树是不是当前节点的子树
				result = judge(root1,root2);
			}
			if(!result){   //如果不是当前节点的(根节点)的子树，就判断是不是当前节点左孩子的子树
				result = HasSubtree(root1.left, root2);
			}
			if(!result){   //如果不是当前节点的(根节点)左孩子的子树，就判断是不是当前节点右孩子的子树
				result = HasSubtree(root1.right, root2);
			}			
		}		
        return result;
    }

	public boolean judge(TreeNode root1, TreeNode root2) {
		if(root2 == null){
			return true;     //如果此时root2为空，说明root2所在的树遍历完了，而父树要么跟他一样大要么还没遍历完，因此是子树
		}
		if(root1 == null){
			return false;    //如果此时父树遍历完了，子树经过上一个判断说明还没遍历完，显然就不是子树
		}
		if(root1.val != root2.val){
			return false;    //如果两个节点的值不相同，显然不是子树
		}
		return judge(root1.left, root2.left) && judge(root1.right, root2.right); //继续往下判断，左右孩子都相同，那就是子树，否则就不是
	}

}
