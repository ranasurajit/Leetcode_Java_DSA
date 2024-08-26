class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i =  n - 1;
        int j = n - 1;
        /*
         * i and j pointers start from end of string so 
         * decrement i and j till point to a character
         */
        while (s.charAt(i) == ' ' && s.charAt(j) == ' ') {
            i--;
            j--;
        }
        /**
         * decrement i till it points again to a space
         */
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        // return the difference which gives the length of last word
        return j - i;
    }
}
