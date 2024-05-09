class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        String result = "";
        int p = 0, q = 0;
        while (p < str1.length() && q < str2.length()) {
            if (str1.charAt(p) != str2.charAt(q)) {
                break;
            }
            result += str1.charAt(p);
            p++;
            q++;
        }
        return result;
    }
}