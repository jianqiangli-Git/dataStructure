package examination;
import java.util.*;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();   //这样可以在一行同时输入两个数字，分别被 a b 接收
		System.out.println(a+" "+b);
		
		StringBuilder s1 = new StringBuilder();
		s1.append(10);
		System.out.println(s1.toString());
	}

}
