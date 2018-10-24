package io.blackbox_vision.wheelview.data;

public class DatePickerData implements WheelData {

    private String dateText;

    public DatePickerData(String dateText) {
        this.dateText = dateText;
    }

    @Override
    public String getWheelText() {
        return dateText;
    }
}
