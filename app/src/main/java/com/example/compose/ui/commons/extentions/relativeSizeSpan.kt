package com.example.compose.ui.commons.extentions

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan

inline fun SpannableStringBuilder.relativeSizeSpan(
    currentSize: Int,
    targetSize: Int,
    builderAction: SpannableStringBuilder.() -> Unit
): SpannableStringBuilder {
    val start = length
    builderAction()
    if (currentSize > 0) {
        val proportion = (targetSize.toFloat() / currentSize)
        setSpan(RelativeSizeSpan(proportion), start, length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
    }
    return this
}