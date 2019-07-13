package algorithm.leetcode;
import resource.list.LinkedList;
import resource.list.ListNode;
public class TwoNumAdd {

	/**给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的�?
	 * 并且它们的每个节点只能存储 一位 数字�?如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和�?
	      您可以假设除了数�?0 之外，这两个数都不会�?0 �?���?
		
	      示例�?
		
	      输入�?2 -> 4 -> 3) + (5 -> 6 -> 4)
	      输出�? -> 0 -> 8
	      原因�?42 + 465 = 807

	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList t1 = new LinkedList();
		LinkedList t2 = new LinkedList();
		int[] i1 = {2,4,3};
		int[] i2 = {5,6,4};
		ListNode l1 = t1.createLinkedList(i1);
		ListNode l2 = t2.createLinkedList(i2);
		Solution s = new Solution();
		System.out.println(l1+" "+l2);
		t1.scan(l1);
		System.out.println();
		t2.scan(l2);
		System.out.println();
		ListNode sum = s.addTwoNumbers(l1, l2);
		t1.scan(sum);
		System.out.println();
		System.out.println(sum);

	}
	
}


/**
 * Definition for singly-linked list.
	class ListNode2 {
		int val;
		ListNode2 next;
	
		ListNode2(int x) {
			val = x;
		}
	}
 *
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode head = l1; //要记住链表的头结点，因为 l1 会移动到链表的末尾，返回 l1 会得不到链表的头指针
        int t = 0;
        while(l1.next!=null){
        	l1 = l1.next;
            l2 = l2.next;
            int temp = l1.val+l2.val+t;
            if(temp>=10){
                l1.val = temp-10;
                t = 1;
            }
            else{                
                l1.val = temp;
                t = 0;
            }
            if(l1.next==null && t!=0){
            	ListNode last = new ListNode(1);
            	l1.next=last;
            	break;
            }
        }
        return head;
    }
}
//另一种解法，通过除法和求模取得实现进�?
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode pre = new ListNode(0);
//        ListNode cur = pre;
//        int carry = 0;
//        while(l1 != null || l2 != null) {
//            int x = l1 == null ? 0 : l1.val;
//            int y = l2 == null ? 0 : l2.val;
//            int sum = x + y + carry;
//            
//            carry = sum / 10;    //通过�?0获得进位
//            sum = sum % 10;      //通过取模获得当前为要存的�?
//            cur.next = new ListNode(sum);
//
//            cur = cur.next;
//            if(l1 != null)
//                l1 = l1.next;
//            if(l2 != null)
//                l2 = l2.next;
//        }
//        if(carry == 1) {
//            cur.next = new ListNode(carry);
//        }
//        return pre.next;
//    }
//}

