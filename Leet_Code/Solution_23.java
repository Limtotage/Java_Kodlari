class Solution_23 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> ast = new Stack<>();
        String saglam = "";
        int ps = 0, k;
        for (int i : asteroids) {
            boolean patladi = false;
            while (!ast.isEmpty() && i < 0 && ast.peek() > 0) {
                if (Math.abs(i) > ast.peek()) {
                    ast.pop();
                } else if (Math.abs(i) == ast.peek()) {
                    ast.pop();
                    patladi = true;
                    break;
                } else {
                    patladi = true;
                    break;
                }
            }
            if (!patladi)
                ast.push(i);
        }
        int[] result = new int[ast.size()];
        for (int p = ast.size() - 1; p >= 0; p--) {
            result[p] = ast.pop();
        }
        return result;
    }
}
