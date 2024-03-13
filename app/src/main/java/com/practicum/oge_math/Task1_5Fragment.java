package com.practicum.oge_math;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class Task1_5Fragment extends Fragment {

    public interface TasksInterface {
        void setNewFragment(Fragment fragment, String buttonNumber);
    }

    public void YourClass(Context context) {
    }

    TasksInterface newFr;
    String textAnsw;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task1_5, container, false);

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
        EditText editText = view.findViewById(R.id.getAnswerEdText);
        TextView trFlAnsw = view.findViewById(R.id.trFlAnswText);
        TextView trAnsw = view.findViewById(R.id.trAnswText);
        ImageView imageTask = view.findViewById(R.id.imageTask);


        Bundle args = getArguments();
        if (args != null) {
            String taskNumber = args.getString("buttonNumber", "0");

            int[] group1ResourcesAnsw = {R.string.answ6_1, R.string.answ6_2, R.string.answ6_3, R.string.answ6_4, R.string.answ6_5, R.string.answ6_6, R.string.answ6_7};
            int[] group2ResourcesAnsw = {R.string.answ7_1, R.string.answ7_2, R.string.answ7_3, R.string.answ7_4, R.string.answ7_5, R.string.answ7_6, R.string.answ7_7};
            int[] selectedGroupResourcesAnsw;

            int[] group1ResourcesTask = {R.drawable.t6_1, R.drawable.t6_2, R.drawable.t6_3, R.drawable.t6_4, R.drawable.t6_5, R.drawable.t6_6, R.drawable.t6_7};
            int[] group2ResourcesTask = {R.drawable.t7_1, R.drawable.t7_2, R.drawable.t7_3, R.drawable.t7_4, R.drawable.t7_5, R.drawable.t7_6, R.drawable.t7_7};
            int[] selectedGroupResourcesTask;

            switch (taskNumber) {
                case "6":
                    selectedGroupResourcesAnsw = group1ResourcesAnsw;
                    selectedGroupResourcesTask = group1ResourcesTask;
                    break;
                case "7":
                    selectedGroupResourcesAnsw = group2ResourcesAnsw;
                    selectedGroupResourcesTask = group2ResourcesTask;
                    break;
                default:
                    selectedGroupResourcesAnsw = new int[0];
                    selectedGroupResourcesTask = new int[0];
            }

            textAnsw = getString(selectedGroupResourcesAnsw[0]);
            imageTask.setImageResource(selectedGroupResourcesTask[0]);

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
            buttonTask1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int resourceId = selectedGroupResourcesAnsw[0];
                    imageTask.setImageResource(selectedGroupResourcesTask[0]);
                    trFlAnsw.setText("");
                    trAnsw.setText("");
                    textAnsw = getString(resourceId);
                }
            });
            buttonTask2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int resourceId = selectedGroupResourcesAnsw[1];
                    imageTask.setImageResource(selectedGroupResourcesTask[1]);
                    trFlAnsw.setText("");
                    trAnsw.setText("");
                    textAnsw = getString(resourceId);
                }
            });
            buttonTask3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int resourceId = selectedGroupResourcesAnsw[2];
                    imageTask.setImageResource(selectedGroupResourcesTask[2]);
                    trFlAnsw.setText("");
                    trAnsw.setText("");
                    textAnsw = getString(resourceId);
                }
            });
            buttonTask4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int resourceId = selectedGroupResourcesAnsw[3];
                    imageTask.setImageResource(selectedGroupResourcesTask[3]);
                    trFlAnsw.setText("");
                    trAnsw.setText("");
                    textAnsw = getString(resourceId);
                }
            });
            buttonTask5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int resourceId = selectedGroupResourcesAnsw[4];
                    imageTask.setImageResource(selectedGroupResourcesTask[4]);
                    trFlAnsw.setText("");
                    trAnsw.setText("");
                    textAnsw = getString(resourceId);
                }
            });
            buttonTask6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int resourceId = selectedGroupResourcesAnsw[5];
                    imageTask.setImageResource(selectedGroupResourcesTask[5]);
                    trFlAnsw.setText("");
                    trAnsw.setText("");
                    textAnsw = getString(resourceId);
                }
            });
            buttonTask7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int resourceId = selectedGroupResourcesAnsw[6];
                    imageTask.setImageResource(selectedGroupResourcesTask[6]);
                    trFlAnsw.setText("");
                    trAnsw.setText("");
                    textAnsw = getString(resourceId);
                }
            });
        }
        return view;
    }
}