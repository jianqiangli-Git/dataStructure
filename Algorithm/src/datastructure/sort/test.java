package datastructure.sort;

import org.w3c.dom.css.RGBColor;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,4,3,2};
		test t = new test();
		t.sort(arr, 0, arr.length-1);

	}
	
	public void sort(int[] arr,int left,int right){
    	if(left<right){
    		System.out.println("left:"+left+" right:"+right);
    		int mid = (left+right)/2;
    		System.out.println("mid:"+mid);
    		
    		System.out.println("before sort left:"+left+" before left sort right:"+right);
    		System.out.println("before left sort mid:"+mid);
    		sort(arr,left,mid);     //将0~mid排好序    		
    		System.out.println("left sort left:"+left+" left sort right:"+right);
    		System.out.println("lest sort mid:"+mid);
    		
    		System.out.println("before right sort left:"+left+" before right sort right:"+right);
    		System.out.println("before right sort mid:"+mid);
    		sort(arr,mid+1,right);  //将mid+1~right排好序
    		System.out.println("right sort left:"+left+" right sort right:"+right);
    		System.out.println("right sort mid:"+mid);
    		
    		System.out.println("我在里面");
    	}
    	System.out.println("我在外面");
    }

}
