class Solution_13 {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0,maks;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        maks = sum;
        for(int i=k;i<nums.length;i++){
            sum=sum-nums[i-k]+nums[i];
            maks=Math.max(maks,sum);
        }
        return (double)maks/k;
    }
}
