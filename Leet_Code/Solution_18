class Solution_18 {
    public int pivotIndex(int[] nums) {
        int soltoplam=0;
        int sagtoplam = IntStream.of(nums).sum();
        for(int i =0;i<nums.length;i++){
            sagtoplam-=nums[i];
            if(sagtoplam==soltoplam) return i;
            else soltoplam+=nums[i];
        }
        return -1;
    }
}
