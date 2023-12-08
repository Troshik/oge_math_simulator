package com.practicum.oge_math;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;

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

        return view;
    }
}