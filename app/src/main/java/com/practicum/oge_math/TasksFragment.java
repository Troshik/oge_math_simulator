package com.practicum.oge_math;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class TasksFragment extends Fragment  {

    public interface TasksInterface {
        public void setNewFragment(Fragment fragment, String buttonNumber);
    }

    TasksInterface newFr;
    public ImageButton openTasksButton;

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
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);


        Button button6 = view.findViewById(R.id.button6);
        Button button7 = view.findViewById(R.id.button7);
        Button button8 = view.findViewById(R.id.button8);
        Button button9 = view.findViewById(R.id.button9);
        Button button10 = view.findViewById(R.id.button10);
        Button button11 = view.findViewById(R.id.button11);
        Button button12 = view.findViewById(R.id.button12);
        Button button13 = view.findViewById(R.id.button13);
        Button button14 = view.findViewById(R.id.button14);
        Button button15 = view.findViewById(R.id.button15);
        Button button16 = view.findViewById(R.id.button16);
        Button button17 = view.findViewById(R.id.button17);
        Button button18 = view.findViewById(R.id.button18);
        Button button19 = view.findViewById(R.id.button19);
        Button button20 = view.findViewById(R.id.button20);
        Button button21 = view.findViewById(R.id.button21);
        Button button22 = view.findViewById(R.id.button22);
        Button button23 = view.findViewById(R.id.button23);
        Button button24 = view.findViewById(R.id.button24);
        Button button25 = view.findViewById(R.id.button25);

        Fragment Task6_19 = new Task6_19Fragment();
        Fragment Task20_25 = new Task20_25Fragment();

        View mainView = inflater.inflate(R.layout.activity_main, container, false);
        openTasksButton = mainView.findViewById(R.id.openTasksButton);
        openTasksButton.setColorFilter(R.color.nodarkblue);

        View.OnClickListener buttonClickListener6_19 = new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String buttonName = getResources().getResourceEntryName(v.getId());
                String num = buttonName.substring(6);
                newFr.setNewFragment(Task6_19, num);
                MainActivity mainActivity = (MainActivity) getActivity();
                assert mainActivity != null;
                mainActivity.setActiveFragment(Task6_19, num);

            }
        };

        View.OnClickListener buttonClickListener20_25 = new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String buttonName = getResources().getResourceEntryName(v.getId());
                String num = buttonName.substring(6);
                newFr.setNewFragment(Task20_25, num);
                MainActivity mainActivity = (MainActivity) getActivity();
                assert mainActivity != null;
                mainActivity.setActiveFragment(Task20_25, num);

            }
        };

        button6.setOnClickListener(buttonClickListener6_19);
        button7.setOnClickListener(buttonClickListener6_19);
        button8.setOnClickListener(buttonClickListener6_19);
        button9.setOnClickListener(buttonClickListener6_19);
        button10.setOnClickListener(buttonClickListener6_19);
        //button11.setOnClickListener(buttonClickListener6_19);
        button12.setOnClickListener(buttonClickListener6_19);
        button13.setOnClickListener(buttonClickListener6_19);
        button14.setOnClickListener(buttonClickListener6_19);
        button15.setOnClickListener(buttonClickListener6_19);
        button16.setOnClickListener(buttonClickListener6_19);
        button17.setOnClickListener(buttonClickListener6_19);
        button18.setOnClickListener(buttonClickListener6_19);
        button19.setOnClickListener(buttonClickListener6_19);
        button20.setOnClickListener(buttonClickListener20_25);
        button21.setOnClickListener(buttonClickListener20_25);

        return view;
    }
}