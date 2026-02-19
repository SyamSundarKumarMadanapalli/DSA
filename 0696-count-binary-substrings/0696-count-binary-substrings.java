class Solution {
    public int countBinarySubstrings(String s) {
        int zeroes = 0; 
        int ones = 0;
        char prev = '7';
        int cnt = 0;

        for(char ch : s.toCharArray()){
            if(ch == '1'){
                if(prev == '0'){
                    ones = 0;
                }
                ones++;
            }else{
                if(prev == '1'){
                    zeroes = 0;
                }
                zeroes++;
            }

            prev = ch;

            if(prev == '0' && ones >= zeroes)cnt++;
            if(prev == '1' && zeroes >= ones)cnt++;
        }

        return cnt;
    }
}