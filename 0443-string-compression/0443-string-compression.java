class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = 0;
        
        while(i < n){
            int count = 0;
            char ch = chars[i];
            while(i < n && ch == chars[i]){
                count++;
                i++;
            }

            chars[j] = ch;
            j++;

            if(count > 1){
                String cnt = Integer.toString(count);
                for(char c : cnt.toCharArray()){
                    chars[j++] = c;
                }
            }
        }

        return j;
    }
}