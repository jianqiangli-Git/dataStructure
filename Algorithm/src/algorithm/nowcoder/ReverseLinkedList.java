package algorithm.nowcoder;

import java.util.Stack;

import resource.list.ListNode;
import resource.list.LinkedList;
public class ReverseLinkedList {

	/**输入一个链表，反转链表后，输出新链表的表头。
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		LinkedList list = new LinkedList();
		ListNode head = list.createLinkedList(arr);
		System.out.println("原有链表的顺序：");
		list.scan(head);
		System.out.println();
		Solution13 s = new Solution13();
		ListNode newHead = s.ReverseList(head);
		System.out.println("反转后的链表顺序：");
		list.scan(newHead);
	}

}

//通过将链表压栈再出栈重新建表的方式最简单
//class Solution13 {
//    public ListNode ReverseList(ListNode head) {
//    	ListNode work = head.next;
//    	Stack<Integer> s = new Stack<Integer>();
//    	while(work!=null){
//    		s.push(work.val);
//    		work = work.next;
//    	}
//    	work = head;
//    	for(int i = s.size()-1;i>=0;i--){
//    		ListNode node = new ListNode(s.pop()); 
//    		work.next = node;
//    		work = work.next;
//    	}
//    	return head;
//    }
//}

//通过将指针反转的方式
class Solution13 {
    public ListNode ReverseList(ListNode head) {
    	ListNode pre = null;  //记录当前节点的前一个节点和后一个节点
    	ListNode next = null;
    	
    	head = head.next;
    	while(head!=null){
    		next = head.next;   //保存当前节点的后继节点，不然给当前节点赋予新的后继的时候会丢失原有的后继信息而断链
    		head.next = pre; //现在可以将当前节点的后继设为他的前驱节点
    		pre = head; //前驱节点后移，移到当前节点的位置，这就保存了当前节点的后继的前驱节点
    		head = next; //当前节点移动到其后继节点		
    	}
    	ListNode newHead = new ListNode(-1);
    	newHead.next = pre;
    	return newHead;
    }
}


