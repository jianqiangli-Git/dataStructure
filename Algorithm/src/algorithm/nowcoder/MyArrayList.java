package algorithm.nowcoder;
import java.util.ArrayList;

public class MyArrayList {

	/**输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode work = null;
		ListNode head = null;
		for(int i=0;i<8;i++){			
			ListNode ln = new ListNode(i);
			if(i==0){
				head=ln;				
				work = head;
			}
			else{
				work.next = ln;
				work = ln;	
			}			
		}
		work = head;
		System.out.println("原始链表：");
		while(work!=null){
			System.out.print(work.val+" ");
			work = work.next;
		}
		System.out.println();
		Solution2 s2=new Solution2();
		ArrayList<Integer> newInt = s2.printListFromTailToHead(head);
		System.out.println("倒序链表：");
		System.out.println(newInt);
	}

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

//class Solution2 {
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//    	ArrayList<Integer> list = new ArrayList<Integer>();   	
//    	int temp = 0;  	
//    	while(listNode!=null){
//    		list.add(listNode.val);
//    		listNode = listNode.next;
//    	}
//    	int length = list.size();
//    	int index=length-1;
//    	for(int i=0;i<length/2;i++){
//    		temp=list.get(i);
//    		list.set(i, list.get(index));
//    		list.set(index, temp);
//    		index--;
//    	}
//        return list;
//    }
//}

/**输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @param args
 */
//简洁的递归法
class Solution2 {
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}