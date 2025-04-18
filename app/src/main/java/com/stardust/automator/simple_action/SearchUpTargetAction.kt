package com.stardust.automator.simple_action


import com.stardust.automator.UiObject

/**
 * Created by Stardust on 2017/1/27.
 */

class SearchUpTargetAction(action: Int, filter: FilterAction.Filter) : SearchTargetAction(action, filter) {
    private val mAble: Able = Able.ABLE_MAP.get(action)

    override fun searchTarget(node: UiObject?): UiObject? {
        var targetNode = node
        var i = 0
        while (targetNode != null && !mAble.isAble(targetNode)) {
            i++
            if (i > LOOP_MAX) {
                return null
            }
            targetNode = targetNode.parent()
        }
        return targetNode
    }

    override fun toString(): String {
        return "SearchUpTargetAction{" +
                "mAble=" + mAble + ", " +
                super.toString() +
                '}'.toString()
    }

    companion object {

        private val TAG = SearchUpTargetAction::class.java!!.getSimpleName()
        private val LOOP_MAX = 20
    }
}
