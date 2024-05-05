class Solution {
    public int strStr(String haystack, String needle) {
        int supStrLen = haystack.length();
        int subStrLen = needle.length();
        if (supStrLen < subStrLen || 
            (supStrLen == subStrLen && !needle.equals(haystack))) {
            return -1;
        } else {
            int count = supStrLen - subStrLen;
            for (int i = 0; i <= count; i++) {
                if (haystack.charAt(i) != needle.charAt(0)) {
                    continue;
                }
                // String current = haystack.charAt(i) + "";
                String current = "";
                for (int j = i; j < subStrLen + i; j++) {
                    if (haystack.charAt(j) == needle.charAt(j - i)) {
                        current += haystack.charAt(j);
                    }
                }
                if (current.length() == subStrLen) {
                    return i;
                }
            }
        }
        return -1;
    }
}