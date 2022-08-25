package dev.floofy.utils.gradle.tests;

import static org.junit.jupiter.api.Assertions.*;

import dev.floofy.utils.gradle.ReleaseType;
import dev.floofy.utils.gradle.Version;
import org.junit.Test;

public class GradleExtensionsTest {
    @Test
    public void testVersion() {
        final var first = new Version(1, 0, 0, 2, ReleaseType.Alpha.INSTANCE);
        final var second = new Version(2, 1, 3, 5, ReleaseType.ReleaseCandidate.INSTANCE);

        assertNotEquals(true, first.equals(second));
        assertEquals(first, new Version(1, 0, 0, 2, ReleaseType.Alpha.INSTANCE));

        assertEquals("1.0-alpha.2", first.toString());
        assertEquals("2.1.3-rc.5", second.toString());
    }

    @Test
    public void testReleaseType() {
        final var alpha = ReleaseType.Alpha.INSTANCE;
        final var custom = new ReleaseType("heck");

        assertNotEquals(true, alpha.equals(custom));
        assertEquals(alpha, ReleaseType.Alpha.INSTANCE);

        assertEquals("alpha", alpha.getSuffix());
        assertNotEquals("owo", custom.getSuffix());
    }
}
