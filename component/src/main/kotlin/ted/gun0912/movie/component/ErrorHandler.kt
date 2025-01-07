package ted.gun0912.movie.component

interface ErrorHandler {

    fun logException(throwable: Throwable)

    fun logException(message: String)

    fun handleError(throwable: Throwable)

    fun handleUnExpectedCaseException(state: Any?)

    fun handleUnExpectedCaseException(description: String, state: Any?)
}
