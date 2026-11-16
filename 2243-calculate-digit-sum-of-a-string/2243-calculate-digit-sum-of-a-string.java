class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            String str = "";
            int cnt = 0;
            int sum = 0;

            for(char c : s.toCharArray()){
                sum += c - '0';
                cnt++;

                if(cnt == k){
                    str = str + sum;   
                    sum = 0;
                    cnt = 0;
                }
            }

            if(cnt > 0){
                str = str + sum;
            }
            
            s = str;
        }

        return s;
    }
}