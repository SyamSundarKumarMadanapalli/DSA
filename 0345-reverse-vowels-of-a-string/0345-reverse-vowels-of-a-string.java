class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int rightPointer = s.length() - 1;
        int leftPointer = 0;

        while (leftPointer < rightPointer) {

            while (leftPointer < rightPointer
                    && !isVovel(chars[leftPointer])) {
                leftPointer++;
            }

            while (leftPointer < rightPointer
                    && !isVovel(chars[rightPointer])) {
                rightPointer--;
            }

            swap(chars, leftPointer, rightPointer);
            leftPointer++;
            rightPointer--;
        }

        return new String(chars);
    }


    private boolean isVovel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private void swap(char[] chars, int leftPointer, int rightPointer) {
        char temp = chars[rightPointer];
        chars[rightPointer] = chars[leftPointer];
        chars[leftPointer] = temp;
    }
}