class Solution_20 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> num_map = new HashMap<Integer, Integer>();
        for(int i : arr){
            num_map.put(i,num_map.getOrDefault(i,0)+1);
        }
        Set<Integer> myval = new HashSet<Integer>();
        for (int value : num_map.values()) {
            if(!myval.add(value)) return false;
        }
        return true;
    }
}
