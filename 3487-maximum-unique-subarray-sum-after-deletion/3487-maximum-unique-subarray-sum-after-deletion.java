class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> positiveNumsSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveNumsSet.add(num);
            }
        }

        if(positiveNumsSet.isEmpty()){
            int ans = Integer.MIN_VALUE;
            for(int num : nums){
                ans = Math.max(ans, num);
            }

            return ans;
        }

        int sum = 0;
        for (int num : positiveNumsSet) {
            sum += num;
        }

        return sum;
    }
}