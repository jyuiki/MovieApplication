package ted.gun0912.movie.design.extension

import android.content.res.Resources
import android.util.TypedValue


inline val Int.dp: Int
    get() = toFloat().dp.toInt()

inline val Float.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )
