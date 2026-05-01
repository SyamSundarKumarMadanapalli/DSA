class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;

        while(i < n && j < n){
            while(i < n && nums[i] != 0){
                i++;
            }

            j = i;
            while(j < n && nums[j] == 0){
                j++;
            }

            if(i < n && j < n){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            }  
        }

        return;
    }
}