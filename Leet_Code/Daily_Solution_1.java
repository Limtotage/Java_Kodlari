class Daily_Solution_1 {
    public int maximumSwap(int num) {
        int uz = (int) (Math.log10(num) + 1), i = 0;
        int[] xyz = new int[uz];
        while (i < uz) {
            xyz[uz-i-1] = num % 10;
            num = (int) num / 10;
            i++;
        }
        int byk = 0, index = 0, j;
        i = 0;
        while (i < uz) {
            j = i + 1;
            if (j < uz) {
                while (j < uz) {
                    if (xyz[i] < xyz[j] && byk <= xyz[j]) {
                        
                        byk = xyz[j];
                        index = j;
                    }
                    j++;
                }
            }
            if (byk == 0) i++;
            else break;
        }
        if (byk != 0) {
            xyz[index] = xyz[i];
            xyz[i] = byk;
        }
        int result = 0;
        for (int temp = 0;temp<uz; temp++) {
            result *= 10;
            result += xyz[temp];
        }
        return result;
    }
}
