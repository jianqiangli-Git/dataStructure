package datastructure.sort;

import java.util.Arrays;

public class QuickSort {

	/**快速排序的实现
	 * 最好 O(nlogn),最坏 O(n²),平均 O(nlogn)
	 * 空间复杂度：O(logn)~O(n)
	 * 不稳定
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,4,2,3,5}; 
		QuickSort qs = new QuickSort();
		int[] sortedArr = qs.sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(sortedArr));
	}
	
	public int[] sort(int[] arr,int left,int right){
		if(left<right){    //这步主要排除输入有误
			int i = left;
			int j = right;  
			int flag = arr[left];  //设置标志位
			while(i<j){			
				while(i<j && arr[j]>flag){
					j--;                  //从右往左找到第一个小于标志位的值的下标
				}
				if(i<j){
					arr[i++] = arr[j];   //将 j 位置的数存到 i 位置后，i指针加 1
				}
				
				while(i<j && arr[i]<=flag){
					i++;
				}
				if(i<j){
					arr[j--] = arr[i];
				}	
			}
			
			arr[i] = flag;   //直到 i==j 时将标志位置的值存到这个中间位置，从而i位置左边比flag小，右边比flag大
			sort(arr,left,i-1);  //对 left 到 i-1 位置递归调用快速排序，使左边得以有序
			sort(arr,i+1,right); //对 i+1 到 right 位置递归调用快速排序，使右边得以有序
		}		
		return arr;
	}

}
