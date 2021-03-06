package com.safeboda.githubuser.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.safeboda.githubuser.R

class FollowAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {
    var list: ArrayList<T?> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        var holder: BaseViewHolder<T>? = null
        when (viewType) {
            LIST_VIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_follow_item, parent, false)
                holder = FollowViewHolder(view)
            }
            PAGINATION_VIEW -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.pagination_indicator, parent, false)
                holder = PaginationViewHolder(view)
            }
        }
        return holder!!
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position] == null) {
            PAGINATION_VIEW
        } else {
            LIST_VIEW
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        if (holder is FollowViewHolder) {
            holder.bind(list[position])
        } else if (holder is PaginationViewHolder) {
            holder.bind(null)
        }
    }

    companion object {
        const val LIST_VIEW: Int = 0
        const val PAGINATION_VIEW: Int = 1
    }
}