package dev.floofy.utils.gradle

/**
 * Represents a simple version class to use for versioning.
 * @param major The major version.
 * @param minor The minor version.
 * @param patch The patch version.
 * @param build The build version, this is only needed if the [ReleaseType] is not `None`.
 * @param release The release type to use for the finalized result. Defaults to [ReleaseType.None].
 */
class Version(
    private val major: Int,
    private val minor: Int,
    private val patch: Int,
    private val build: Int = 0,
    private val release: ReleaseType = ReleaseType.None
) {
    override fun toString(): String = buildString {
        append("$major.$minor")
        if (patch != 0) {
            append(".$patch")
        }

        if (release != ReleaseType.None) {
            append("-${release.suffix}")
        }

        if (build != 0 && release != ReleaseType.None) {
            append(".$build")
        }
    }
}
