class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        for (int i = 0; i < sch.length; i++) {
            if (sch[i] != tch[i]) {
                return false;
            }
        }
        return true;
    }
}
