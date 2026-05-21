class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefix = new HashSet<>();

        for (int val : arr1) {
            int num = val;
            while (num > 0) {
                prefix.add(num);
                num /= 10;
            }
        }

        int mx = Integer.MIN_VALUE;

        for (int val : arr2) {
            int num = val;
            int len = num == 0 ? 1 : (int) Math.log10(num) + 1;

            while (num > 0) {
                if (prefix.contains(num)) {
                    break;
                }
                num /= 10;
                len--;
            }

            mx = Math.max(mx, len);
        }

        return mx;
    }
}