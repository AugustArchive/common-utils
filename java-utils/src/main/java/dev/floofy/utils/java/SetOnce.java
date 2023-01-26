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

package dev.floofy.utils.java;

import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a value that can be set once, but can be fetched at any time in the
 * application lifecycle.
 *
 * @author Noel (cutie@floofy.dev)
 * @since 24.08.22
 * @param <T> The resolvent type.
 */
public class SetOnce<T> {
    private final AtomicReference<T> ref = new AtomicReference<>();

    /**
     * Returns the value if it was set using the {@link #setValue(T)} function.
     * @return The reference that was set.
     * @throws IllegalStateException If the value was not set.
     */
    public @NotNull T getValue() {
        final var value = ref.get();
        if (value == null) throw new IllegalStateException("Cannot retrieve the value due to it not being set.");

        return value;
    }

    /**
     * Returns the value if it was ever set using {@link #setValue(T)}, or <code>null</code>
     * if not.
     */
    public @Nullable T getValueOrNull() {
        return ref.get();
    }

    /**
     * Sets a reference into this setter. This function can be called more than once,
     * but only the first invocation will be run and the rest will be discarded.
     *
     * @param value The reference to set.
     */
    public void setValue(@NotNull T value) {
        if (wasSet()) return;
        ref.set(value);
    }

    /**
     * Was the value set? <code>true</code>, otherwise <code>false</code>.
     */
    public boolean wasSet() {
        return ref.get() != null;
    }

    @Override
    public int hashCode() {
        final var value = ref.get();
        return value == null ? 0 : value.hashCode();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null) return false;
        if (!(that instanceof SetOnce<?> setter)) return false;

        if (!setter.wasSet()) return false;
        return getValue().equals(setter.getValue());
    }

    @Override
    public String toString() {
        final var value = getValueOrNull();
        return "SetOnceGetValue(%s)".formatted(value == null ? "<uninit>" : value);
    }
}
