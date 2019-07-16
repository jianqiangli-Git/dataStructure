package resource.tree;

/**
 * 树的结点类
 * @author Administrator
 *
 */
public class TreeNode {
	public int data;
	public TreeNode lchild = null;
	public TreeNode rchild = null;
	
	public TreeNode(int data){
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