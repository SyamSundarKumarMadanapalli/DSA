class Solution {
    public String decodeString(String s) {
        Stack<Object> st = new Stack<> ();
        int curNum = 0;
        StringBuilder curStr = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '['){
                st.push(curStr.toString());
                st.push(curNum);
                curStr = new StringBuilder();
                curNum = 0;
            }else if(s.charAt(i) == ']'){
                int num = (int) st.pop();
                String prevStr = (String) st.pop();
                String repeated = curStr.toString().repeat(num);
                curStr = new StringBuilder(prevStr).append(repeated);
            }else if(Character.isDigit(s.charAt(i))){
                curNum = curNum * 10 + (s.charAt(i) - '0');
            }else{
                curStr.append(s.charAt(i));
            }
        }

        return curStr.toString();
    }
}