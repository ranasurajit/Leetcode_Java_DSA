class Solution {
    /**
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(1)
     */
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // TC: O(N x log(N))
        List<String> folderResult = new ArrayList<String>();
        folderResult.add(folder[0]);
        for (int i = 1; i < folder.length; i++) { // TC: O(N)
            String current = folder[i];
            String last = folderResult.get(folderResult.size() - 1);
            last += "/";
            if (!current.startsWith(last)) {
                folderResult.add(current);
            }
        }
        return folderResult;
    }

    /**
     * TC: O(K x N + N x log(N) + N) ~ O(K x N)
     * SC: O(N)
     */
    public List<String> removeSubfoldersApproach(String[] folder) {
        List<String> folderResult = new ArrayList<String>();
        HashSet<String> hs = new HashSet<String>(); // SC: O(N)
        Arrays.sort(folder, (String a, String b) -> a.length() - b.length()); // TC: O(N x log(N))
        for (String s : folder) { // TC: O(N)
            String current = s;
            boolean isPresent = false;
            while (current.length() > 0) {
                int offset = getLastSlash(current); // TC: O(K)
                String parent = s.substring(0, offset);
                if (hs.contains(parent)) {
                    isPresent = true;
                    break;
                } else {
                    current = parent;
                }
            }
            if (!isPresent) {
                hs.add(s);
            }
        }
        for (String key : hs) {
            folderResult.add(key);
        }
        return folderResult;
    }

    /**
     * TC: O(K)
     * SC: O(1)
     */
    private int getLastSlash(String s) {
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '/') {
                return i;
            }
        }
        return 0;
    }
}
