class Solution {
    public int minimumPushes(String word) {
        int[] mapping = new int[26];
        for (char ch : word.toCharArray()) {
            mapping[ch - 'a']++;
        }
        Arrays.sort(mapping);
        int pushes = 0;
        int count = 0;
        for (int i = 25; i >= 0; i--) {
            if (mapping[i] > 0) {
                int occurence = mapping[i];
                /**
                 * as an alphabet can occur multiple times so
                 * number of pushes = occurence * (count / number of mapping keys + 1)
                 * when count = 9 pushes = 2 for a single alphabet
                 */
                pushes += occurence * ((count / 8) + 1);
                count++;
            }
        }
        return pushes;
    }
}
