package com.practicum.oge_math;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class TasksFragment extends Fragment  {

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
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        Button button6 = view.findViewById(R.id.button6);

        Fragment Task6_19 = new Task6_19Fragment();

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newFr.setNewFragment(Task6_19);
                MainActivity mainActivity = (MainActivity) getActivity();
                assert mainActivity != null;
                mainActivity.setActiveFragment();
            }

        });

        return view;
    }
}