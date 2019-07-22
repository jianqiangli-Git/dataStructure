package resource.tree;

import resource.tree.TreeNode;

/**二叉排序树的实现
 * 二叉搜索树、二叉查找树或者二叉排序树
 * 特点：左子树 < 根 < 右子树
 * 性质：中序遍历是从小到大的序列
 * @param args
 */
public class BinarySearchTree {
	public TreeNode root = null;  //二叉排序树的根节点
	
	//BST的构造方法，根据一个数组创造直接创造一棵 BST
	public BinarySearchTree(int[] arr){
		for(int i=0;i<arr.length;i++){
			TreeNode node = new TreeNode(arr[i]);
			if(root == null){
				root = node;
			}
			else{   //从根节点开始比较，如果要插入的节点比根节点小，则插入到根节点的左边
				TreeNode temp = root;
				while(temp != null){
					if(node.val < temp.val){    //首先判断节点跟根节点的大小关系
						if(temp.left == null){
							temp.left = node;   //如果节点小于当前根节点又根节点左孩子为空，就插到当前节点的左孩子
							break;                //插完就结束，继续插入下一个新节点 node
						}
						else{
							temp = temp.left;   //如果小于当前根节点又根节点左孩子不为空，肯定要插到根节点左边，就先去左孩子
						}                         //不断更新根节点
					}
					else{
						if(temp.right == null){
							temp.right = node;
							break;
						}
						else{
							temp = temp.right;
						}
					}				
				}
			}
		}
	} 
	
	//先序遍历
	public void preOrder(TreeNode root){
		if(root == null){
			return ;
		}
		System.out.print(root.val+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	//中序遍历
	public void inOrder(TreeNode root){
		if(root == null){
			return ;
		}
		
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);
	}

}
