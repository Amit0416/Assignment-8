class swap_string {
    public static boolean isStringSwapPossible(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int diffCount = 0;
        int[] diffIndices = new int[2];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (diffCount == 2) {
                    return false; // More than two differences, cannot swap
                }
                diffIndices[diffCount] = i;
                diffCount++;
            }
        }

        if (diffCount != 2) {
            return false; // Not exactly two differences, cannot swap
        }

        return s.charAt(diffIndices[0]) == goal.charAt(diffIndices[1])
                && s.charAt(diffIndices[1]) == goal.charAt(diffIndices[0]);
    }

    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";
        boolean isPossible = isStringSwapPossible(s, goal);
        System.out.println("Is string swap possible? " + isPossible);
    }
}

