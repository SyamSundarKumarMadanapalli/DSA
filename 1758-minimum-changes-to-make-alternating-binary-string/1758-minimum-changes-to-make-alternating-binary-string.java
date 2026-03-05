class Solution {
    public int minOperations(String s) {
        int operWithOne = 0;
        int operWithZero = 0;
        char ch1 = '1';
        char ch2 = '0';

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) != ch1){
                operWithOne ++;
            }
            ch1 = (ch1 == '1') ? '0' : '1';

            if(s.charAt(i) != ch2){
                operWithZero ++;
            }
            ch2 = (ch2 == '0') ? '1' : '0';
        }

        return Math.min(operWithOne, operWithZero);
    }
}