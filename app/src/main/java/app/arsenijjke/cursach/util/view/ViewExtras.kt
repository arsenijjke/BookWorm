package app.arsenijjke.cursach.util.view

import android.view.View

fun View.click(action: (v: View?) -> Unit) {
    setOnClickListener {
        action(it)
    }
}