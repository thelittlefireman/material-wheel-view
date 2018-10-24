package io.blackbox_vision.wheelview.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import io.blackbox_vision.wheelview.WheelViewListener;
import io.blackbox_vision.wheelview.view.DatePickerPopUpWindow;
import io.blackbox_vision.wheelview.view.WheelView;
import io.blackbox_vision.wheelview.view.WheelViewAdapter;


public final class MainActivity extends AppCompatActivity {
    private static final String DEFAULT_TEMPLATE = "dd/MM/yyyy";

    @NonNull
    private final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TEMPLATE, Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.date).setOnClickListener(v -> {
            final DatePickerPopUpWindow datePicker = new DatePickerPopUpWindow.Builder(getApplicationContext())
                    .setMinYear(1990)
                    .setMaxYear(2550)
                    .setSelectedDate("2013-11-11")
                    .setLocale(Locale.getDefault())
                    .setOnDateSelectedListener(this::onDateSelected)
                    .setConfirmButtonText("CONFIRM")
                    .setCancelButtonText("CANCEL")
                    .setConfirmButtonTextColor(Color.parseColor("#999999"))
                    .setCancelButtonTextColor(Color.parseColor("#009900"))
                    .setButtonTextSize(16)
                    .setViewTextSize(15)
                    .setShowShortMonths(true)
                    .setShowDayMonthYear(true)
                    .build();

            datePicker.show(this);
        });

        findViewById(R.id.province).setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Working on...", Toast.LENGTH_SHORT).show();
        });

        final WheelView wheelView = findViewById(R.id.loop_view);

        wheelView.setInitialPosition(2);
        wheelView.setIsLoopEnabled(false);
        wheelView.addOnLoopScrollListener((item, position) -> {
        });
        wheelView.setTextSize(12);
        wheelView.setWheelViewListener((WheelViewListener<String>) (position, data) -> System.out.println( data +
                                                                                                                   "selected"));

        wheelView.setWheelViewAdapter(new WheelViewAdapter() {
            @Override
            public String getText(int position) {
                return getList().get(position);
            }

            @Override
            public Object getItem(int position) {
                return getList().get(position);
            }

            @Override
            public int getItemCount() {
                return getList().size();
            }
        });
    }

    private void onDateSelected(int year, int month, int dayOfMonth) {
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());

        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        Toast.makeText(MainActivity.this, formatter.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
    }

    public List<String> getList() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add("DAY TEST:" + i);
        }

        return list;
    }
}
