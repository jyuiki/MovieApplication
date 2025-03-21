package ted.gun0912.movie.common.exception

open class IgnoreException @JvmOverloads constructor(
    message: String? = null,
    cause: Throwable? = null
) : Exception(message, cause)
