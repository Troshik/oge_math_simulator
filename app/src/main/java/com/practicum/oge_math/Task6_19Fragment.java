package com.practicum.oge_math;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class Task6_19Fragment extends Fragment {

    public interface TasksInterface {
        void setNewFragment(Fragment fragment, String buttonNumber);
    }

    TasksInterface newFr;
    String textAnsw;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task6_19, container, false);

        ImageButton imageLastList = view.findViewById(R.id.imageLastList);
        Button answBottom = view.findViewById(R.id.answBtn);
        Button solutBottom = view.findViewById(R.id.solutBtn);
        Button buttonTask1 = view.findViewById(R.id.buttonTask1);
        Button buttonTask2 = view.findViewById(R.id.buttonTask2);
        Button buttonTask3 = view.findViewById(R.id.buttonTask3);
        Button buttonTask4 = view.findViewById(R.id.buttonTask4);
        Button buttonTask5 = view.findViewById(R.id.buttonTask5);
        Button buttonTask6 = view.findViewById(R.id.buttonTask6);
        Button buttonTask7 = view.findViewById(R.id.buttonTask7);
        EditText editText = view.findViewById(R.id.filledTextField);
        TextView trFlAnsw = view.findViewById(R.id.trFlAnswText);
        TextView trAnsw = view.findViewById(R.id.trAnswText1);
        ImageView imageTask = view.findViewById(R.id.imageTask);
        TextView taskNum = view.findViewById(R.id.taskNum);


        Bundle args = getArguments();
            String taskNumber = args.getString("buttonNumber", "0");
            taskNum.setText("Задание " + taskNumber);


            textAnsw = getString(getResources().getIdentifier("answ" + taskNumber+ "_" + 1, "string", requireContext().getPackageName()));
            imageTask.setImageResource(getResources().getIdentifier("t" + taskNumber+ "_" + 1, "drawable", requireContext().getPackageName()));


            Fragment TasksList = new TasksFragment();

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String buttonName = getResources().getResourceEntryName(v.getId());

                int num = Integer.parseInt(buttonName.substring(10));

                // Выполняем нужные действия
//                buttonTask2.setBackgroundColor(R.color.nodarkblue);
//                buttonTask3.setBackgroundColor(R.color.nodarkblue);
//                buttonTask4.setBackgroundColor(R.color.nodarkblue);
//                buttonTask5.setBackgroundColor(R.color.nodarkblue);
//                buttonTask6.setBackgroundColor(R.color.nodarkblue);
//                buttonTask7.setBackgroundColor(R.color.nodarkblue);
//                buttonTask1.setTextColor(R.color.white);
//                buttonTask2.setTextColor(R.color.white);
//                buttonTask3.setTextColor(R.color.white);
//                buttonTask4.setTextColor(R.color.white);
//                buttonTask5.setTextColor(R.color.white);
//                buttonTask6.setTextColor(R.color.white);
//                buttonTask7.setTextColor(R.color.white);
//                v.setBackgroundResource(R.color.nodarkblue);
//                v.setBackgroundColor(R.color.nodarkblue);
//                ((Button) v).setTextColor(Color.BLACK);
                editText.setText("");
                String imageName = "t" + taskNumber+ "_" + num;
                String answName = "answ" + taskNumber+ "_" + num;
                int imageResourceId = getResources().getIdentifier(imageName, "drawable", requireContext().getPackageName());
                int resourceId = getResources().getIdentifier(answName, "string", requireContext().getPackageName());
                imageTask.setImageResource(imageResourceId);
                trFlAnsw.setText("");
                trAnsw.setText("");
                textAnsw = getString(resourceId);
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


            answBottom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!editText.getText().toString().equals("")) {
                        if (editText.getText().toString().equals(textAnsw)) {
                            trFlAnsw.setTextColor(Color.GREEN);
                            trFlAnsw.setText(R.string.trueAnswer);
                        } else {
                            trFlAnsw.setTextColor(Color.RED);
                            trFlAnsw.setText(R.string.falseAnswer);
                        }
                    }
                }
            });

            solutBottom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    trAnsw.setText(textAnsw);
                }
            });

            buttonTask1.setOnClickListener(buttonClickListener);
            buttonTask2.setOnClickListener(buttonClickListener);
            buttonTask3.setOnClickListener(buttonClickListener);
            buttonTask4.setOnClickListener(buttonClickListener);
            buttonTask5.setOnClickListener(buttonClickListener);
            buttonTask6.setOnClickListener(buttonClickListener);
            buttonTask7.setOnClickListener(buttonClickListener);
        return view;
    }


}