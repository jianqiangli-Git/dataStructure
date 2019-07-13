package algorithm.leetcode;

import java.util.Stack;

public class NoRecurStringLen {

	/**给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
	 * 输入: "pwwkew" "dvdf"
	 * 输出: 3
	 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
	 * @param args
	 */
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		String str = "pwwkew";
		int max = s.lengthOfLongestSubstring(str);
		System.out.println(max);
		String ss=" ";
		System.out.println(ss.length());
	}

}

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
    	if(s.length()==0){
    		return 0;
    	}
    	int max_depth = 0;
    	char[] ch = s.toCharArray();
    	Stack<Character> c = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			if(!c.contains(ch[i])){
				c.add(ch[i]);
				if(c.size()>max_depth){
					max_depth = c.size();
				}
				System.out.println(c);
			}
			else{	
				c.add(ch[i]);
				c.remove(s.indexOf(ch[i]));
				System.out.println(c);
			}
		}
		return max_depth;
    }

}
