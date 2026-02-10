/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Lily Kassaei
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {
        // 2D array to implement dynamic programming
        // Reserves index 0 for base case of an empty string that shares 0 letters
        int[][] tab =  new int[doc1.length() + 1][doc2.length() + 1];

        // Loop through both strings (index at 1 because 0 is reserved)
        for (int i = 1; i <= doc1.length(); i++) {
            for (int j = 1; j <= doc2.length(); j++) {
                // If the characters are equal
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    // Diagonal + 1 in array
                    tab[i][j] = tab[i - 1][j - 1] + 1;
                }
                // If they are not equal
                else {
                    // Get the max of the left square and square above
                    tab[i][j] = Math.max(tab[i - 1][j], tab[i][j - 1]);
                }
            }
        }
        // Return bottom right square
        return tab[doc1.length()][doc2.length()];
    }
}
