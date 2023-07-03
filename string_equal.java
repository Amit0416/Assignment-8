public class string_equal {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 2D array dp to store the minimum ASCII sum
        // of deleted characters for each prefix of s1 and s2.
        int[][] dp = new int[m + 1][n + 1];

        // Fill the first row and first column of dp.
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        // Fill the remaining cells of dp.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current characters are equal, no characters
                // need to be deleted, so the sum remains the same.
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the current characters are not equal, we have two options:
                    // 1. Delete the current character from s1 and find the minimum sum.
                    // 2. Delete the current character from s2 and find the minimum sum.
                    // Take the minimum of these two options.
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1),
                            dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        // The lowest ASCII sum of deleted characters to make two strings equal
        // is stored in the bottom-right cell of dp.
        return dp[m][n];
    }
}

