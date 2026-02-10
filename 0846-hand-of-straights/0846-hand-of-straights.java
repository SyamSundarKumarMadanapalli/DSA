class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        while (!freq.isEmpty()) {
            int start = freq.firstKey();
            int count = freq.get(start); 
         
            for (int i = 0; i < groupSize; i++) {
                int current = start + i;
                Integer c = freq.get(current);
                if (c == null || c < count) {
                    return false; 
                }

                if (c == count) {
                    freq.remove(current);
                } else {
                    freq.put(current, c - count);
                }
            }
        }
        return true;
    }
}