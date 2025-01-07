package ted.gun0912.movie.ui.list

import androidx.recyclerview.widget.DiffUtil
import ted.gun0912.movie.presentation.model.SummaryMovieModel

class SummaryMovieDiffCallback(
    private val oldList: List<SummaryMovieModel>,
    private val newList: List<SummaryMovieModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}
