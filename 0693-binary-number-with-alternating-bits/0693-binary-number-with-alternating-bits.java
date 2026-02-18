class Solution {
    public boolean hasAlternatingBits(int n) {
        int prevBit = 0;
        if(n > 0){
            prevBit = n & 1;
            n = (n >> 1);
        }
        while(n > 0){
            int currBit = n & 1;
            if( currBit == prevBit)return false;
            prevBit = currBit;
            n = (n >> 1);
        }
        return true;
    }
}