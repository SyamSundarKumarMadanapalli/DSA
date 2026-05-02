class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<> ();

        for(int i = 0; i < asteroids.length; i++){
            boolean flag = true;
            while(st.size() > 0 && st.peek() > 0  && asteroids[i] < 0){
                if(st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                }else if( st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                    flag = false;
                    break;
                }else{ 
                    flag = false;
                    break;
                }
            }

            if(flag) st.push(asteroids[i]);
        }

        int n = st.size() - 1;
        int[] ans = new int[n + 1];
        while(st.size() > 0){
            ans[n--] = st.pop();
        }

        return ans;
    }
}