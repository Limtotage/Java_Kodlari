class Solution_8 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int enbyk = 0;
        List<Boolean> list=new ArrayList<Boolean>();
        for(int x : candies){
            if(enbyk<x)enbyk=x;
        }
        int i=0;
        for(int x : candies){
            if(x+extraCandies>=enbyk){
                list.add(true);
                i++;
            }
            else{
                list.add(false);
                i++;
            }
        }
        return list;
    }
}
