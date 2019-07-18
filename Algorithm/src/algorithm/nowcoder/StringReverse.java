package algorithm.nowcoder;

import java.util.Arrays;
import java.util.Stack;

public class StringReverse {

	/**字符串翻转
	 * 例如，“student. a am I”，正确的句子应该是“I am a student.”
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "student. a am I";
		StringReverse sr = new StringReverse();
		String newStr = sr.ReverseSentence(str);
		System.out.println(newStr);
	}
	
	public String ReverseSentence(String str) {
		if(str == null){ return null;}
        if(str.trim().equals("")){
           return str;
       }
		Stack<String> s = new Stack<String>(); 
		String[] strArr = str.split(" ");     //split()函数根据空格切分成String数组
		System.out.println(Arrays.toString(strArr));
		for(int i=0;i<strArr.length;i++){
			s.push(strArr[i]);
		}

		String newStr = s.pop();
		int stackSize = s.size();
		int k = 0;
		while(!s.isEmpty()){	
			if(k<stackSize){
				newStr = newStr + " ";
				k++;
			}
			newStr = newStr + s.pop();
		}
        return newStr;
    }

}
