class Solution {
    public double angleClock(int hour, int minutes) {
        int minutesDegree = minutes * 6;
        if(hour == 12) hour = 0;

        double hoursDegree = hour * 30 + (minutes / 2.0);

        double ans = Math.abs(minutesDegree - hoursDegree);
        return Math.min(ans, 360 - ans);
    }
}