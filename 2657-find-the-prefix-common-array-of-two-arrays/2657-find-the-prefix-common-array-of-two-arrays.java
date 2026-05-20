class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        int n = A.length;
        int[] ans = new int[n];

        int cnt = 0;

        for(int i = 0; i < n; i++){
            if(A[i] == B[i]) cnt++;
            else{
                if(setA.contains(B[i])) cnt++;
                else setB.add(B[i]);

                if(setB.contains(A[i])) cnt++;
                else setA.add(A[i]);
            }

            ans[i] = cnt;
        }

        return ans;
    }
}