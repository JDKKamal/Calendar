package com.jdkgroup.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.darwindeveloper.onecalendar.clases.Day;
import com.darwindeveloper.onecalendar.views.OneCalendarView;

import java.util.Calendar;
import java.util.Date;

public class OneCalendar extends AppCompatActivity {

    private AppCompatActivity appCompatActivity;
    private OneCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_calendar_activity);

        appCompatActivity = this;

        calendarView = (OneCalendarView) findViewById(R.id.oneCalendar);

        calendarView.setOneCalendarClickListener(new OneCalendarView.OneCalendarClickListener() {
            @Override
            public void dateOnClick(Day day, int position) {

            }

            @Override
            public void dateOnLongClick(Day day, int position) {

            }
        });


        calendarView.setOnCalendarChangeListener(new OneCalendarView.OnCalendarChangeListener() {
            @Override
            public void prevMonth() {

            }

            @Override
            public void nextMonth() {

            }
        });

        initCalendar();

    }


    private void initCalendar() {
        calendarView.setOnCalendarChangeListener(new OneCalendarView.OnCalendarChangeListener() {

            @Override
            public void prevMonth() {
                Toast.makeText(appCompatActivity, calendarView.getStringMonth(calendarView.getMonth()) + " " + calendarView.getYear(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void nextMonth() {
                Toast.makeText(appCompatActivity, calendarView.getStringMonth(calendarView.getMonth()) + " " + calendarView.getYear(), Toast.LENGTH_SHORT).show();
            }
        });

        calendarView.setOneCalendarClickListener(new OneCalendarView.OneCalendarClickListener() {

            @Override
            public void dateOnClick(Day day, int position) {
                Date date = day.getDate();
                int year = date.getYear();
                int month = date.getMonth();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int numDay = cal.get(Calendar.DAY_OF_MONTH);
                Toast.makeText(appCompatActivity, numDay + " " + calendarView.getStringMonth(month) + " " + year, Toast.LENGTH_SHORT).show();

                if (calendarView.isDaySelected(position)) {
                    calendarView.removeDaySeleted(position);
                } else {
                    calendarView.addDaySelected(position);
                }
            }

            @Override
            public void dateOnLongClick(Day day, int position) {

            }
        });
    }
}
