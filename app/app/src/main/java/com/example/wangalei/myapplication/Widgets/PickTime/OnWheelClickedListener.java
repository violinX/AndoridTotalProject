package com.example.wangalei.myapplication.Widgets.PickTime;

/**
 * Created by JD on 2017/4/7.
 */

public interface OnWheelClickedListener {
    /**
     * Callback method to be invoked when current item clicked
     * @param wheel the wheel2 view
     * @param itemIndex the index of clicked item
     */
    void onItemClicked(WheelView wheel, int itemIndex);
}
