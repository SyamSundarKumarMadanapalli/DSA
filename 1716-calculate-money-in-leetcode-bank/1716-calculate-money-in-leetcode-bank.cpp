class Solution {
public:
    int totalMoney(int n) {
        int noOfWeeks=n/7;
        int noOfDays=n%7;
        int amount=0;
        for(int i=0;i<7;i++){
            int k=noOfWeeks+i;
            amount+=(k*(k+1))/2 -(i*(i+1))/2;
        }
        int k=noOfWeeks+noOfDays;
        amount+=(k*(k+1))/2 -(noOfWeeks*(noOfWeeks+1))/2;
        return amount;
    }
};