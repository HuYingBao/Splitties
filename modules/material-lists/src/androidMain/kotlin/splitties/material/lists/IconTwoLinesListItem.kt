/*
 * Copyright 2019 Louis Cognault Ayeva Derman. Use of this source code is governed by the Apache 2.0 license.
 */

package splitties.material.lists

import android.content.Context
import android.text.TextUtils.TruncateAt.END
import android.util.AttributeSet
import androidx.appcompat.R
import splitties.dimensions.dip
import splitties.resources.styledColorSL
import splitties.views.appcompat.imgTintList
import splitties.views.dsl.constraintlayout.bottomOfParent
import splitties.views.dsl.constraintlayout.centerHorizontally
import splitties.views.dsl.constraintlayout.centerVertically
import splitties.views.dsl.constraintlayout.endOfParent
import splitties.views.dsl.constraintlayout.lParams
import splitties.views.dsl.constraintlayout.startOfParent
import splitties.views.dsl.constraintlayout.startToStartOf
import splitties.views.dsl.constraintlayout.topOfParent
import splitties.views.dsl.constraintlayout.topToBottomOf
import splitties.views.dsl.core.add
import splitties.views.dsl.core.endMargin
import splitties.views.dsl.core.imageView
import splitties.views.dsl.core.startMargin
import splitties.views.dsl.core.textView
import splitties.views.dsl.core.verticalMargin
import splitties.views.dsl.core.wrapContent
import splitties.views.selectable.constraintlayout.SelectableConstraintLayout
import splitties.views.textAppearance

class IconTwoLinesListItem(
    context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0, disableDefaultTint: Boolean
) : SelectableConstraintLayout(context, attrs, defStyleAttr) {
    constructor(
        context: Context
    ) : this(context, null, disableDefaultTint = false)
    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : this(context, attrs, disableDefaultTint = false)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : this(context, attrs, defStyleAttr, disableDefaultTint = false)
    constructor(
        context: Context,
        disableDefaultTint: Boolean
    ) : this(context, null, disableDefaultTint = disableDefaultTint)

    val icon = imageView {
        if (!disableDefaultTint) imgTintList = styledColorSL(android.R.attr.textColorSecondary)
        isDuplicateParentStateEnabled = true
    }

    val firstLine = textView {
        ellipsize = END
        minLines = 1
        maxLines = 1
        textAppearance = R.style.TextAppearance_AppCompat_Subhead
        isDuplicateParentStateEnabled = true
    }

    val secondLine = textView {
        ellipsize = END
        minLines = 1
        maxLines = 1
        textAppearance = R.style.TextAppearance_AppCompat_Small
        isDuplicateParentStateEnabled = true
    }

    init {
        val iconSize = dip(24)
        add(icon, lParams(iconSize, iconSize) {
            verticalMargin = dip(8)
            startMargin = dip(16)
            startOfParent()
            centerVertically()
        })
        add(firstLine, lParams(height = wrapContent) {
            startMargin = dip(72)
            topMargin = dip(8)
            endMargin = dip(8)
            topOfParent()
            centerHorizontally()
        })
        add(secondLine, lParams(height = wrapContent) {
            endMargin = dip(8)
            bottomMargin = dip(8)
            startToStartOf(firstLine)
            topToBottomOf(firstLine)
            endOfParent()
            bottomOfParent()
        })
    }
}
