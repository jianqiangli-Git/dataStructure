package resource.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import resource.tree.Node;
public class BinaryTree {

	/**二叉树的构造以及先序遍历，中序遍历，后序遍历，层次遍历
	 * @param args
	 */
	public static void main(String[] args) {
		int[] datas = {1,2,3,4,5,6,7};	
		BinaryTree bt = new BinaryTree();
		Node root = bt.createBinaryTree(datas);
		System.out.println("root: "+root.data);
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
	public Node createBinaryTree(int[] datas){
		List<Node> list = new LinkedList<Node>();
		for(int i=0;i<datas.length;i++){
			list.add(new Node(datas[i]));
		}
		for(int i=0;i<list.size()/2-1;i++){
			list.get(i).lchild = list.get(2*i+1);
			list.get(i).rchild = list.get(2*i+2);
		}
		int lastParentNode = list.size()/2-1;
		list.get(lastParentNode).lchild = list.get(2*lastParentNode+1);
		if(list.size()%2!=0){
			list.get(lastParentNode).rchild = list.get(2*lastParentNode+2);
		}
		return list.get(0);
	}
	
	//先序遍历
	public void preOrder(Node root){
		if(root == null){
			return ;
		}
		else{
			System.out.print(root.data+" ");
			preOrder(root.lchild);
			preOrder(root.rchild);
		}
	}
	
	//中序遍历
	public void inOrder(Node root){
		if(root == null){
			return ;
		}
		else{
			inOrder(root.lchild);
			System.out.print(root.data+" ");
			inOrder(root.rchild);
		}
	}
	
	//后序遍历
	public void postOrder(Node root){
		if(root == null){
			return ;
		}
		else{
			postOrder(root.lchild);
			postOrder(root.rchild);
			System.out.print(root.data+" ");
			
		}
	}
	
	//层次遍历
	public void levelOrder(Node root){
		if(root==null){
			return ;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){      //如果队列非空
			Node node = q.poll(); //队头出队
			System.out.print(node.data+" ");
			if(node.lchild!=null){
				q.offer(node.lchild);  //有左孩子就将左孩子入队
			}
			if(node.rchild!=null){ 
				q.offer(node.rchild);  //有右孩子就将右孩子入队
			}
		}
	}

}


