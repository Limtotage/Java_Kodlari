class Solution_19 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> list1 = new HashSet<>(),list2=new HashSet<>();
        int i =0;
        while(i<nums1.length||i<nums2.length){
            if(i<nums1.length) list1.add(nums1[i]);
            if(i<nums2.length) list2.add(nums2[i]);
            i++;
        }
        Set<Integer> num1uniq = new HashSet<>(list1);
        num1uniq.removeAll(list2); 
        Set<Integer> num2uniq = new HashSet<>(list2);
        num2uniq.removeAll(list1);
        List<List<Integer>> rslt = new ArrayList<>();
        rslt.add(new ArrayList<>(num1uniq));
        rslt.add(new ArrayList<>(num2uniq));
        return rslt;
    }
}
