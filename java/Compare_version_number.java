public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        
        for (int i = 0; i < a.length || i < b.length; i++) {
            if (i < a.length && i < b.length) {
                if (Integer.valueOf(a[i]) > Integer.valueOf(b[i])) {
                    return 1;
                } else if (Integer.valueOf(a[i]) < Integer.valueOf(b[i])) {
                    return -1;
                }
            } else if (i < a.length) {
                if (Integer.valueOf(a[i]) > 0) {
                    return 1;
                }
            } else {
                if (Integer.valueOf(b[i]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}