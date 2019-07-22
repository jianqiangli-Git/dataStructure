package algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringCompare {

	/**输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
	 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3,32,321};
		StringCompare sc = new StringCompare();
		String str = sc.PrintMinNumber(arr);
		System.out.println(str);
	}

	public String PrintMinNumber(int [] numbers) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<numbers.length;i++){
			list.add(numbers[i]);
		}
		System.out.println("list："+list.toString());
		
		Collections.sort(list, new Comparator<Integer>() {   //Comparator接口中泛型指定比较的值的类型

			public int compare(Integer o1, Integer o2) {
				String s1 = o1+""+o2;     //s1和s2那种小就按那种排 332
				String s2 = o2+""+o1;     //3 23 < 3 32 于是认为 o2 比 o1 小，排在前面
				return s1.compareTo(s2);  //两个字符串合并比较，字符串小的排在前面例如线[3,32]中321<332于是32排在3前面
			}   //比较条件是s1和s2比较，如果s1比s2小，则返回 -1 ，返回 -1 的就将被比较的对象 o1 排在 o2 前面
			 
		});    //这样2个数两两比较选择排序小的排在前面，例如o2排在前面表示o2在合并字符串时排在o1前面比较小，得到排序后的数组就是排在最前面的最小
		
		System.out.println("sorted list："+list.toString());
		String s = "";
		for (Integer integer : list) {
			s = s + integer;
		}
		return s;
    }
}
