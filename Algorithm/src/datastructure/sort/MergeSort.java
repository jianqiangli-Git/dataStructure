package datastructure.sort;

import java.util.Arrays;
/**
 * 归并排序的实现(递归法)
 * 时间复杂度：最好 O(nlogn), 最坏 O(nlogn), 平均 O(nlogn)
 * 空间复杂度：O(n)
 * 稳定
 * @author Administrator
 */
public class MergeSort {
    public static void main(String []args){
        int []arr = {9,7,8,6,4,5,3,2,1};
        MergeSort ms = new MergeSort();
        ms.sort(arr);
        System.out.println("sorted array:"+Arrays.toString(arr));
    }
    
    public void sort(int[] arr){
    	int[] temp = new int[arr.length];
    	sort(arr,0,arr.length-1,temp);   //从0~arr.length-1的范围排序，temp作为辅助空间
    }
    
    public void sort(int[] arr,int left,int right,int[] temp){
    	if(left<right){
    		int mid = (left+right)/2;
    		sort(arr,left,mid,temp);     //将0~mid排好序
    		sort(arr,mid+1,right,temp);  //将mid+1~right排好序
    		merge(arr,left,mid,right,temp);
    	}
    }
    
    public void merge(int[] arr,int left,int mid,int right,int[] temp){
    	int i = left;
    	int j = mid + 1;
    	int t = 0;
    	while(i<=mid && j<=right){   //从left~mid，mid+1~right分别比较，插入到辅助数组
    		if(arr[i]<=arr[j]){
    			temp[t++] = arr[i++];  //将较小者插入到辅助数组
    		}
    		else{
    			temp[t++] = arr[j++]; 
    		}	
    	}
    	while(i<=mid){
    		temp[t++] = arr[i++];
    	}
    	while(j<=right){
    		temp[t++] = arr[j++];
    	}
    	t = 0;
    	while(left <= right){         //始终记住arr的起始位置是left
            arr[left++] = temp[t++];  //temp数组从最起始位置开始复制到arr中(arr从起始位置left开始)
        }
    }
 
}
