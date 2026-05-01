class Solution {
    public int kthFactor(int n, int k) {
        if(n == 1 || k == 1) return 1;
        int factor = 0;
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0){
                factor = i;
                k--;
            }

            if(k == 0) return i;
        }

        return k == 1 ? n : -1;
    }
}