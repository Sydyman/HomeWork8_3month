package com.ex.homework8_3month

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ex.homework8_3month.databinding.ItemThemeBinding

class ThemeAdapter(
    var themeList: ArrayList<Theme>,
    var onClick: (theme: Theme) -> Unit
) : RecyclerView.Adapter<ThemeAdapter.ThemeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        return ThemeViewHolder(
            ItemThemeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = themeList.size

    override fun onBindViewHolder(holder: ThemeViewHolder, position: Int) {
        holder.onBind(themeList[position])
        holder.itemView.setOnClickListener {
            onClick(themeList[position])
        }
    }

    inner class ThemeViewHolder(var binding: ItemThemeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(theme: Theme) {
            binding.tvTheme.text = theme.text
            Glide.with(itemView.context).load(theme.image).into(binding.ivTheme)
            itemView.setOnClickListener {
                onClick.invoke(theme)
            }

        }
    }
}
