class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int prefixLength = 0;
        while (true) {
            if (prefixLength < strs[0].length()) {
                char ch = strs[0].charAt(prefixLength);
                boolean isValid = true;
                for (int i = 1; i < strs.length; i++) {
                    if (prefixLength < strs[i].length() && strs[i].charAt(prefixLength) == ch) {
                        isValid = true;
                    } else {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    prefixLength++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return strs[0].substring(0, prefixLength);
    }
}
