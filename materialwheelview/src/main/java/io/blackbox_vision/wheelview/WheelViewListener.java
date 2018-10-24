package io.blackbox_vision.wheelview;

public interface WheelViewListener<T> {
    void onItemSelected(int position, T data);
}
