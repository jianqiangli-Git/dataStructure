package algorithm.leetcode;

import java.util.Stack;

public class StackTest {

	/**Õ»µÄ²âÊÔ
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push(7);
		s.push(8);
		s.push(9);
		System.out.println(s);
		s.pop();
		System.out.println(s);
		System.out.println(s.indexOf(1));

	}

}
