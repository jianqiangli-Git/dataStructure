package resource.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import resource.tree.TreeNode;
public class CompleteBinaryTree {

	/**完全二叉树的构造以及先序遍历，中序遍历，后序遍历，层次遍历
	 * 特点：若设二叉树的深度为h，除第 h 层外，其它各层 (1~h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
	 *      可以认为完全二叉树是满二叉树从右往左剪枝得到的
	 * @param args
	 */
	public static void main(String[] args) {
		int[] datas = {1,2,3,4,5,6,7};	
		CompleteBinaryTree bt = new CompleteBinaryTree();
		TreeNode root = bt.createCompleteBinaryTree(datas);
		System.out.println("root: "+root.val);
		System.out.println("先序遍历：");
		bt.preOrder(root);
		System.out.println();
		System.out.println("中序遍历：");
		bt.inOrder(root);
		System.out.println();
		System.out.println("后序遍历：");
		bt.postOrder(root);
		System.out.println();
		System.out.println("层次遍历：");
		bt.levelOrder(root);
	}
	
	//利用一个List<Node>中的数据创建二叉树
	public TreeNode createCompleteBinaryTree(int[] datas){
		List<TreeNode> list = new LinkedList<TreeNode>();
		for(int i=0;i<datas.length;i++){        //把节点都存入 List 中,有利于直接根据下表索引得到相应的元素，从而可以根据下标关系建立CBT
			list.add(new TreeNode(datas[i]));
		}
		for(int i=0;i<list.size()/2-1;i++){         //父节点的-范围是 0~length/2-1
			list.get(i).left = list.get(2*i+1);   //左孩子是 2*i+1
			list.get(i).right = list.get(2*i+2);   //左孩子是 2*i+2
		}
		int lastParentNode = list.size()/2-1;       //对最后一个父节点，他一定有左孩子，如果节点数是奇数，才有右孩子
		list.get(lastParentNode).left = list.get(2*lastParentNode+1);
		if(list.size()%2!=0){
			list.get(lastParentNode).right = list.get(2*lastParentNode+2);
		}
		return list.get(0);
	}
	
	//先序遍历
	public void preOrder(TreeNode root){
		if(root == null){
			return ;
		}
		else{
			System.out.print(root.val+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	//中序遍历
	public void inOrder(TreeNode root){
		if(root == null){
			return ;
		}
		else{
			inOrder(root.left);
			System.out.print(root.val+" ");
			inOrder(root.right);
		}
	}
	
	//后序遍历
	public void postOrder(TreeNode root){
		if(root == null){
			return ;
		}
		else{
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val+" ");
			
		}
	}
	
	//层次遍历
	public void levelOrder(TreeNode root){
		if(root==null){
			return ;
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){      //如果队列非空
			TreeNode node = q.poll(); //队头出队
			System.out.print(node.val+" ");
			if(node.left!=null){
				q.offer(node.left);  //有左孩子就将左孩子入队
			}
			if(node.right!=null){ 
				q.offer(node.right);  //有右孩子就将右孩子入队
			}
		}
	}

}


