package org.autojs.autojs.core.ui.inflater.inflaters

import android.content.Context
import android.view.ViewGroup
import android.widget.ViewAnimator
import org.autojs.autojs.core.ui.inflater.ResourceParser
import org.autojs.autojs.core.ui.inflater.ViewCreator
import org.autojs.autojs.runtime.ScriptRuntime

open class ViewAnimatorInflater<V : ViewAnimator>(scriptRuntime: ScriptRuntime, resourceParser: ResourceParser) : FrameLayoutInflater<V>(scriptRuntime, resourceParser) {

    override fun getCreator(): ViewCreator<in V> = object : ViewCreator<ViewAnimator> {
        override fun create(context: Context, attrs: HashMap<String, String>, parent: ViewGroup?): ViewAnimator {
            return ViewAnimator(context)
        }
    }

}
