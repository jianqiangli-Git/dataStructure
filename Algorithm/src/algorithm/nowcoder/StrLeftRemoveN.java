package algorithm.nowcoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StrLeftRemoveN {

	/**请你把其循环左移K位后的序列输出。
	 * 例如，字符序列S="abcXYZdef",要求输出循环左移3位后的结果，即"XYZdefabc"。
	 * @param args
	 */
	public static void main(String[] args) {
		String str= "abcXYZdef";
		String str1 = "abcdefg";
		
		StrLeftRemoveN slmn = new StrLeftRemoveN();
		System.out.println("String："+str);
		System.out.println("String1："+str1);
		String newString = slmn.LeftRotateString(str, 3);
		System.out.println("Rotate String："+newString);
		String newString1 = slmn.LeftRotateString1(str1, 3);
		System.out.println("Rotate String1："+newString1);
		
	}
	
	public String LeftRotateString(String str,int n) {
		Queue<Character> q = new LinkedList<Character>();
		if(str.length()==0){
			return "";
		}
		char[] ch = str.toCharArray();
		for(int i=n;i<ch.length;i++){
			q.add(ch[i]);
		}
		for(int i=0;i<n;i++){
			q.add(ch[i]);
		}
		String string = q.poll()+"";    //Queue中存的是 char 类型，要转化成String类型可以使用这种自动转换的方式
		while(!q.isEmpty()){
			string = string + q.poll(); //不能直接使用 q.toString() 因为他得到的是char数组形式的String，这里要使用拼接String的方式
		}
        return string;
    }
	
	public String LeftRotateString1(String str, int n) {
        int len = str.length();
        if(len == 0) 
        	return "";
        n = n % len;   //主要是防止输入的移动位数大于字符串长度，例如 string 是 6 位要移动 9 位的话，相当于移动 3 位
        str += str;    //字符串的复制，stringstring
        //sunstring()返回 beginIndex~endIndex-1范围的字符串
        //smiles".substring(1, 5) returns "mile" 共 endIndex-beginIndex 位
        return str.substring(n, len+n); //从第 n 位开始取，直到 len+n 共 len 位
    }

}
