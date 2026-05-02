class Solution {
    public List<Integer> getElements(int[] arr1, int[]arr2){
        Set<Integer> onlyInArr1 = new HashSet<> ();

        Set<Integer> existsInArr2 = new HashSet<> ();
        for(int num : arr2){
            existsInArr2.add(num);
        }

        for(int num : arr1){
            if(!existsInArr2.contains(num)){
                onlyInArr1.add(num);
            }
        }

        return new ArrayList<>(onlyInArr1);
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElements(nums1, nums2), getElements(nums2, nums1));
    }
}