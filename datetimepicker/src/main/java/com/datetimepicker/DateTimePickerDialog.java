package com.datetimepicker;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;


import java.util.Calendar;

/**
 * Created by DSK02 on 9/16/2015.
 */
public class DateTimePickerDialog extends Dialog {
    private DateTimeListener dateTimeListener;

    public interface DateTimeListener {
        void onDateTimeSelected(int year, int month, int day, int hour, int min, int am_pm);
    }

    public DateTimePickerDialog(Context context, final boolean is24HrView, DateTimeListener listener) {
        super(context);
        // No title on the dialog window
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.dateTimeListener = listener;
        setContentView(R.layout.date_time_dialog);
        final DateTimePicker mDateTimePicker = (DateTimePicker) findViewById(R.id.DateTimePicker);
        // Setup TimePicker
        mDateTimePicker.setIs24hrView(is24HrView);
        // Update demo TextViews when the "OK" button is clicked
        ((Button) findViewById(R.id.SetDateTime)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDateTimePicker.clearFocus();
                // TODO Auto-generated method stub
                int year = mDateTimePicker.get(Calendar.YEAR);
                int month = (mDateTimePicker.get(Calendar.MONTH) + 1);
                int day = mDateTimePicker.get(Calendar.DAY_OF_MONTH);
                int hour = is24HrView ? mDateTimePicker.get(Calendar.HOUR_OF_DAY) : mDateTimePicker.get(Calendar.HOUR);
                int min = mDateTimePicker.get(Calendar.MINUTE);
                int aa = is24HrView ? -1 : mDateTimePicker.get(Calendar.AM_PM);
                dateTimeListener.onDateTimeSelected(year, month, day, hour, min, aa);
                dismiss();
            }
        });

        // Cancel the dialog when the "Cancel" button is clicked
        ((Button) findViewById(R.id.CancelDialog)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                cancel();
            }
        });

        // Reset Date and Time pickers when the "Reset" button is clicked
        ((Button) findViewById(R.id.ResetDateTime)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                mDateTimePicker.reset();
            }
        });


    }


}
