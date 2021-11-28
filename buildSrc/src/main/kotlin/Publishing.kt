/**
 * Copyright (c) 2021 Noel <cutie@floofy.dev>
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

package gay.floof.utils.gradle

import org.gradle.api.provider.Property
import org.gradle.api.publish.maven.MavenPom

private infix fun <T> Property<T>.by(value: T) = set(value)
fun MavenPom.configurePom(module: String) {
    description by "Common Utilities for Noel's work."
    name by "commons-$module"
    url by "https://commons.floof.gay"

    developers {
        developer {
            timezone by "America/Phoenix"
            name by "Noel"
            url by "https://floof.gay"
        }
    }

    issueManagement {
        system by "GitHub"
        url by "https://github.com/auguwu/common-utils/issues"
    }

    licenses {
        license {
            name by "MIT"
            url by "https://opensource.org/licenses/MIT"
        }
    }

    scm {
        developerConnection by "scm:git:ssh://git@github.com:auguwu/common-utils.git"
        connection by "scm:git:ssh://github.com/auguwu/common-utils.git"
        url by "https://github.com/auguwu/common-utils"
    }
}
