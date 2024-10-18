class Solution_22 {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int say=0;
        HashMap<String,Integer> Satirlar = new HashMap<String,Integer>();
        for(int i=0;i<n;i++){
            StringBuilder Strmsat= new StringBuilder();
            for(int j=0;j<n;j++){
                Strmsat.append(grid[i][j]).append(",");
            }
            String x =Strmsat.toString();
            Satirlar.put(x,Satirlar.getOrDefault(x,0)+1);
        }
        for(int i=0;i<n;i++){
            StringBuilder Strmsut= new StringBuilder ();
            for(int j=0;j<n;j++){
                Strmsut.append(grid[j][i]).append(",");
            }
            if(Satirlar.containsKey(Strmsut.toString())) say+=Satirlar.get(Strmsut.toString());
        }
        return say;
    }
}
