class Solution_20 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> num_map = new HashMap<Integer, Integer>();
        for(int i : arr){
            if(num_map.containsKey(i)){
                num_map.replace(i, num_map.get(i)+1);
            }
            else{
                num_map.put(i,1);
            }
        }
        Set<Integer> myval = new HashSet<Integer>();
        for (int value : num_map.values()) {
            if(!myval.add(value)) return false;
        }
        return true;
    }
}
