package com.practicum.oge_math;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class Task20_25Fragment extends Fragment {

    public interface TasksInterface {
        void setNewFragment(Fragment fragment, String buttonNumber);
    }

    public void YourClass(Context context) {
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


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task20_25, container, false);

        ImageButton imageLastList = view.findViewById(R.id.imageLastList);
        Button solutBottom = view.findViewById(R.id.solutBtn);
        Button buttonTask1 = view.findViewById(R.id.buttonTask1);
        Button buttonTask2 = view.findViewById(R.id.buttonTask2);
        Button buttonTask3 = view.findViewById(R.id.buttonTask3);
        Button buttonTask4 = view.findViewById(R.id.buttonTask4);
        Button buttonTask5 = view.findViewById(R.id.buttonTask5);
        Button buttonTask6 = view.findViewById(R.id.buttonTask6);
        Button buttonTask7 = view.findViewById(R.id.buttonTask7);
        ImageView imageTask = view.findViewById(R.id.imageTask1);
        ImageView imageAnsw = view.findViewById(R.id.imageAns);
        TextView taskNum = view.findViewById(R.id.taskNum);

        Bundle args = getArguments();
        if (args != null) {

            String taskNumber = args.getString("buttonNumber", "0");
            taskNum.setText("Задание " + taskNumber);

            imageTask.setImageResource(getResources().getIdentifier("t" + taskNumber+ "_" + 1, "drawable", requireContext().getPackageName()));
            imageAnsw.setImageResource(getResources().getIdentifier("a" + taskNumber+ "_" + 1, "drawable", requireContext().getPackageName()));

            Fragment TasksList = new TasksFragment();
            View.OnClickListener buttonClickListener = new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    imageAnsw.setVisibility(View.INVISIBLE);
                    String buttonName = getResources().getResourceEntryName(v.getId());

                    int num = Integer.parseInt(buttonName.substring(10));

                    String imageName = "t" + taskNumber+ "_" + num;
                    String answName = "a" + taskNumber+ "_" + num;
                    int imageResourceId = getResources().getIdentifier(imageName, "drawable", requireContext().getPackageName());
                    int answResourceId = getResources().getIdentifier(answName, "drawable", requireContext().getPackageName());
                    imageTask.setImageResource(imageResourceId);
                    imageAnsw.setImageResource(answResourceId);
                }
            };

            imageLastList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    newFr.setNewFragment(TasksList, "0");
                    MainActivity mainActivity = (MainActivity) getActivity();
                    assert mainActivity != null;
                    mainActivity.setActiveFragment(TasksList, "0");
                }
            });

            solutBottom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageAnsw.setVisibility(View.VISIBLE);
                }
            });


            buttonTask1.setOnClickListener(buttonClickListener);
            buttonTask2.setOnClickListener(buttonClickListener);
            buttonTask3.setOnClickListener(buttonClickListener);
            buttonTask4.setOnClickListener(buttonClickListener);
            buttonTask5.setOnClickListener(buttonClickListener);
            buttonTask6.setOnClickListener(buttonClickListener);
            buttonTask7.setOnClickListener(buttonClickListener);
        }
        return view;
    }
}