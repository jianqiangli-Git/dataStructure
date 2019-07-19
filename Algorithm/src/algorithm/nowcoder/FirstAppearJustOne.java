package algorithm.nowcoder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstAppearJustOne {

	/**在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
	 * 测试用例：NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp ==> 1
	 * 测试用例：google ==> 4
	 * @param args
	 */
	public static void main(String[] args) {
//		String str = "google";
		String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
		FirstAppearJustOne fajo = new FirstAppearJustOne();
		int index = fajo.FirstNotRepeatingChar(str);
		System.out.println(index);
	}
	
	//使用map存储每个字母出现的次数
	public int FirstNotRepeatingChar(String str) {
		//HashMap中的键值对时无序的，LinkedHashMap实现类可以将键值对按存入的顺序排序，TreeMap按键的自然顺序排序(如果是字母就按字母顺序排序)
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		char[] ch = str.toCharArray();
		for(int i=0;i<ch.length;i++){
			if(!map.keySet().contains(ch[i])){
				map.put(ch[i], 1);
			}
			else{
				int count = map.get(ch[i]);
				map.put(ch[i], ++count);
			}
		}
		//Map 中的键值对是没有顺序的
		System.out.println(map.toString());
		for (Entry<Character, Integer> c : map.entrySet()) {
			if(c.getValue()==1){
				char charactar = c.getKey();
				return str.indexOf(charactar);
			}
		}
        return -1;
    }
}
