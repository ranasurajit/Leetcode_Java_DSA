class Solution {
    /**
     * TC: O(K x N ^ 2)
     * SC: O(1)
     */
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (isPrefixAndSuffix(words[i], words[j])) { // TC: O(K)
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        // ensuring that String 'str1' is always smaller in length than String 'str2'
        if (str1.length() > str2.length()) {
            return false;
        }
        int length1 = str1.length();
        int length2 = str2.length();
        return str1.equals(str2.substring(0, length1)) &&
            str1.equals(str2.substring(length2 - length1, length2));
    }
}
