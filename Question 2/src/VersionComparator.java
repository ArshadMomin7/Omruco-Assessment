public class VersionComparator  {
     public static int compareVersions(String version1, String version2) {
        String[] v1Segments = version1.split("\\.");
        String[] v2Segments = version2.split("\\.");

        int minLength = Math.min(v1Segments.length, v2Segments.length);

        for (int i = 0; i < minLength; i++) {
            int v1Part = Integer.parseInt(v1Segments[i]);
            int v2Part = Integer.parseInt(v2Segments[i]);

            if (v1Part < v2Part) {
                return -1;
            } else if (v1Part > v2Part) {
                return 1;
            }
        }

        if (v1Segments.length < v2Segments.length) {
            return -1;
        } else if (v1Segments.length > v2Segments.length) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.2";
        String version2 = "1.1";
        int result = compareVersions(version1, version2);

        if (result < 0) {
            System.out.println(version1 + " is less than " + version2);
        } else if (result > 0) {
            System.out.println(version1 + " is greater than " + version2);
        } else {
            System.out.println(version1 + " is equal to " + version2);
        }
    }
}
