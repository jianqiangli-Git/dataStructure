package datastructure.sort;

import java.util.Arrays;

public class BubbleSort {

	/**冒泡排序的实现
	 * 时间复杂度：最好 O(n),最坏 O(n²), 平均O(n²)//最好就是第一次就是有序而break，没有进入内层循环，i从arr.length-1~1
	 * 空间复杂度：O(1)    //用于交换而开辟了一个内存空间 temp
	 * 稳定
	 * @param args
	 */
	public static void main(String[] args) {
		BubbleSort bb = new BubbleSort();
		int[] arr = {4,1,6,2,7,4,3,8,5};
		System.out.println("before sorted："+Arrays.toString(arr));
		bb.sort(arr);
		System.out.println("sorted array: "+Arrays.toString(arr));

	}
	
	public void sort(int[] arr){
		boolean flag = false;
		for(int i=arr.length-1;i>0;i--){
			flag = false;   //进入循环前，首先置flag=false表示没有交换
			for(int j=0;j<i;j++){	   //进行比较的范围是0~arr.length-2,使得arr.length-1可以和arr.length-2比较
				if(arr[j]>arr[j+1]){   //如果前面的数比后面大，就交换
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}				
			}
			if(!flag){    //如果在这次循环中没有产生交换，说明有序，就退出来
				break;
			}
		}
	}

}
