package com.example.mvvmimagesearchapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.mvvmimagesearchapp.R
import com.example.mvvmimagesearchapp.data.models.UnsplashPhoto
import com.example.mvvmimagesearchapp.databinding.ItemPhotoBinding


class GalleryAdapter(private val listener: OnItemClickListener) : PagingDataAdapter<UnsplashPhoto, GalleryAdapter.ItemViewHolder>(
    PHOTO_COMPARATOR
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentPhoto = getItem(position)
        if (currentPhoto != null)
            holder.bind(currentPhoto)
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: UnsplashPhoto,
                newItem: UnsplashPhoto
            ) = oldItem == newItem
        }
    }
    interface OnItemClickListener {
        fun onItemClick(photo: UnsplashPhoto)
    }
    inner class ItemViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener{
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    item?.let {
                        listener.onItemClick(item)
                    }
                }
            }
        }

        fun bind(item: UnsplashPhoto) {
            binding.apply {
                Glide.with(itemView)
                    .load(item.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(ivPhoto)

                tvPhotographerName.text = item.user.username
            }
        }
    }

}