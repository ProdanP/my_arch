package com.prodan.common_ui.recycler_adapter

import androidx.recyclerview.widget.DiffUtil
import com.prodan.common_ui.recycler_adapter.DelegateAdapterItem


internal class DelegateAdapterItemDiffCallback: DiffUtil.ItemCallback<DelegateAdapterItem>() {
    override fun areItemsTheSame(oldItem: DelegateAdapterItem, newItem: DelegateAdapterItem): Boolean =
            oldItem::class == newItem::class && oldItem.id() == newItem.id()

    override fun areContentsTheSame(oldItem: DelegateAdapterItem, newItem: DelegateAdapterItem): Boolean =
            oldItem.content == newItem.content

    override fun getChangePayload(oldItem: DelegateAdapterItem, newItem: DelegateAdapterItem): List<DelegateAdapterItem.Payloadable> =
            oldItem.payload(newItem)
}