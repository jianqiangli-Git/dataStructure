package algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.omg.PortableInterceptor.INACTIVE;

public class testComparator {

	/**测试 compareTo() 的比较，sort 根据返回值决定比较的两个数是否调换顺序。 -1 不调换，1 就调换
	 * s2.compareTo(s1)和 s1.compareTo(s2)区别的关键是按照s1 s2的顺序比较还是s2 s1的顺序比较。
	 * 中间若是小于号，则返回 -1,顺序就不换。若是大于号则返回1，就调换顺序。
	 * 例如 1 和 3 
	 * 按照 1 3 比较则返回 -1 于是不调换，排序顺序就是 [1,3]
	 * 按照 3 1 比较则返回 1(大于号)于是调换，排序顺序就是 [3,1]
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {20,5,1,3};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++){
			list.add(arr[i]);
		}
		
		String[] strArr = {"12","2","10"};
		ArrayList<String> list1 = new ArrayList<String>();
		for(int i=0;i<strArr.length;i++){
			list1.add(strArr[i]);
		}
		
		Collections.sort(list, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				Integer s1 = o1;
				System.out.println(o1+" "+o2);
				Integer s2 = o2;
				int c = s1.compareTo(s2);  //如果o1>o2返回1，如果o1<o2返回 -1,返回 -1 则 o1 排在 o2 前面
				int comp = s2.compareTo(s1);  //如果o2>o1返回 1，如果o2>o1返回-1，返回 -1 则 o1 排在 o2 前面
				System.out.println("c："+c+" comp："+comp);
				return comp;  			
			}
		});
		
		System.out.println(list.toString());
		
		Collections.sort(list1);   //字符串的比较规则，首先从第一位开始比较，因此排序后的结果为 [10, 12, 2]
		System.out.println(list1.toString());

	}

}
