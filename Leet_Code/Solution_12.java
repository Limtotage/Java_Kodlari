class Solution_12 {
    public int maxOperations(int[] nums, int k) {
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] >= k) nums[i] = 0;
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, sonuc = 0;
        while (i < j) {
            if(nums[i]+nums[j]==k){
                sonuc++;
                i++;
                j--;
            }
            else if(nums[i]+nums[j]>k)j--;
            else i++;
        }
        return sonuc;
    }
}
