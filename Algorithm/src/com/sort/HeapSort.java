package com.sort;

import java.util.Arrays;

public class HeapSort {

	/**堆排序的实现(大顶堆)
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2,3,5,1,6,7,4};  //堆的初始序列，可以认为是二叉树的层次遍历的结果
		HeapSort hs = new HeapSort();
		System.out.println("初始序列："+Arrays.toString(array));//初始堆序列

		hs.adjust(array);
		
		System.out.println("排序好的序列："+Arrays.toString(array));
	}
	
	public int[] swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
	
	//根据传递的父节点建立大顶堆
	public void heapSort(int[] array,int start,int end){   //传递数组,父节点下标以及结束的下标
		int arrLength = array.length;
		while(true){
			int lchild = 2*start+1;  //当前父节点的左子节点的下标
			if(lchild>end){
				break;    //主要针对循环过来的新父节点，如果左孩子的索引下标超出array.length-1，直接跳出
			}
			if(lchild+1<=end && array[lchild+1]>array[lchild]){  //lchild+1最大为array.length-1
				lchild = lchild + 1;  //如果右孩子大于左孩子，则指向右孩子
			}
			if(array[lchild]>array[start]){
				array = swap(array,start,lchild);   //如果当前指针的值(父节点的孩子节点)大于父节点就和父节点交换
				start = lchild;    //父节点重新指向交换的子节点，如果新的父节点为根的树不满足堆，就继续重新调整为堆
			}
			else
				break;  //如果满足堆就跳出这个父节点这次的循环
		}
	}
	
	//传递所有的父节点建立大顶堆，得到建立好的大顶堆(初始化堆)
	public int[] adjust(int[] array){
		for(int i=array.length/2-1;i>=0;i--){						
			heapSort(array, i,array.length-1);  //传递每次的父节点，从最后一个父节点到根节点(初始化堆时从右向左从下往上)
			System.out.println("调整："+Arrays.toString(array)); //输出每次排序过后的堆序列
		}
		System.out.println("排序好的大顶堆："+Arrays.toString(array));
		for(int j=array.length-1;j>0;j--){		
			//将建好的堆第一个和最后一个元素交换
			swap(array,0,j);
			System.out.println("swapArray:"+Arrays.toString(array));
			heapSort(array, 0, j-1); //调整堆时从上往下，堆的调整区间每次-1，第一次调整堆由于最大的数已经在最后一个位置
									 //因此第一次调整的结束下标应该为j-1
			
		}
		return array;
	}
	

}
