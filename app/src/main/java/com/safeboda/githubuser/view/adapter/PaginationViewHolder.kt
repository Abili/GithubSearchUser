package com.safeboda.githubuser.view.adapter

import android.view.View
import kotlinx.android.synthetic.main.pagination_indicator.view.*

class PaginationViewHolder<T>(view: View) : BaseViewHolder<T>(view) {
    override fun bind(t: T?) {
        itemView.paginationIndicator.isIndeterminate = true
    }

}