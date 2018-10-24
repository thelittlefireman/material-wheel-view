package io.blackbox_vision.wheelview.view;

import java.util.List;

public abstract class WheelViewAdapter<T> {

    private List<T> mList;

    private WheelView mWheelView;

    public void setWheelView(WheelView wheelView) {
        mWheelView = wheelView;
    }

    /**
     * Return the text to show in the WheelView for this item positions;
     * @param position postions in the list
     * @return Text to show
     */
    public abstract String getText(int position);

    /**
     * Return the item to show in the WheelView for this item positions;
     * @param position postions in the list
     * @return The item
     */
    public abstract T getItem(int position);

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    public abstract int getItemCount();
}
