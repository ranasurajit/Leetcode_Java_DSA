class Solution {
    /**
     * Approach II : Using String Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (Character.isLetter(word.charAt(i))) {
                char ch = Character.toLowerCase(word.charAt(i));
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(word.charAt(i))) {
                return false;
            }
        }
        return hasVowel && hasConsonant;
    }

    /**
     * Approach I : Using String Simulation Approach
     *
     * TC: O(N)
     * SC: O(5) ~ O(1)
     */
    public boolean isValidApproachI(String word) {
        int n = word.length();
        if (n < 3) {
            return false;
        }
        Set<Character> vowels = 
            new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u')); // SC: O(5)
        boolean hasVowel = false;
        int countChars = 0;
        int countVowels = 0;
        int countDigits = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (Character.isDigit(word.charAt(i))) {
                countDigits++;
            }
            if (Character.isLetter(word.charAt(i))) {
                if (vowels.contains(Character.toLowerCase(word.charAt(i)))) {
                    hasVowel = true;
                    countVowels++;
                }
                countChars++;
            }
        }
        return countChars + countDigits == n && hasVowel && countChars - countVowels >= 1;
    }
}
