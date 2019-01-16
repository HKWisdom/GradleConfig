package com.wisdom.gradleconfigdemo.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Create By zhurongkun
 *
 * @author zhurongkun
 * @version 2018/6/26 16:42 1.0
 * @time 2018/6/26 16:42
 * @project Launcher com.sei.robotics.launcher.widget
 * @description
 * @updateVersion 1.0
 * @updateTime 2018/6/26 16:42
 */

public class FocusGridLayoutManger extends GridLayoutManager {
    public FocusGridLayoutManger(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public FocusGridLayoutManger(Context context, int spanCount) {
        super(context, spanCount);
    }

    public FocusGridLayoutManger(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public View onInterceptFocusSearch(View focused, int direction) {
        View itemView = findContainingItemView(focused);
        int nextFocusdPosition = getPosition(itemView);
        int count = getItemCount();
        int spanCount = getSpanCount();
        if (getOrientation() == HORIZONTAL) {
            switch (direction) {
                case View.FOCUS_UP:
                    nextFocusdPosition--;
                    break;
                case View.FOCUS_DOWN:
                    nextFocusdPosition++;
                    break;
                default:
                    return super.onInterceptFocusSearch(focused, direction);
            }
        } else {
            switch (direction) {
                case View.FOCUS_LEFT:
                    nextFocusdPosition--;
                    break;
                case View.FOCUS_RIGHT:
                    nextFocusdPosition++;
                    break;
                default:
                    return super.onInterceptFocusSearch(focused, direction);
            }
        }
        if (nextFocusdPosition < 0 || nextFocusdPosition >= count) {
            return focused;
        } else {
            scrollToPosition(nextFocusdPosition);
            return findViewByPosition(nextFocusdPosition);
        }
    }
}
