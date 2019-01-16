package com.wisdom.gradleconfigdemo.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Create By zhurongkun
 *
 * @author zhurongkun
 * @version 2018/6/26 16:23 1.0
 * @time 2018/6/26 16:23
 * @project Launcher com.sei.robotics.launcher.widget
 * @description
 * @updateVersion 1.0
 * @updateTime 2018/6/26 16:23
 */

public class FocusLinearLayoutManager extends LinearLayoutManager {
    public FocusLinearLayoutManager(Context context) {
        super(context);
    }

    public FocusLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public FocusLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public View onInterceptFocusSearch(View focused, int direction) {
        int orientation = getOrientation();
        View itemView = findContainingItemView(focused);
        int nextFocusPosition = getPosition(itemView);
        if (orientation == HORIZONTAL) {
            switch (direction) {
                case View.FOCUS_LEFT:
                    nextFocusPosition--;
                    break;
                case View.FOCUS_RIGHT:
                    nextFocusPosition++;
                    break;
                default:
                    return super.onInterceptFocusSearch(focused, direction);
            }
        } else if (orientation == VERTICAL) {
            switch (direction) {
                case View.FOCUS_DOWN:
                    nextFocusPosition++;
                    break;
                case View.FOCUS_UP:
                    nextFocusPosition--;
                    break;
                default:
                    return super.onInterceptFocusSearch(focused, direction);
            }
        }
        if (nextFocusPosition < 0 || nextFocusPosition >= getItemCount()) {
            return focused;
        } else {
            scrollToPosition(nextFocusPosition);
            return findViewByPosition(nextFocusPosition);
//            return super.onInterceptFocusSearch(focused, direction);
        }
    }
}
