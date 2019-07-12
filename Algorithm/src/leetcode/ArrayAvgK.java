package leetcode;

public class ArrayAvgK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayAvgK aak = new ArrayAvgK();
		int[] nums = {4, 3, 2, 3, 5, 2, 1};
		int k=4;
		Solution5 s = new Solution5();
		Boolean b = s.canPartitionKSubsets(nums, k);
		System.out.println(b);
	}

}


class Solution5 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=nums[i];
        boolean[] v=new boolean[n];
        if(sum%k!=0)
            return false;
        return dfs(nums,k,sum/k,0,0,v);
    }
    public static boolean dfs(int[] nums,int k,int target,int sum,int s,boolean[] v){
        if(k==1)
            return true;
        if(target<0)
            return false;
        if(target==sum)
            return dfs(nums,k-1,target,0,0,v);
        for(int i=s;i<nums.length;i++){
            if(v[i])
                continue;
            v[i]=true;
            if(dfs(nums,k,target,sum+nums[i],i+1,v))
                return true;
            v[i]=false;
        }
        return false;
    }
}