class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long plusCount = 0;
        long minusCount = 0;

        if(k == 0 && !Arrays.equals(nums1, nums2)) return -1;
        else if(k == 0) return 0;

        for(int i = 0; i < nums1.length; i++){
            long diff = nums1[i] - nums2[i]; 

            if(Math.abs(diff) % k != 0) return -1;
           
            if(diff > 0){
                plusCount += diff / k;
            }else{
                minusCount += Math.abs(diff) / k;
            }
        }

        return (plusCount == minusCount) ? plusCount : -1;
    }
}