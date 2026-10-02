class Solution {
    public List<String> ans;

    public void solve(int open, int close, String s){
        if(open == 0 && close == 0) {
            ans.add(s);
            return;
        }

        if(open > 0) solve(open - 1, close, s + "(");
        if(close > open) solve(open, close - 1, s + ")");
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<String>();
        solve(n, n, "");
        return ans;
    }
}