class Solution {
    public String reverseParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Remember where this bracket starts
                stack.push(sb.length());

            } else if (ch == ')') {
                // Reverse only the part inside brackets
                int start = stack.pop();
                reverse(sb, start, sb.length() - 1);

            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    private void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }
}