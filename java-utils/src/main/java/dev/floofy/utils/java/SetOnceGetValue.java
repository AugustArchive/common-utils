package dev.floofy.utils.java;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Represents a value that can be set once, but can be fetched at any time in the
 * application lifecycle.
 *
 * @author Noel (cutie@floofy.dev)
 * @since 24.08.22
 * @param <T> The resolvent type.
 */
public class SetOnceGetValue<T> {
    private final AtomicReference<T> ref = new AtomicReference<>();

    /**
     * Returns the value if it was set using the {@link #setValue(T)} function.
     * @return The reference that was set.
     * @throws IllegalStateException If the value was not set.
     */
    public @NotNull T getValue() {
        final var value = ref.get();
        if (value == null)
            throw new IllegalStateException("Cannot retrieve the value due to it not being set.");

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
        if (!(that instanceof SetOnceGetValue<?> setter)) return false;

        if (!setter.wasSet()) return false;
        return getValue().equals(setter.getValue());
    }

    @Override
    public String toString() {
        final var value = getValueOrNull();
        return "SetOnceGetValue(%s)".formatted(value == null ? "<uninit>" : value);
    }
}
