package com.example.wangalei.myapplication.Widgets.PickTime;

/**
 * Created by JD on 2017/4/7.
 */

public interface OnWheelScrollListener {
    /**
     * Callback method to be invoked when scrolling started.
     * @param wheel the wheel2 view whose state has changed.
     */
    void onScrollingStarted(WheelView wheel);

    /**
     * Callback method to be invoked when scrolling ended.
     * @param wheel the wheel2 view whose state has changed.
     */
    void onScrollingFinished(WheelView wheel);
}
