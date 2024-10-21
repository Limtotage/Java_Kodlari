class Daily_Solution_4 {
    static class StackFrame {
        int start; 
        Set<String> seen; 
        StackFrame(int start, Set<String> seen) {
            this.start = start;
            this.seen = seen;
        }
    }
    public int maxUniqueSplit(String s) {
        Stack<StackFrame> stack = new Stack<>();
        stack.push(new StackFrame(0, new HashSet<>()));
        int maxSplits = 0;

        while (!stack.isEmpty()) {
            StackFrame current = stack.pop();
            int start = current.start;
            Set<String> seen = current.seen;
            if (start == s.length()) {
                maxSplits = Math.max(maxSplits, seen.size());
                continue;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                if (!seen.contains(substring)) {
                    Set<String> newSeen = new HashSet<>(seen);
                    newSeen.add(substring);
                    stack.push(new StackFrame(end, newSeen));
                }
            }
        }
        return maxSplits;
    }
    
}
