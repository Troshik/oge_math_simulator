package com.practicum.oge_math;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class DevelopFragment extends Fragment {

    public interface TasksInterface {
        void setNewFragment(Fragment fragment, String buttonNumber);
    }

    DevelopFragment.TasksInterface newFr;


    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            newFr = (DevelopFragment.TasksInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must be bebeeb");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_develop, container, false);
        ImageButton imageLastList = view.findViewById(R.id.imageLastList);

        Fragment TasksList = new TasksFragment();

        imageLastList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newFr.setNewFragment(TasksList, "0");
                MainActivity mainActivity = (MainActivity) getActivity();
                assert mainActivity != null;
                mainActivity.setActiveFragment(TasksList, "0");
            }
        });

        return view;
    }
}