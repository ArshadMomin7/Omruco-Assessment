package VersionString.tests;

import org.junit.Test;
import static org.junit.Assert.*;
public class VersionComparatorTest {
    @Test
    public void testCompareVersionsGreater() {
        String version1 = "1.2";
        String version2 = "1.1";
        int result = VersionComparator.compareVersions(version1, version2);
        assertTrue(result > 0);
    }

    @Test
    public void testCompareVersionsLess() {
        String version1 = "1.1";
        String version2 = "1.2";
        int result = VersionComparator.compareVersions(version1, version2);
        assertTrue(result < 0);
    }

    @Test
    public void testCompareVersionsEqual() {
        String version1 = "1.1.2";
        String version2 = "1.1.2";
        int result = VersionComparator.compareVersions(version1, version2);
        assertEquals(0, result);
    }

    @Test
    public void testCompareVersionsDifferentLength() {
        String version1 = "2.0";
        String version2 = "2";
        int result = VersionComparator.compareVersions(version1, version2);
        assertEquals(0, result);
    }
}
