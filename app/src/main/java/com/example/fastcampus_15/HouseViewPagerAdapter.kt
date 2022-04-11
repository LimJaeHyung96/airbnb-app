package com.example.fastcampus_15

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HouseViewPagerAdapter(val itemClicked: (HouseModel) -> Unit) : ListAdapter<HouseModel, HouseViewPagerAdapter.HouseItemViewHolder>(diffUtil) {

    inner class HouseItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(houseModel: HouseModel) {
            itemView.findViewById<TextView>(R.id.titleTextView).text = houseModel.title
            itemView.findViewById<TextView>(R.id.priceTextView).text = houseModel.price

            itemView.setOnClickListener {
                itemClicked(houseModel)
            }

            Glide.with(itemView.findViewById<ImageView>(R.id.thumbnailImageView).context)
                .load(houseModel.imageUrl)
                .into(itemView.findViewById<ImageView>(R.id.thumbnailImageView))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //여기서 inflate 된 view 가 inner class 에 들어감
        return HouseItemViewHolder(inflater.inflate(R.layout.item_house_detail_for_viewpager, parent, false))
    }

    override fun onBindViewHolder(holder: HouseItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<HouseModel>() {
            override fun areItemsTheSame(oldItem: HouseModel, newItem: HouseModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HouseModel, newItem: HouseModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}