class SmallestInfiniteSet {
    private int current;
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> addedBack;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        addedBack = new HashSet<>();
        current = 1;
    }
    
    public int popSmallest() {
        if(!minHeap.isEmpty()){
            int removed = minHeap.poll();
            addedBack.remove(removed);
            return removed;
        }

        return current++;
    }
    
    public void addBack(int num) {
        if(num < current && !addedBack.contains(num)){
            minHeap.offer(num);
            addedBack.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */