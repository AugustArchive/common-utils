@file:Suppress("UNUSED")
package dev.floofy.utils.gradle

/**
 * Returns the release type of specific [Version].
 */
enum class ReleaseType(val suffix: String) {
    /**
     * Represents a release candidate release, this is when this project
     * is almost through completion of a new release.
     */
    ReleaseCandidate("rc"),

    /**
     * Represents a snapshot release, that this is a pre-beta release and
     * bugs will occur.
     */
    Snapshot("snapshot"),

    /**
     * Represents a beta release, this might have some bugs to work out.
     */
    Beta("beta"),

    /**
     * Full release! The default release type for a [Version] object.
     */
    None("");

    companion object {
        fun fromOrNull(suffix: String): ReleaseType? = values().find { it.suffix == suffix }
        fun from(suffix: String): ReleaseType = fromOrNull(suffix) ?: error("Unknown release type: $suffix")
    }
}
