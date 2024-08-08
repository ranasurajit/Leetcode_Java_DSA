class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<Integer>());
            for (int j = 0; j < i + 1; j++) {
                list.get(i).add(1);
            }
        }
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                list.get(i).set(j, list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
        }
        return list;
    }
}
