class Solution {
    public int strStr(String haystack, String needle) {
        int supStrLen = haystack.length();
        int subStrLen = needle.length();
        for (int i = 0; i < supStrLen; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int start = i;
                int j = 0;
                while (j < subStrLen && start < supStrLen && 
                    haystack.charAt(start) == needle.charAt(j)) {
                    start++;
                    j++;
                    if (j == subStrLen) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
