package algorithm.nowcoder;

public class PostOrderOfTree {

	/**输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
	 * 假设输入的数组的任意两个数字都互不相同
	 * 测试用例：[4,8,6,12,16,14,10] ==>  true
	 * 测试用例：[5,4,3,2,1] ==> true
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		Solution19 s = new Solution19();
		boolean is = s.VerifySquenceOfBST(arr);
		System.out.println(is);
	}

}

//BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
//如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
//完美的递归定义 : ) 。
class Solution19 {
    public boolean VerifySquenceOfBST(int[] sequence) {
    	if(sequence.length==0)
    		return false;   //如果序列为空，则不是某棵树的后续遍历序列
    	return judge(sequence,0,sequence.length-1);
    }
    
    public boolean judge(int[] arr,int left,int right){
    	if(left>=right){    //left 和 right 分别是判断的数组的下标
    		return true;    //如果下标相等，也就是同一个元素，又数组不为空，这个数组序列就是单节点树的后序遍历
    	}
    	int i = left;
    	int j = right-1;      //数组序列最右边的元素是后序遍历序列的根节点
    	while(i<j && arr[j]>arr[right]){   //从right-1开始左移，直到指向第一个小于right的位置，这是右半部分，都比right大
    		j--;
    	}
    	while(i<j){          //左半部分从开始到刚刚j(第一个小于right的位置)搜索
    		if(arr[i]<arr[right]){  //如果i比right小则持续右移，显然j位置是小于right的
    			i++;                //假如直到i=j-1都满足小于right，执行i++，结果i==j
    		}
    		else
    			return false;       //左半部分有任何一个不满足小于right，则返回false
    	}
    	return judge(arr,left,i) && judge(arr,j+1,right-1); //此时i==j，j处于第一个小于right的位置，最后一个元素不必加入比较
    	
    }
}
