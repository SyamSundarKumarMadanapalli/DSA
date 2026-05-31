class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int i = 0;
        int count = 0;

        while(i < n){
            if(s.charAt(i) == '1' && count == 1){
                return false;
            }

            if(s.charAt(i) == '1'){
                count++;
                
                while(i < n && s.charAt(i) == '1'){
                    i++;
                }
            }

            i++;
        }
    
        return true;
    }
}