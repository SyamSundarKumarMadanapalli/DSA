class Solution {
public:
    int maxProduct(int n) {
        int firstMax = -1;
        int secondMax = -1;
        
        while(n > 0){
            int rem = n % 10;
            n = n / 10;

            if(rem >= firstMax){
                secondMax = firstMax;
                firstMax = rem;
            }else if(rem > secondMax){
                secondMax = rem;
            }

            if(secondMax == 9) break;
        }

        return firstMax * secondMax;
    }
};