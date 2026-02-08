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

        // TODO Complete this function to return the length of the longest shared substring.
        int count = 0;
        int len = 0;
        String str1 = "";
        String str2 = "";
        if (doc1.length() > doc2.length()) {
            len = doc2.length();
            str1 = doc2;
            str2 = doc1;
        }
        else {
            len = doc1.length();
            str1 = doc1;
            str2 = doc2;
        }
        int index = 1;
        for (int i = 0; i < len; i++) {
            if (i + index < len) {
                String curr = str1.substring(i, i + index);
                if (str2.contains(curr)) {
                    index++;
                }
                else {
                    index = 0;
                }
            }

        }
        return index;
    }
}
