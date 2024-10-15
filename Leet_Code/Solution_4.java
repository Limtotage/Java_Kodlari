class Solution_4 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n!=0||n!=flowerbed.length){
            if(flowerbed[n]==0&&(flowerbed[n-1]==1||flowerbed[n+1]==1)) return true;
            else return false;
        }
        else if(n==0){
            if(flowerbed[n]==0&&flowerbed[n+1]==1) return true;
            else return false;
        }
        else{
            if(flowerbed[n]==0&&flowerbed[n-1]==1) return true;
            else return false;
        }
    }
}
