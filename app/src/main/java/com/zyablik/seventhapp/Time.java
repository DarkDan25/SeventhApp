package com.zyablik.seventhapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Time#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Time extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int my_hour;
    private int my_minute;

    public Time() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Time.
     */
    // TODO: Rename and change types and number of parameters
    public static Time newInstance(String param1, String param2) {
        Time fragment = new Time();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text_date = view.findViewById(R.id.text_time);
        Button button = view.findViewById(R.id.set_time);
        button.setOnClickListener(v -> {
            TimePickerDialog.OnTimeSetListener timeSetListener = (view1, hourOfDay, minute) -> text_date.setText(hourOfDay + ":" + minute);
            TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(), timeSetListener, my_hour, my_minute,true);
            timePickerDialog.show();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time, container, false);
    }
}