class Solution_5 {
    public boolean increasingTriplet(int[] nums) {
        int i=0,k=nums.length,Ilk=Integer.MAX_VALUE,Ikinci=Integer.MAX_VALUE;
        for(i=0;i<k;i++){
            if(nums[i]<=Ilk){
                Ilk=nums[i];
            }
            else if(nums[i]<=Ikinci){
                Ikinci=nums[i];
            }
            else return true;
        }
        return false;  
    }
        
}
