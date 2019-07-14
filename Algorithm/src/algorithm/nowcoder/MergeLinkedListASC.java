package algorithm.nowcoder;

import resource.list.ListNode;
import resource.list.LinkedList;
public class MergeLinkedListASC {

	/**输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {1,3,4,6,9};
		int[] arr2 = {2,3,5,7,8};
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		ListNode head1 = list1.createLinkedList(arr1);
		ListNode head2 = list2.createLinkedList(arr2);
		System.out.println("arr1的元素是：");
		list1.scan(head1);
		System.out.println();
		System.out.println("arr2的元素是：");
		list2.scan(head2);
		System.out.println();
		Solution14 s = new Solution14();
		ListNode newHead = s.Merge(head1, head2);
		System.out.println("合成后的结果为：");
		list1.scan(newHead);
	}

}
//新建一个链表来存储两个链表的元素
class Solution14 {
    public ListNode Merge(ListNode list1,ListNode list2) {
    	ListNode node = new ListNode(-1);
    	ListNode head = node;
    	ListNode work = head;
    	head.next = null;    //创建头节点
    	ListNode work1 = list1.next;
    	ListNode work2 = list2.next;
    	int value = 0;
    	while(work1!=null&&work2!=null){
    		if(work1.val<=work2.val){
    			value = work1.val;
    			work1 = work1.next;
    		}
    		else{
    			value = work2.val;
    			work2 = work2.next;
    		}
    			
    		ListNode newnode = new ListNode(value);
    		work.next = newnode;
    		work = work.next;
    	}
    	
    	while(work1!=null){
    		ListNode newnode = new ListNode(work1.val);
    		work.next = newnode;
    		work = work.next;
    		work1 = work1.next;
    	}
    	
    	while(work2!=null){
    		ListNode newnode = new ListNode(work2.val);
    		work.next = newnode;
    		work = work.next;
    		work2 = work2.next;
    	}
        return head;
    }
}