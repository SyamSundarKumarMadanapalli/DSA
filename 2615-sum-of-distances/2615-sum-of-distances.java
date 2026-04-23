class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(List<Integer> indexs : mp.values()){
            long totalSum = 0;
            for(int index : indexs){
                totalSum += (long)index;
            }

            long preSum = 0;
            int size = indexs.size();
            for(int i = 0; i < size; i++){
                int index = indexs.get(i);
                long postSum = totalSum - preSum - index;

                ans[index] += index * (long) i;
                ans[index] -= preSum;
                ans[index] -= index * (long) (size - i - 1);
                ans[index] += postSum;

                preSum += index;
            }
        }

        return ans;
    }
}