package com.practicum.oge_math;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Task6_19Fragment extends Fragment {

    public interface TasksInterface {
        public void setNewFragment(Fragment fragment);
    }

    TasksInterface newFr;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            newFr = (TasksInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must be bebeeb");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task6_19, container, false);

        ImageButton imageLastList = view.findViewById(R.id.imageLastList);
        Button answBottom = view.findViewById(R.id.answBtn);
        EditText editText = view.findViewById(R.id.getAnswerEdText);
        TextView trFlAnsw = view.findViewById(R.id.trFlAnswText);

        Fragment TasksList = new TasksFragment();


        imageLastList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newFr.setNewFragment(TasksList);
                MainActivity mainActivity = (MainActivity) getActivity();
                assert mainActivity != null;
                mainActivity.setActiveFragment();
            }
        });

        answBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    if (editText.getText().toString().equals("3")) {
                        trFlAnsw.setTextColor(Color.GREEN);
                        trFlAnsw.setText(R.string.trueAnswer);
                    } else {
                        trFlAnsw.setTextColor(Color.RED);
                        trFlAnsw.setText(R.string.falseAnswer);
                    }
                }
            }
        });

        return view;
    }
}