package com.practicum.oge_math;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Task20_25Fragment extends Fragment {

    public interface TasksInterface {
        void setNewFragment(Fragment fragment, String buttonNumber);
    }

    TasksInterface newFr;
    private SQLiteDatabase db;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            newFr = (TasksInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must be bebeeb");
        }
    }


    @SuppressLint({"SetTextI18n", "DiscouragedApi", "SetJavaScriptEnabled"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task20_25, container, false);

        ImageButton imageLastList = view.findViewById(R.id.imageLastList);
        ImageButton infoBotttom = view.findViewById(R.id.infoButton);
        ImageButton closeBotttom = view.findViewById(R.id.closeButton);
        Button solveButton = view.findViewById(R.id.solveBtn);
        TextView textInfo = view.findViewById(R.id.textInfo);
        Button solutBottom = view.findViewById(R.id.solutBtn);
        Button buttonTask1 = view.findViewById(R.id.buttonTask1);
        Button buttonTask2 = view.findViewById(R.id.buttonTask2);
        Button buttonTask3 = view.findViewById(R.id.buttonTask3);
        Button buttonTask4 = view.findViewById(R.id.buttonTask4);
        Button buttonTask5 = view.findViewById(R.id.buttonTask5);
        Button buttonTask6 = view.findViewById(R.id.buttonTask6);
        Button buttonTask7 = view.findViewById(R.id.buttonTask7);
        WebView textTask = view.findViewById(R.id.imageTask1);
        WebView textAnsw = view.findViewById(R.id.imageAns);
        TextView decidedText = view.findViewById(R.id.decidedText);
        TextView taskNum = view.findViewById(R.id.taskNum);


        WebSettings webSettings1 = textTask.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        WebSettings webSettings2 = textAnsw.getSettings();
        webSettings2.setJavaScriptEnabled(true);

        DatabaseHelper dbHelper = new DatabaseHelper(requireContext());
        db = dbHelper.getWritableDatabase();

        final Integer[] t_num = {1};

        Bundle args = getArguments();
        if (args != null) {

            buttonTask1.setBackgroundColor(getResources().getColor(R.color.gray));

            String taskNumber = args.getString("buttonNumber", "0");
            taskNum.setText("Задание " + taskNumber);
            textInfo.setText(getString(getResources().getIdentifier("info_" + taskNumber, "string", requireContext().getPackageName())));

            int htmlResourceId1 = getResources().getIdentifier("t" + taskNumber+ "_" + 1, "raw", requireContext().getPackageName());
            String htmlContent1 = readHtmlFromRawResource(htmlResourceId1);
            textTask.getSettings().setJavaScriptEnabled(true);
            textTask.loadDataWithBaseURL(null, htmlContent1, "text/html", "UTF-8", null);

            int htmlResourceId2 = getResources().getIdentifier("a" + taskNumber+ "_" + 1, "raw", requireContext().getPackageName());
            String htmlContent2 = readHtmlFromRawResource(htmlResourceId2);
            textAnsw.getSettings().setJavaScriptEnabled(true);
            textAnsw.loadDataWithBaseURL(null, htmlContent2, "text/html", "UTF-8", null);

            Fragment TasksList = new TasksFragment();

            decidedText.setVisibility(View.GONE);
            solveButton.setText(getResources().getString(R.string.answ_0));

            Cursor cursor = db.rawQuery("SELECT col1 FROM answ WHERE rowNum = ?", new String[]{taskNumber});
            Integer tr_fl = 0;
            if (cursor.moveToFirst()) {
                tr_fl = cursor.getInt(0);
            }
            cursor.close();
            if ((tr_fl.equals(1))) {
                solveButton.setText(getResources().getString(R.string.answ_1));
                decidedText.setVisibility(View.VISIBLE);
            }
            View.OnClickListener buttonClickListener = new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {

                    buttonTask1.setBackgroundColor(getResources().getColor(R.color.lightblue));
                    buttonTask2.setBackgroundColor(getResources().getColor(R.color.lightblue));
                    buttonTask3.setBackgroundColor(getResources().getColor(R.color.lightblue));
                    buttonTask4.setBackgroundColor(getResources().getColor(R.color.lightblue));
                    buttonTask5.setBackgroundColor(getResources().getColor(R.color.lightblue));
                    buttonTask6.setBackgroundColor(getResources().getColor(R.color.lightblue));
                    buttonTask7.setBackgroundColor(getResources().getColor(R.color.lightblue));
                    v.setBackgroundColor(getResources().getColor(R.color.gray));

                    textAnsw.setVisibility(View.INVISIBLE);
                    String buttonName = getResources().getResourceEntryName(v.getId());

                    int num = Integer.parseInt(buttonName.substring(10));
                    t_num[0] = num;


                    String taskName = "t" + taskNumber+ "_" + num;
                    String answName = "a" + taskNumber+ "_" + num;
                    int htmlResourceId1 = getResources().getIdentifier(taskName, "raw", requireContext().getPackageName());
                    String htmlContent1 = readHtmlFromRawResource(htmlResourceId1);
                    textTask.getSettings().setJavaScriptEnabled(true);
                    textTask.loadDataWithBaseURL(null, htmlContent1, "text/html", "UTF-8", null);

                    int htmlResourceId2 = getResources().getIdentifier(answName, "raw", requireContext().getPackageName());
                    String htmlContent2 = readHtmlFromRawResource(htmlResourceId2);
                    textAnsw.getSettings().setJavaScriptEnabled(true);
                    textAnsw.loadDataWithBaseURL(null, htmlContent2, "text/html", "UTF-8", null);

                    decidedText.setVisibility(View.GONE);
                    solveButton.setText(getResources().getString(R.string.answ_0));
                    Cursor cursor = db.rawQuery("SELECT col" + num + " FROM answ WHERE rowNum = ?", new String[]{taskNumber});
                    Integer tr_fl = 0;
                    if (cursor.moveToFirst()) {
                        tr_fl = cursor.getInt(0);
                    }
                    cursor.close();
                    if ((tr_fl.equals(1))) {
                        solveButton.setText(getResources().getString(R.string.answ_1));
                        decidedText.setVisibility(View.VISIBLE);
                    }

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
                    textAnsw.setVisibility(View.VISIBLE);
                }
            });

            solveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Cursor cursor = db.rawQuery("SELECT col"+ t_num[0] +" FROM answ WHERE rowNum = ?", new String[]{taskNumber});
                    Integer tr_fl = 0;
                    if (cursor.moveToFirst()) {
                        tr_fl = cursor.getInt(0);
                    }
                    cursor.close();
                    if ((tr_fl.equals(1))) {
                        String query = "UPDATE answ SET col" + t_num[0] + " = 0 WHERE rowNum = " + taskNumber;
                        db.execSQL(query);
                        solveButton.setText(getResources().getString(R.string.answ_0));
                        decidedText.setVisibility(View.GONE);
                    }
                    else {
                        String query = "UPDATE answ SET col" + t_num[0] + " = 1 WHERE rowNum = " + taskNumber;
                        db.execSQL(query);
                        solveButton.setText(getResources().getString(R.string.answ_1));
                        decidedText.setVisibility(View.VISIBLE);
                    }
                }
            });

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
    private String readHtmlFromRawResource(int resourceId) {
        InputStream inputStream = getResources().openRawResource(resourceId);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}