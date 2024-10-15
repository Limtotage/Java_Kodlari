class Solution_7 {
    public void moveZeroes(int[] nums) {
        int i,k=nums.length;
        for(i=0;i<k-1;i++){
            if(nums[i]==0) 
            {
                nums[i]=nums[i+1];
                nums[i+1]=0;
            }
        }
    }
}
