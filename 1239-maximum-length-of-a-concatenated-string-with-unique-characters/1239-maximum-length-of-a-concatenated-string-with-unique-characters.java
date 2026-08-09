class Solution {
    private int result = 0;

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0)    return 0;

        dfs(arr, "", 0);
        return result;
    }


    private void dfs(List<String> arr, String seq, int index){
        boolean isUniqueChar = isUniqueChars(seq);

        if(isUniqueChar){
            result = Math.max(result, seq.length());
        }

        if(index == arr.size() || !isUniqueChar) return;

        for(int i = index; i < arr.size(); i++) {
            dfs(arr, seq + arr.get(i), i + 1);
        }
    }


    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();

        for(char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }

            set.add(c);
        }

        return true;
    }
}