class Solution {
    public int minPartitions(String n) {
        int maxCount = 0;

        for(int i = 0; i < n.length(); i++){
            int val = n.charAt(i) - '0';
            if(val > maxCount) maxCount = val;
        }

        return maxCount;
    }
}