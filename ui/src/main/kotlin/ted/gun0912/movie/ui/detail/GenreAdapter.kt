package ted.gun0912.movie.ui.detail

import android.view.ViewGroup
import ted.gun0912.movie.presentation.model.GenreModel
import ted.gun0912.movie.ui.R
import ted.gun0912.movie.ui.base.adapter.BaseAdapter
import ted.gun0912.movie.ui.base.adapter.BaseViewHolder
import ted.gun0912.movie.ui.databinding.ItemGenreBinding

class GenreAdapter : BaseAdapter<GenreModel, GenreAdapter.GenreViewHolder>() {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder =
        GenreViewHolder(parent)

    class GenreViewHolder(parent: ViewGroup) :
        BaseViewHolder<ItemGenreBinding, GenreModel>(parent, R.layout.item_genre) {
        override fun setData(data: GenreModel) {
            binding.genre = data
        }
    }
}
