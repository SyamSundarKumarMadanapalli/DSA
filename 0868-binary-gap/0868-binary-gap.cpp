class Solution {
public:
    int binaryGap(int n) {
        int diff = 0;
        int cnt = 0;
        bool seen = false;
        int ones = 0;

        while(n > 0){
            if(n & 1){
                seen = true;
                diff = max(diff, cnt);
                cnt = 0;
                ones++;
            }else if(seen){
                cnt++;
            }
            
            n = n >> 1;
        }

        return ones > 1 ? diff + 1 : diff;
    }
};