/**
 * Copyright 2010 Lukasz Szmit <devmail@szmit.eu>
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.datetimepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.datetimepicker.DateTimePickerDialog;

import java.util.Calendar;


public class DateTimePickerDemo extends Activity implements OnClickListener, DateTimePickerDialog.DateTimeListener {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.ButtonDemo).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        if (view.getId() == R.id.ButtonDemo)
            showDateTimeDialog();
    }

    private void showDateTimeDialog() {
        DateTimePickerDialog pickerDialog = new DateTimePickerDialog(this, false, this);
        pickerDialog.show();
    }

    @Override
    public void onDateTimeSelected(int year, int month, int day, int hour, int min, int am_pm) {
        String text = day + "/" + month + "/" + year + " - " + hour + ":" + min;
        if (am_pm != -1)
            text = text + (am_pm == Calendar.AM ? "AM" : "PM");
        ((TextView) findViewById(R.id.Date)).setText(text);
    }
}