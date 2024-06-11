class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> hm = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr1.length; i++) {
            hm.put(arr1[i], hm.getOrDefault(arr1[i], 0) + 1);
        }
        int p = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (hm.get(arr2[i]) != null && hm.get(arr2[i]) > 0) {
                arr1[p] = arr2[i];
                if (hm.get(arr2[i]) > 1) {
                    hm.put(arr2[i], hm.get(arr2[i]) - 1);
                } else {
                    hm.remove(arr2[i]);
                }
                p++;
            }
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            while (entry.getValue() > 0) {
                hm.put(key, hm.get(key) - 1);
                arr1[p] = key;
                p++;
            }
        }
        return arr1;
    }
}
