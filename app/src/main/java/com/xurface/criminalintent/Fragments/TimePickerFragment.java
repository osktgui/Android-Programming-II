package com.xurface.criminalintent.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TimePicker;

import com.xurface.criminalintent.R;

import java.sql.Time;
import java.util.Date;

/**
 * Created by luisoscategui on 5/3/15.
 */
public class TimePickerFragment extends DialogFragment {

    private Date mTime;
    private TimePicker mTimePicker;

    public static final String EXTRA_TIME = "com.xurface.timepicker";
    public static TimePickerFragment newInstance(Date date){
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_TIME, date);

        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.setArguments(bundle);

        return timePickerFragment;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        super.onCreateDialog(savedInstanceState);

//        mTime = (Time)getArguments().getSerializable(EXTRA_TIME);


        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_time, null);


        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.time_picker_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
    }
}
