class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallOdd = Integer.MAX_VALUE;
        int smallEven = Integer.MAX_VALUE;

        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] < smallOdd && nums1[i] % 2 != 0){
                smallOdd = nums1[i];
            }
            else if(nums1[i] < smallEven && nums1[i] % 2 == 0){
                smallEven = nums1[i];
            }
        }

        if(smallOdd > smallEven && smallOdd != Integer.MAX_VALUE) return false;

        return true;
    }
}