
import java.util.ArrayList;
import java.util.List;

public class anagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return indices;
        }

        int[] targetCount = new int[26];
        int[] windowCount = new int[26];
        int pLength = p.length();

        // Count the frequency of characters in string p
        for (char c : p.toCharArray()) {
            targetCount[c - 'a']++;
        }

        // Initialize the sliding window
        for (int i = 0; i < pLength; i++) {
            windowCount[s.charAt(i) - 'a']++;
        }

        // Compare the character frequencies in the sliding window with the target frequencies
        for (int i = pLength; i <= s.length(); i++) {
            // Check if the window's character frequencies match the target frequencies
            if (matches(targetCount, windowCount)) {
                indices.add(i - pLength);
            }

            // Slide the window by removing the leftmost character and adding the next character
            if (i < s.length()) {
                windowCount[s.charAt(i - pLength) - 'a']--;
                windowCount[s.charAt(i) - 'a']++;
            }
        }

        return indices;
    }

    private static boolean matches(int[] targetCount, int[] windowCount) {
        for (int i = 0; i < 26; i++) {
            if (targetCount[i] != windowCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagramIndices = findAnagrams(s, p);
        System.out.println("Start indices of anagrams: " + anagramIndices);
    }
}
