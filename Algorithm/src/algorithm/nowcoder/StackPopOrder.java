package algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Stack;
public class StackPopOrder {

	/**输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
	 * 假设压入栈的所有数字均不相等。
	 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
	 * （注意：这两个序列的长度是相等的）
	 * @param args
	 * 一种压栈序列会出现多种出栈序列的原因是压栈的同时可以出栈。
	 */
	public static void main(String[] args) {
		int[] pushA = {1,2,3,4,5};
		int[] popA = {4,5,3,2,1};
		Solution17 s = new Solution17();
		boolean can = s.IsPopOrder(pushA, popA);
		System.out.println(can);
	}

}

/* 思路：
 * 对输入的序列的元素，先入栈，如果栈不为空，就查看栈顶元素和弹出序列的值是否相同，
 * 相同就把栈顶出栈，弹出序列的当前值往后移动一位，继续判断下一个压入序列的值与弹出序列的值有没有相同的。
 * 最后栈辅助栈为空，就表示序列符合要求。
 */
class Solution17 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	Stack<Integer> st = new Stack<Integer>();
        int j = 0;
        if(pushA.length == 0 || popA.length == 0)      	
            return false;
        for(int i=0;i<pushA.length;i++)   
        {       	
            st.push(pushA[i]);        //对压栈序列中的元素先入栈，压栈以后，将所有能出栈的元素出栈
            while(!st.empty()&&st.peek()==popA[j])    //如果栈不为空，就查看栈顶元素和是否相同，相同就出栈
            {
                st.pop();
                j++;             //出栈以后，出栈序列指针后移
            }
        }
        return st.empty();       //如果最后栈为空，就符合要求
    }
}
