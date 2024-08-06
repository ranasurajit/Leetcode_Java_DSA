class Solution {
    public int minimumPushes(String word) {
        int[] mapping = new int[26]; // to map the alphabets to find frequency
        for (char ch : word.toCharArray()) {
            mapping[ch - 'a']++;
        }
        int pushes = 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (mapping[i] > 0) {
                /**
                 * number of pushes = count / number of mapping keys + 1 
                 * when count = 9 pushes = 2
                 */
                pushes += (count / 8) + 1;
                count++;
            }
        }
        return pushes;
    }
}
