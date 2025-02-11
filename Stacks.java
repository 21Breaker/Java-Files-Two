import java.util.Stack;

public class StringReverser {
    public static void main(String[] args) {
        String str = "hello";
        String reversedStr = reverse(str);
        System.out.println("Reversed string: " + reversedStr);
    }

    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
