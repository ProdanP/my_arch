package com.prodan.common_ui.styles

import android.content.Context
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

sealed class ItemColor {
    data class Simple(@ColorInt val color: Int) : ItemColor()
    data class StateList(@ColorRes val color: Int) : ItemColor()
}

fun TextView.setTextColor(color : ItemColor, context: Context) {
    when (color) {
        is ItemColor.Simple -> this.setTextColor(color.color)
        is ItemColor.StateList -> this.setTextColor(ContextCompat.getColorStateList(context, color.color))
    }
}