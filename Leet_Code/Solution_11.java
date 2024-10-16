class Solution_10 {
    public int maxArea(int[] height) {
        int max=0,uz=height.length,i=0;
        int j=uz-1;
        while(j>i){
            if(Math.min(height[i],height[j])*(j-i)>max) max=Math.min(height[i],height[j])*(j-i);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;   
    }
}
