class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        int closestSum=1000000;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int k=n-1, j=i+1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target) < Math.abs(closestSum-target)){
                    closestSum=sum;
                }
                if(sum<target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return closestSum;
    }
}