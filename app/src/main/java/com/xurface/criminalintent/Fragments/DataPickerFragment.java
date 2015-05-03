package com.xurface.criminalintent.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.xurface.criminalintent.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by luisoscategui on 5/3/15.
 */
public class DataPickerFragment extends DialogFragment {

    public static final String EXTRA_DATE = "com.xurface.EXTRA_DATE";
    private Date mDate;


    public static DataPickerFragment newInstance(Date date){
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_DATE, date);

        DataPickerFragment fragment = new DataPickerFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){


        mDate = (Date)getArguments().getSerializable(EXTRA_DATE);

        //Crear Calendar para obtener día, mes, año
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);


        DatePicker datePicker = (DatePicker)view.findViewById(R.id.dialog_date_datapicker);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Log.d("AÑO: ", "" +year);
                Log.d("MES: ", "" +monthOfYear);
                Log.d("DIA: ", "" +dayOfMonth);
                //de Año, mes, día a Date
                mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();

                //Update arguments
                getArguments().putSerializable(EXTRA_DATE, mDate);
            }
        });
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("OK", "OKOKOKOKKOKOKOKO");
                        sendResult(Activity.RESULT_OK);
                    }
                })
                .create();
    }

    public void sendResult(int resultCode){
        if(getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, mDate);

        getTargetFragment()
                .onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
