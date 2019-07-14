package datastructure.search;

public class ParticleSearch {

	/**折半查找的实现
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,6};
		ParticleSearch ps = new ParticleSearch();
		boolean contain = ps.search(arr, 0, arr.length-1, 7);
		System.out.println(contain);

	}
	
	public boolean search(int[] arr,int left,int right,int target){   //传入查找的范围(left~right)\
		int i = left;
		int j = right;                   //i,j 分别为查找范围的起始位置和结束位置
		while(i<=j){                      
			int mid = (i+j)/2;
			if(arr[mid]==target){        //如果中间值等于目标值，就直接返回
				return true;
			}
			else if(arr[mid]<target){
				i = mid + 1;             //如果目标值大于中间值，那么目标值肯定在中间值右边，于是查找起始位置在mid+1
			}
			else
				j = mid - 1;             //如果目标值小于中间值，那么目标值肯定在中间值左边，于是查找结束位置在mid-1
		}	
		return false;
	}

}
