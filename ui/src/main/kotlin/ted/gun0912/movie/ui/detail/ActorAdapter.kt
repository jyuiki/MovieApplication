package ted.gun0912.movie.ui.detail

import android.view.ViewGroup
import ted.gun0912.movie.component.Device
import ted.gun0912.movie.presentation.model.SummaryActorModel
import ted.gun0912.movie.ui.R
import ted.gun0912.movie.ui.base.adapter.BaseAdapter
import ted.gun0912.movie.ui.base.adapter.BaseViewHolder
import ted.gun0912.movie.ui.databinding.ItemSummaryActorBinding

class ActorAdapter(private val device: Device) :
    BaseAdapter<SummaryActorModel, ActorAdapter.GenreViewHolder>() {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder =
        GenreViewHolder(parent)

    inner class GenreViewHolder(parent: ViewGroup) :
        BaseViewHolder<ItemSummaryActorBinding, SummaryActorModel>(
            parent,
            R.layout.item_summary_actor
        ) {
        init {

            itemView.setOnClickListener {
                val actor = binding.actor ?: return@setOnClickListener
                device.showWebUrl(actor.profileDetailUrl)
            }
        }

        override fun setData(data: SummaryActorModel) {
            binding.actor = data
        }
    }
}
