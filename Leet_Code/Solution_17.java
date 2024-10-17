class Solution_17 {
    public int largestAltitude(int[] gain) {
        int maks=0,temp=0;
        for(int i=0;i<gain.length;i++){
            temp+=gain[i];
            maks=Math.max(maks,temp);
        }
        return maks;
    }
}
