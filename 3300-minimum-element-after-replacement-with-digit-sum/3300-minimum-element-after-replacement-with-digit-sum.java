class Solution {
    public int minElement(int[] nums) {
        int ans = 37;
        for(int num : nums){
            int digitSum = 0;
            
            while(num > 0){
                digitSum += num % 10;
                num = num / 10;
            }

            ans = Math.min(ans, digitSum);
        }

        return ans;
    }
}