package resource.tree;

/**
 * 树的结点类
 * @author Administrator
 *
 */
public class TreeNode {
	public int data;
	public TreeNode lchild;
	public TreeNode rchild;
	
	public TreeNode(int data){
		this.lchild = null;
		this.rchild = null;
		this.data = data;
	}
}

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/