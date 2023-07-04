import java.util.Stack;

public class decode_string {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                // Process the count of the repeated string
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (ch == '[') {
                // Process the start of the encoded string
                stringStack.push(result.toString());
                result.setLength(0); // Clear the result StringBuilder
                index++;
            } else if (ch == ']') {
                // Process the end of the encoded string
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(result);
                }
                result = decodedString;
                index++;
            } else {
                // Process individual characters
                result.append(ch);
                index++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String decodedString = decodeString(s);
        System.out.println("Decoded string: " + decodedString);
    }
}

