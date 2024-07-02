class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();
        Map<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if (!hm.containsKey(sorted)) {
                hm.put(sorted, new ArrayList<String>());
            }
            hm.get(sorted).add(s);
        }
        for (String key : hm.keySet()) {
            groups.add(hm.get(key));
        }
        return groups;
    }
}
