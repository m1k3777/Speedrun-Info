package dev.mvillasenor.speedruninfo.search.epoxy

import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import dev.mvillasenor.speedruninfo.R
import dev.mvillasenor.speedruninfo.epoxy.KotlinEpoxyHolder
import dev.mvillasenor.speedruninfo.extensions.loadImage


@EpoxyModelClass(layout = R.layout.item_game_result)
abstract class GameModel: EpoxyModelWithHolder<Holder>() {

    @EpoxyAttribute lateinit var name: String
    @EpoxyAttribute lateinit var logoUrl: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.nameView.text = name
        holder.logoView.loadImage(logoUrl)
    }
}

class Holder : KotlinEpoxyHolder() {
    val nameView by bind<TextView>(R.id.name)
    val logoView by bind<ImageView>(R.id.logo)
}
