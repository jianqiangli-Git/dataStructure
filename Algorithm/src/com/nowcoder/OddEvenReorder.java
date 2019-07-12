package com.nowcoder;

public class OddEvenReorder {

	/**输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
	 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 * @param args
	 */
	public static void main(String[] args) {
		Solution11 s = new Solution11();
		int[] array = {2,4,6,1,3,5,7};
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
		s.reOrderArray(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}

class Solution11 {
    public void reOrderArray(int [] array) {
    	int temp = 0;
    	boolean flag = true;
    	while(true){
    		flag = true;
	    	for(int i=array.length-1;i>0;i--){
	    		if(array[i]%2!=0&&array[i-1]%2==0){ //如果奇数前面有个偶数就换
	    			temp = array[i];
	    			array[i] = array[i-1];
	    			array[i-1] = temp;
	    			System.out.println("OK");
	    			flag = false;
	    		}	    		
	    	}
	    	if(flag)
	    		break;   //直到没有交换的时候就退出
    	}
    }
}