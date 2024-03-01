/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int badIndex = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                badIndex = Math.min(badIndex, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return badIndex;
    }
}