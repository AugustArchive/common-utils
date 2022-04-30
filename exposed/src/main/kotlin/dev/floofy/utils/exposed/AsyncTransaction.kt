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
suspend fun <T> asyncTransaction(scope: CoroutineScope = GlobalScope, block: Transaction.() -> T): T
    = AsyncTransaction(scope, block).execute()
