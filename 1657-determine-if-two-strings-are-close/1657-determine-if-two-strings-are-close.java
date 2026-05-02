class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        Map<Character, Integer> mpWord1 = new HashMap<> ();
        Map<Character, Integer> mpWord2 = new HashMap<> ();

        for(char ch : word1.toCharArray()){
            mpWord1.put(ch, mpWord1.getOrDefault(ch, 0) + 1);
        }

        for(char ch : word2.toCharArray()){
            mpWord2.put(ch, mpWord2.getOrDefault(ch, 0) + 1);
        }

        if(!mpWord1.keySet().equals(mpWord2.keySet())){
            return false;
        }

        List<Integer> listWord1 = new ArrayList<> (mpWord1.values());
        List<Integer> listWord2 = new ArrayList<> (mpWord2.values());

        Collections.sort(listWord1);
        Collections.sort(listWord2);

        return listWord1.equals(listWord2);
    }
}