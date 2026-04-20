class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int prevElement = arr[n-1];
        arr[n-1] = -1;

        for(int i = n-2; i >= 0; i--){
            int curElement = arr[i];
            arr[i] = Math.max(prevElement, arr[i+1]);
            prevElement = curElement;
        }

        return arr;
    }
}