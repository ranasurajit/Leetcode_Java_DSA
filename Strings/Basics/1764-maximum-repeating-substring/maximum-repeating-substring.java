class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }
}
