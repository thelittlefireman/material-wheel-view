package io.blackbox_vision.wheelview.data;

public class SimpleWheelData implements WheelData{
    private String text;

    public SimpleWheelData(String text) {
        this.text = text;
    }
    @Override
    public String getWheelText() {
        return text;
    }
}
