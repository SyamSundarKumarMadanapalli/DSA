class Solution {
    public int largestAltitude(int[] gain) {
        int iniHeight = 0;
        int maxAltitude = 0;

        for (int points : gain){
            iniHeight += points;
            maxAltitude = Math.max(iniHeight, maxAltitude);
        }

        return maxAltitude;
    }
}