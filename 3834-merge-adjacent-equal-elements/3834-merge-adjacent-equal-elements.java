class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        st.push(Long.valueOf(nums[0]));

        for(int i=1;i<nums.length;i++){
            Long curr = Long.valueOf(nums[i]);
            while(!st.isEmpty() && st.peek().equals(curr)){
                curr *=2;
                st.pop();
            }
            st.push(curr);
        }

        int size = st.size();
        List<Long> list = new ArrayList<>(Collections.nCopies(size, 0L));
        int i=0;
        
        while(!st.isEmpty())
        {
            list.set(size-i-1, st.pop());
            i++;
        }
        return list;
    }
}