class Solution_15 {
    public int longestOnes(int[] nums, int k) {
        int zcnt=0,sl=0,maks=0;
        for(int sg =0;sg<nums.length;sg++){
            if(nums[sg]==0){
                zcnt++;
            }
            while(zcnt>k){
                if(nums[sl]==0){
                    zcnt--;
                }
                sl++;
            }
            maks = Math.max(maks, sg-sl+1);
        }
        return maks;
    }
}
