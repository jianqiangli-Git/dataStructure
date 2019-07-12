package resource.list;

import resource.list.ListNode;

public class LinkedList {
	ListNode head = null;
	ListNode work = null;
	
	public LinkedList(){
		ListNode node = new ListNode(-1);
		head = node;
		work = head;
	}
	//构造链表(尾插法，带头结点)
	public ListNode createLinkedList(int[] dataArray){
		for (int data : dataArray) {
			ListNode node = new ListNode(data);
			work.next = node;
			work = node;				
		}			
		return head;
	}
	
	//遍历链表
	public void scan(ListNode list){
		list = list.next;
		while(list!=null){
			System.out.print(list.val+" ");
			list = list.next;
		}
	}
}
