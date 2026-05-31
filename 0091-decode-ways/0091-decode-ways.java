class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numOfWays(s, 0, memo);
    }

    private int numOfWays(String s, int index, int[] memo) {
        if (index >= s.length()) return 1;
        if (memo[index] != -1) return memo[index];

        if (s.charAt(index) == '0') return 0;

        int ways = numOfWays(s, index + 1, memo);
        if (index + 1 < s.length()) {
            int twoDigitValue = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigitValue <= 26) {
                ways += numOfWays(s, index + 2, memo);
            }
        }
        
        return memo[index] = ways;
    }
}
