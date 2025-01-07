package ted.gun0912.movie.common.extension

import ted.gun0912.movie.common.exception.ErrorUtil
import ted.gun0912.movie.common.util.loge
import java.io.PrintWriter
import java.io.StringWriter

fun Throwable.log() {
    val stringWriter = StringWriter()
    printStackTrace(PrintWriter(stringWriter))
    loge(stringWriter.toString())
}

fun Throwable.logException() {
    ErrorUtil.logException(this)
}

fun Throwable.handleError() {
    ErrorUtil.handleError(this)
}
