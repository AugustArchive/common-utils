/*
 * 🤹 common-utils: Common Kotlin utilities made for my personal usage.
 * Copyright (c) 2021-2023 Noel <cutie@floofy.dev>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

        final var third = new Version(1, 0, 6, 5, ReleaseType.Beta.INSTANCE, true);
        assertEquals("1.0.6-beta.5", third.toString());

        final var fourth = new Version(21, 32, 0, 0, ReleaseType.None.INSTANCE, true);
        assertEquals("21.32.0", fourth.toString());
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
