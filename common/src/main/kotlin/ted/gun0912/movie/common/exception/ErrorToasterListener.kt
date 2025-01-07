package ted.gun0912.movie.common.exception

fun interface ErrorToasterListener {
    fun showErrorToast(exceptionType: ExceptionType)
}
