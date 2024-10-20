class Daily_Solution_3 {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> operator = new ArrayDeque<>();
        for (char cur : expression.toCharArray()) {
            if (cur == ',' || cur == '(')
                continue;
            if (cur == 't' || cur == 'f' || cur == '!' || cur == '&' || cur == '|') {
                operator.push(cur);
            } else if (cur == ')') {
                boolean tmi = false, fmi = false;
                while (operator.peek() != '!' && operator.peek() != '&' && operator.peek() != '|') {
                    char pop = operator.pop();
                    if (pop == 't')
                        tmi = true;
                    if (pop == 'f')
                        fmi = true;
                }
                char op = operator.pop();
                if (op == '!') {
                    operator.push(tmi ? 'f' : 't');
                } else if (op == '&') {
                    operator.push(fmi ? 'f' : 't');
                } else {
                    operator.push(tmi ? 't' : 'f');
                }
            }
        }
        return operator.peek() == 't';
    }
}
