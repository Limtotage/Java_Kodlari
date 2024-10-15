class Solution_4 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int k=flowerbed.length;
        int i=0;
        if(n==0) return true;
        if(k==1){
            if(flowerbed[0]==0) return true;
            else return false;
        }
        for(i=0;i<k;i++){
            if(n==0) break;
            else if(i==0){
                if(flowerbed[i]==0&&flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    n--;
                }
                else continue;
            }
            else if(i==k-1){
                if(flowerbed[i]==0&&flowerbed[i-1]==0){
                    flowerbed[i]=1;
                    n--;
                }
                else continue;
            }
            else if(i>0&&i<k-1){
                if(flowerbed[i]==0&&flowerbed[i-1]==0&&flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    n--;
                }
                else continue;
            }
        }
        if(n==0) return true;
        else return false;
    }
}
