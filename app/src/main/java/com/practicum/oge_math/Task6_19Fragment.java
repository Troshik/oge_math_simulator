package com.practicum.oge_math;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Task6_19Fragment extends Fragment {

    public interface TasksInterface {
        void setNewFragment(Fragment fragment, String buttonNumber);
    }

    TasksInterface newFr;
    String textAnsw;
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



    @SuppressLint({"SetTextI18n", "SetJavaScriptEnabled", "DiscouragedApi"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task6_19, container, false);

        ImageButton imageLastList = view.findViewById(R.id.imageLastList);
        Button answBottom = view.findViewById(R.id.answBtn);
        Button solutBottom = view.findViewById(R.id.solutBtn);
        Button unsolveButton = view.findViewById(R.id.unsolveBtn);
        ImageButton infoBotttom = view.findViewById(R.id.infoButton);
        ImageButton closeBotttom = view.findViewById(R.id.closeButton);
        Button buttonTask1 = view.findViewById(R.id.buttonTask1);
        Button buttonTask2 = view.findViewById(R.id.buttonTask2);
        Button buttonTask3 = view.findViewById(R.id.buttonTask3);
        Button buttonTask4 = view.findViewById(R.id.buttonTask4);
        Button buttonTask5 = view.findViewById(R.id.buttonTask5);
        Button buttonTask6 = view.findViewById(R.id.buttonTask6);
        Button buttonTask7 = view.findViewById(R.id.buttonTask7);
        EditText editText = view.findViewById(R.id.filledTextField);
        TextView textInfo = view.findViewById(R.id.textInfo);
        TextView decidedText = view.findViewById(R.id.decidedText);
        TextView trFlAnsw = view.findViewById(R.id.trFlAnswText);
        TextView trAnsw = view.findViewById(R.id.trAnswText1);
        WebView textTask = view.findViewById(R.id.textTask);
        TextView taskNum = view.findViewById(R.id.taskNum);

        WebSettings webSettings = textTask.getSettings();
        webSettings.setJavaScriptEnabled(true);

        DatabaseHelper dbHelper = new DatabaseHelper(requireContext());
        db = dbHelper.getWritableDatabase();

        final Integer[] t_num = {1};


        Bundle args = getArguments();
        assert args != null;
            String taskNumber = args.getString("buttonNumber", "0");
            taskNum.setText("Задание " + taskNumber);
            textInfo.setText(getString(getResources().getIdentifier("info_" + taskNumber, "string", requireContext().getPackageName())));
            buttonTask1.setBackgroundColor(getResources().getColor(R.color.gray));

            textAnsw = getString(getResources().getIdentifier("answ" + taskNumber + "_" + 1, "string", requireContext().getPackageName()));
            int htmlResourceId = getResources().getIdentifier("t" + taskNumber + "_" + 1, "raw", requireContext().getPackageName());
            String htmlContent = readHtmlFromRawResource(htmlResourceId);
            textTask.getSettings().setJavaScriptEnabled(true);
            textTask.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null);

            Fragment TasksList = new TasksFragment();

        Cursor cursor = db.rawQuery("SELECT col1 FROM answ WHERE rowNum = ?", new String[]{taskNumber});
        Integer tr_fl = 0;
        if (cursor.moveToFirst()) {
            tr_fl = cursor.getInt(0);
        }
        cursor.close();
        if ((tr_fl.equals(1))) {
            unsolveButton.setVisibility(View.VISIBLE);
            decidedText.setVisibility(View.VISIBLE);
        }

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String buttonName = getResources().getResourceEntryName(v.getId());

                int num = Integer.parseInt(buttonName.substring(10));
                t_num[0] = num;

                // Выполняем нужные действия
                buttonTask1.setBackgroundColor(getResources().getColor(R.color.lightblue));
                buttonTask2.setBackgroundColor(getResources().getColor(R.color.lightblue));
                buttonTask3.setBackgroundColor(getResources().getColor(R.color.lightblue));
                buttonTask4.setBackgroundColor(getResources().getColor(R.color.lightblue));
                buttonTask5.setBackgroundColor(getResources().getColor(R.color.lightblue));
                buttonTask6.setBackgroundColor(getResources().getColor(R.color.lightblue));
                buttonTask7.setBackgroundColor(getResources().getColor(R.color.lightblue));
                v.setBackgroundColor(getResources().getColor(R.color.gray));

                unsolveButton.setVisibility(View.INVISIBLE);
                decidedText.setVisibility(View.GONE);
                Cursor cursor = db.rawQuery("SELECT col" + num + " FROM answ WHERE rowNum = ?", new String[]{taskNumber});
                Integer tr_fl = 0;
                if (cursor.moveToFirst()) {
                    tr_fl = cursor.getInt(0);
                }
                cursor.close();
                if ((tr_fl.equals(1))) {
                    unsolveButton.setVisibility(View.VISIBLE);
                    decidedText.setVisibility(View.VISIBLE);
                }


                editText.setText("");
                String htmlName = "t" + taskNumber+ "_" + num;//String imageName = "t" + taskNumber+ "_" + num;
                String answName = "answ" + taskNumber+ "_" + num;
                int htmlResourceId = getResources().getIdentifier(htmlName, "raw", requireContext().getPackageName());//int imageResourceId = getResources().getIdentifier(imageName, "drawable", requireContext().getPackageName());
                int resourceId = getResources().getIdentifier(answName, "string", requireContext().getPackageName());

                String htmlContent = readHtmlFromRawResource(htmlResourceId);

                textTask.getSettings().setJavaScriptEnabled(true);
                textTask.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null);

                //textTask.setText(Html.fromHtml(htmlContent.toString(), Html.FROM_HTML_MODE_LEGACY));
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
                            showCorrectAnswerMessage(trFlAnsw);
                            changeButtonColor(answBottom, R.color.green);
                            String query = "UPDATE answ SET col" + t_num[0] + " = 1 WHERE rowNum = " + taskNumber;
                            db.execSQL(query);
                            decidedText.setVisibility(View.VISIBLE);
                            unsolveButton.setVisibility(View.VISIBLE);
                        } else {
                            changeButtonColor(answBottom, R.color.red);
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

            infoBotttom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textInfo.setVisibility(View.VISIBLE);
                    closeBotttom.setVisibility(View.VISIBLE);
                }
            });

            unsolveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String query = "UPDATE answ SET col" + t_num[0] + " = 0 WHERE rowNum = " + taskNumber;
                    db.execSQL(query);
                    decidedText.setVisibility(View.INVISIBLE);
                    unsolveButton.setVisibility(View.GONE);
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



    private void showCorrectAnswerMessage(final TextView correctAnswerMessage) {
        correctAnswerMessage.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                correctAnswerMessage.setVisibility(View.INVISIBLE);
            }
        }, 2000); // Show message for 2 seconds
    }

    private void changeButtonColor(final Button button, final int color) {
        button.setBackgroundColor(getResources().getColor(color));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                button.setBackgroundColor(getResources().getColor(R.color.lightblue)); // Default color
            }
        }, 2000); // Change color for 2 seconds
    }

    public void onDestroy() {
        super.onDestroy();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

}