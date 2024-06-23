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



public class Task1_5Fragment extends Fragment {

    public interface TasksInterface {
        void setNewFragment(Fragment fragment, String buttonNumber);
    }

    public void YourClass(Context context) {
    }

    TasksInterface newFr;
    String textAnsw1, textAnsw2, textAnsw3, textAnsw4, textAnsw5, actBtn;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            newFr = (Task1_5Fragment.TasksInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must be bebeeb");
        }
    }


    @SuppressLint("DiscouragedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task1_5, container, false);

        ImageButton imageLastList = view.findViewById(R.id.imageLastList);
        ImageButton infoBotttom = view.findViewById(R.id.infoButton);
        ImageButton closeBotttom = view.findViewById(R.id.closeButton);
        TextView textInfo = view.findViewById(R.id.textInfo);
        Button buttonTask1 = view.findViewById(R.id.buttonTask1);
        Button buttonTask2 = view.findViewById(R.id.buttonTask2);
        Button buttonTask3 = view.findViewById(R.id.buttonTask3);
        Button buttonTask4 = view.findViewById(R.id.buttonTask4);
        Button buttonTask5 = view.findViewById(R.id.buttonTask5);
        Button buttonTask6 = view.findViewById(R.id.buttonTask6);
        Button buttonTask7 = view.findViewById(R.id.buttonTask7);

        EditText editText1 = view.findViewById(R.id.filledTextField1);
        TextView trAnsw1 = view.findViewById(R.id.trAnswText1);
        Button answBottom1 = view.findViewById(R.id.answBtn1);
        Button solutBottom1 = view.findViewById(R.id.solutBtn1);
        ImageView imageTask1 = view.findViewById(R.id.imageTask1);
        TextView trFlAnsw1 = view.findViewById(R.id.trFlAnswText1);


        EditText editText2 = view.findViewById(R.id.filledTextField2);
        TextView trAnsw2 = view.findViewById(R.id.trAnswText2);
        Button answBottom2 = view.findViewById(R.id.answBtn2);
        Button solutBottom2 = view.findViewById(R.id.solutBtn2);
        ImageView imageTask2 = view.findViewById(R.id.imageTask2);
        TextView trFlAnsw2 = view.findViewById(R.id.trFlAnswText2);

        EditText editText3 = view.findViewById(R.id.filledTextField3);
        TextView trAnsw3 = view.findViewById(R.id.trAnswText3);
        Button answBottom3 = view.findViewById(R.id.answBtn3);
        Button solutBottom3 = view.findViewById(R.id.solutBtn3);
        ImageView imageTask3 = view.findViewById(R.id.imageTask3);
        TextView trFlAnsw3 = view.findViewById(R.id.trFlAnswText3);

        EditText editText4 = view.findViewById(R.id.filledTextField4);
        TextView trAnsw4 = view.findViewById(R.id.trAnswText4);
        Button answBottom4 = view.findViewById(R.id.answBtn4);
        Button solutBottom4 = view.findViewById(R.id.solutBtn4);
        ImageView imageTask4 = view.findViewById(R.id.imageTask4);
        TextView trFlAnsw4 = view.findViewById(R.id.trFlAnswText4);

        EditText editText5 = view.findViewById(R.id.filledTextField5);
        TextView trAnsw5 = view.findViewById(R.id.trAnswText5);
        Button answBottom5 = view.findViewById(R.id.answBtn5);
        Button solutBottom5 = view.findViewById(R.id.solutBtn5);
        ImageView imageTask5 = view.findViewById(R.id.imageTask5);
        TextView trFlAnsw5 = view.findViewById(R.id.trFlAnswText5);


        Bundle args = getArguments();
        if (args != null) {

            textAnsw1 = getString(getResources().getIdentifier("answ1_1_1", "string", requireContext().getPackageName()));
            imageTask1.setImageResource(getResources().getIdentifier("t1_1_1", "drawable", requireContext().getPackageName()));
            editText1.setText("");
            textAnsw2 = getString(getResources().getIdentifier("answ1_1_2", "string", requireContext().getPackageName()));
            imageTask2.setImageResource(getResources().getIdentifier("t1_1_2", "drawable", requireContext().getPackageName()));
            editText2.setText("");
            textAnsw3 = getString(getResources().getIdentifier("answ1_1_3", "string", requireContext().getPackageName()));
            imageTask3.setImageResource(getResources().getIdentifier("t1_1_3", "drawable", requireContext().getPackageName()));
            editText3.setText("");
            textAnsw4 = getString(getResources().getIdentifier("answ1_1_4", "string", requireContext().getPackageName()));
            imageTask4.setImageResource(getResources().getIdentifier("t1_1_4", "drawable", requireContext().getPackageName()));
            editText4.setText("");
            textAnsw5 = getString(getResources().getIdentifier("answ1_1_5", "string", requireContext().getPackageName()));
            imageTask5.setImageResource(getResources().getIdentifier("t1_1_5", "drawable", requireContext().getPackageName()));
            editText5.setText("");

            actBtn  = "1";

            Fragment TasksList = new TasksFragment();

            View.OnClickListener buttonClickListener = new View.OnClickListener() {
                @SuppressLint({"ResourceAsColor", "SetTextI18n"})
                @Override
                public void onClick(View v) {
                    String buttonName = getResources().getResourceEntryName(v.getId());
                    actBtn  = buttonName.substring(10);

                    int imageResourceId1 = getResources().getIdentifier("t1_" + actBtn + "_1", "drawable", requireContext().getPackageName());
                    int resourceId1 = getResources().getIdentifier("answ1_" + actBtn + "_1", "string", requireContext().getPackageName());
                    imageTask1.setImageResource(imageResourceId1);
                    trAnsw1.setText("");
                    trFlAnsw1.setText("");
                    textAnsw1 = getString(resourceId1);
                    editText1.setText("");

                    int imageResourceId2 = getResources().getIdentifier("t1_" + actBtn + "_2", "drawable", requireContext().getPackageName());
                    int resourceId2 = getResources().getIdentifier("answ1_" + actBtn + "_2", "string", requireContext().getPackageName());
                    imageTask2.setImageResource(imageResourceId2);
                    trAnsw2.setText("");
                    trFlAnsw2.setText("");
                    textAnsw2 = getString(resourceId2);
                    editText2.setText("");

                    int imageResourceId3 = getResources().getIdentifier("t1_" + actBtn + "_3", "drawable", requireContext().getPackageName());
                    int resourceId3 = getResources().getIdentifier("answ1_" + actBtn + "_3", "string", requireContext().getPackageName());
                    imageTask3.setImageResource(imageResourceId3);
                    trAnsw3.setText("");
                    trFlAnsw3.setText("");
                    textAnsw3 = getString(resourceId3);
                    editText3.setText("");

                    int imageResourceId4 = getResources().getIdentifier("t1_" + actBtn + "_4", "drawable", requireContext().getPackageName());
                    int resourceId4 = getResources().getIdentifier("answ1_" + actBtn + "_4", "string", requireContext().getPackageName());
                    imageTask4.setImageResource(imageResourceId4);
                    trAnsw4.setText("");
                    trFlAnsw4.setText("");
                    textAnsw4 = getString(resourceId4);
                    editText4.setText("");

                    int imageResourceId5 = getResources().getIdentifier("t1_" + actBtn + "_5", "drawable", requireContext().getPackageName());
                    int resourceId5 = getResources().getIdentifier("answ1_" + actBtn + "_5", "string", requireContext().getPackageName());
                    imageTask5.setImageResource(imageResourceId5);
                    trAnsw5.setText("");
                    trFlAnsw5.setText("");
                    textAnsw5 = getString(resourceId5);
                    editText5.setText("");
                }
            };

            View.OnClickListener buttonAnswer = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonNum = getResources().getResourceEntryName(v.getId());

                    String editTextName = "filledTextField" + buttonNum.substring(7);
                    int editTextId = getResources().getIdentifier(editTextName, "id", requireContext().getPackageName());
                    EditText editText = view.findViewById(editTextId);
                    String answEditText = editText.getText().toString();

                    String trAnswName = "answ1_" + actBtn + "_" + buttonNum.substring(7);
                    int trAnsId = getResources().getIdentifier(trAnswName, "string", requireContext().getPackageName());
                    String trAnsw = getString(trAnsId);


                    int trFlAnswId = getResources().getIdentifier("trFlAnswText" + buttonNum.substring(7), "id", requireContext().getPackageName());
                    TextView trFlAnsw = view.findViewById(trFlAnswId);


                    if (!answEditText.equals("")) {
                        if (answEditText.equals(trAnsw)) {
                            trFlAnsw.setTextColor(Color.GREEN);
                            trFlAnsw.setText(R.string.trueAnswer);
                        } else {
                            trFlAnsw.setTextColor(Color.RED);
                            trFlAnsw.setText(R.string.falseAnswer);
                        }
                    }

                }
            };

            View.OnClickListener buttonSolut = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonNum = getResources().getResourceEntryName(v.getId());

                    String trAnswName = "answ1_" + actBtn + "_" + buttonNum.substring(8);
                    int trAnsId = getResources().getIdentifier(trAnswName, "string", requireContext().getPackageName());
                    String trAnsw = getString(trAnsId);


                    int answTextId = getResources().getIdentifier("trAnswText" + buttonNum.substring(8), "id", requireContext().getPackageName());
                    TextView answText = view.findViewById(answTextId);


                    answText.setText(trAnsw);

                }
            };

            infoBotttom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textInfo.setVisibility(View.VISIBLE);
                    closeBotttom.setVisibility(View.VISIBLE);
                }
            });

            closeBotttom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textInfo.setVisibility(View.INVISIBLE);
                    closeBotttom.setVisibility(View.INVISIBLE);
                }
            });

            imageLastList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    newFr.setNewFragment(TasksList, "0");
                    MainActivity mainActivity = (MainActivity) getActivity();
                    assert mainActivity != null;
                    mainActivity.setActiveFragment(TasksList, "0");
                }
            });



            answBottom1.setOnClickListener(buttonAnswer);
            answBottom2.setOnClickListener(buttonAnswer);
            answBottom3.setOnClickListener(buttonAnswer);
            answBottom4.setOnClickListener(buttonAnswer);
            answBottom5.setOnClickListener(buttonAnswer);

            solutBottom1.setOnClickListener(buttonSolut);
            solutBottom2.setOnClickListener(buttonSolut);
            solutBottom3.setOnClickListener(buttonSolut);
            solutBottom4.setOnClickListener(buttonSolut);
            solutBottom5.setOnClickListener(buttonSolut);

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