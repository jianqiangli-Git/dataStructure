package algorithm.nowcoder;

public class ReplaceEmptyStr {

	/**请实现一个函数，将一个字符串中的每个空格替换成“%20”。
	 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//主要是StringBuffer的常用方法
class Solution {
    public String replaceSpace(StringBuffer str) {	
    	StringBuffer newString = new StringBuffer(); 
    	for(int i=0;i<str.length();i++){             //length()方法可以获得StringBuffer的长度
    		if(str.charAt(i)==' '){                  //charAt(i)获得StringBuffer对象i位置上的字符
    			newString.append("%20");             //append()方法在末尾加上字符串
    		}
    		else
    			newString.append(str.charAt(i));
    	}
    	return newString.toString();
    }
}