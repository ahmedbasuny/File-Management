package reverse;

import java.util.Stack;

public class ReverseSubstring {
    public static void main(String[] args) {
        String s1 = "abd(jnb)asdf";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + reverseSubstringParentheses(s1));
        String s2 = "abdjnbasdf";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + reverseSubstringParentheses(s2));
        String s3 = "dd(df)a(ghhh)";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + reverseSubstringParentheses(s3));
    }

    public static String reverseSubstringParentheses(String s) {
        char[] arrString = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (arrString[i] == '(') {
                stack.push(i);
            } else if (arrString[i] == ')') {
                int start = stack.pop() + 1;
                int end = i - 1;
                while (start < end) {
                    char temp = arrString[start];
                    arrString[start] = arrString[end];
                    arrString[end] = temp;
                    start++;
                    end--;
                }
            }
        }
        return new String(arrString);
    }
}
