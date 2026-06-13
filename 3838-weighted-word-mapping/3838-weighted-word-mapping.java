class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();

        for (String word : words) {
            int weight = 0;
            for (char ch : word.toCharArray()) {
                weight += weights[ch - 'a']; 
            }
            int mod = weight % 26;
            char resultChar = (char) ('z' - mod);
            res.append(resultChar);
        }
        return res.toString();
    }
}