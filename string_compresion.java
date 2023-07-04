public class string_compresion {
    public static int compress(char[] chars) {
        int index = 0; // Index to track the current position in the modified array
        int count = 1; // Count of consecutive repeating characters

        for (int i = 1; i <= chars.length; i++) {
            // If the current character is the same as the previous one, increment the count
            if (i < chars.length && chars[i] == chars[i - 1]) {
                count++;
            } else {
                // Append the character and its count to the modified array
                chars[index++] = chars[i - 1];

                // If the count is greater than 1, append its digits to the modified array
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[index++] = c;
                    }
                }

                count = 1; // Reset the count for the next group of consecutive characters
            }
        }

        return index; // Return the new length of the modified array
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = compress(chars);
        System.out.println("New length: " + newLength);
        System.out.println("Modified array: " + Arrays.toString(chars));
    }
}

