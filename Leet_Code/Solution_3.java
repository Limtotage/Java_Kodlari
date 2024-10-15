class Solution_3 {
    public int[] productExceptSelf(int[] nums) {
        int[] result =new int[nums.length];
        int top=1,k=nums.length-1;
        for(int i = 0 ; i<=k;i++){
            result[i]=top;
            top*=nums[i];
        }
        top=1;
        for(int i = k ; i>=0;i--){
            result[i]*=top;
            top*=nums[i];
        }
        return result;
    }
}
