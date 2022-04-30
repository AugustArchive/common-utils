/*
 * 🤹 common-utils: Common Kotlin utilities made for my personal usage.
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

package dev.floofy.utils.exposed

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.await
import kotlinx.coroutines.future.future
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Represents an asynchronous [transaction][Transaction].
 * @param scope The [coroutine scope][CoroutineScope] to use to execute the transaction
 * @param body The body to execute in the transaction.
 */
@OptIn(DelicateCoroutinesApi::class)
class AsyncTransaction<T>(
    private val scope: CoroutineScope = GlobalScope,
    private val body: Transaction.() -> T
) {
    /**
     * Executes this transaction and returns the value that is casted to [T].
     */
    suspend fun execute(): T = CoroutineScope(scope.coroutineContext).future {
        transaction {
            body()
        }
    }.await()
}

/**
 * Creates a new [asynchronous transaction][AsyncTransaction] and executes it.
 * @param scope The [coroutine scope][CoroutineScope] to use to execute the transaction
 * @param block The body to execute in the transaction.
 * @return The transaction result as [T].
 */
@OptIn(DelicateCoroutinesApi::class)
suspend fun <T> asyncTransaction(scope: CoroutineScope = GlobalScope, block: Transaction.() -> T): T =
    AsyncTransaction(scope, block).execute()
