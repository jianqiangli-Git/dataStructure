package com.nowcoder;

import resource.list.LinkedList;
import resource.list.ListNode;
import java.util.Stack;

public class LinkedListLastKElements {

	/**输入一个链表输出倒数第k个节点
	 * @param args
	 */
	public static void main(String[] args) {
		Solution12 s = new Solution12();
		LinkedList list = new LinkedList();
		int[] dataArray = {1,2,3,4,5};
		ListNode head = list.createLinkedList(dataArray);
		list.scan(head);
		System.out.println();
		ListNode node = s.FindKthToTail(head, 1);
		System.out.println("倒数第k个节点是："+node.val);

	}

}
//首先将所有元素压栈，然后第k个节点出栈
//class Solution12 {
//    public ListNode FindKthToTail(ListNode head,int k) {
//    	Stack<ListNode> s = new Stack<ListNode>();
//    	ListNode work = head.next;    	
//    	while(work!=null){
//    		s.push(work);
//    		work = work.next;
//    	}
//    	for(int i=0;i<k-1;i++){  //0~k-2个元素共k-1个元素出栈，于是到达第k个元素
//    		s.pop();
//    	}
//    	return s.pop();
//    }
//}

//第二种思路是设置两个指针，第一个指针先走到第k个节点，然后两个指针同时前进，知道先走的指针到达末尾，
//则第一个指针指的就是第k个节点
class Solution12 {
public ListNode FindKthToTail(ListNode head,int k) {
	ListNode work1 = head.next;
	ListNode work2 = work1;
	for(int i=0;i<k;i++){
		work1 = work1.next;
	}
	while(work1!=null){
		work1 = work1.next;
		work2 = work2.next;
	}
	return work2;
	}
}

//思想同上，实现方法不同
//public ListNode FindKthToTail(ListNode head,int k) { //5,{1,2,3,4,5}
//    ListNode p, q;
//    p = q = head;
//    int i = 0;
//    for (; p != null; i++) {
//        if (i >= k)
//            q = q.next;
//        p = p.next;
//    }
//    return i < k ? null : q;  //前面的i走到k相当于倒数i个元素，如果i<k说明链表长度不足k个
//}