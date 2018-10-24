package io.blackbox_vision.wheelview;

import io.blackbox_vision.wheelview.data.WheelData;

public interface WheelViewListener {
    void onItemSelected(int position, WheelData wheelData);
}
