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


public class Task1_5Fragment extends Fragment {

    public interface TasksInterface {
        void setNewFragment(Fragment fragment, String buttonNumber);
    }


    TasksInterface newFr;
    String textAnsw1, textAnsw2, textAnsw3, textAnsw4, textAnsw5, actBtn;
    private SQLiteDatabase db;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            newFr = (Task1_5Fragment.TasksInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity + "must be bebeeb");
        }
    }


    @SuppressLint({"DiscouragedApi", "SetJavaScriptEnabled"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task1_5, container, false);

        ImageButton imageLastList = view.findViewById(R.id.imageLastList);
        ImageButton infoBotttom = view.findViewById(R.id.infoButton);
        ImageButton closeBotttom = view.findViewById(R.id.closeButton);
        TextView textInfo = view.findViewById(R.id.textInfo);
        textInfo.setText(getString(getResources().getIdentifier("info_1_5", "string", requireContext().getPackageName())));
        Button buttonTask1 = view.findViewById(R.id.buttonTask1);
        Button buttonTask2 = view.findViewById(R.id.buttonTask2);
        Button buttonTask3 = view.findViewById(R.id.buttonTask3);
        Button buttonTask4 = view.findViewById(R.id.buttonTask4);
        Button buttonTask5 = view.findViewById(R.id.buttonTask5);
        Button buttonTask6 = view.findViewById(R.id.buttonTask6);
        Button buttonTask7 = view.findViewById(R.id.buttonTask7);

        Button answBottom1 = view.findViewById(R.id.answBtn1);
        Button solutBottom1 = view.findViewById(R.id.solutBtn1);
        Button unsolveButton1 = view.findViewById(R.id.unsolveBtn1);
        WebView textTask1 = view.findViewById(R.id.imageTask1);


        Button answBottom2 = view.findViewById(R.id.answBtn2);
        Button solutBottom2 = view.findViewById(R.id.solutBtn2);
        Button unsolveButton2 = view.findViewById(R.id.unsolveBtn2);
        WebView textTask2 = view.findViewById(R.id.imageTask2);

        Button answBottom3 = view.findViewById(R.id.answBtn3);
        Button solutBottom3 = view.findViewById(R.id.solutBtn3);
        Button unsolveButton3 = view.findViewById(R.id.unsolveBtn3);
        WebView textTask3 = view.findViewById(R.id.imageTask3);

        Button answBottom4 = view.findViewById(R.id.answBtn4);
        Button solutBottom4 = view.findViewById(R.id.solutBtn4);
        Button unsolveButton4 = view.findViewById(R.id.unsolveBtn4);
        WebView textTask4 = view.findViewById(R.id.imageTask4);

        Button answBottom5 = view.findViewById(R.id.answBtn5);
        Button solutBottom5 = view.findViewById(R.id.solutBtn5);
        Button unsolveButton5 = view.findViewById(R.id.unsolveBtn5);
        WebView textTask5 = view.findViewById(R.id.imageTask5);

        WebSettings webSettings1 = textTask1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        WebSettings webSettings2 = textTask2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        WebSettings webSettings3 = textTask3.getSettings();
        webSettings3.setJavaScriptEnabled(true);
        WebSettings webSettings4 = textTask4.getSettings();
        webSettings4.setJavaScriptEnabled(true);
        WebSettings webSettings5 = textTask5.getSettings();
        webSettings5.setJavaScriptEnabled(true);

        DatabaseHelper dbHelper = new DatabaseHelper(requireContext());
        db = dbHelper.getWritableDatabase();


        Bundle args = getArguments();
        if (args != null) {
            String taskNumber = args.getString("buttonNumber", "0");

            for (int i = 1; i <= 5; i++) {
                int htmlResourceId = getResources().getIdentifier("t1_" + taskNumber + "_" + i, "raw", requireContext().getPackageName());
                WebView textTask = view.findViewById(getResources().getIdentifier("imageTask" + i, "id", requireContext().getPackageName()));
                EditText editText = view.findViewById(getResources().getIdentifier("filledTextField" + i, "id", requireContext().getPackageName()));
                Button unsolveButton = view.findViewById(getResources().getIdentifier("unsolveBtn" + i, "id", requireContext().getPackageName()));
                TextView decidedText = view.findViewById(getResources().getIdentifier("decidedText" + i, "id", requireContext().getPackageName()));

                textTask.getSettings().setJavaScriptEnabled(true);
                textTask.loadDataWithBaseURL(null, readHtmlFromRawResource(htmlResourceId), "text/html", "UTF-8", null);
                editText.setText("");
                unsolveButton.setVisibility(View.INVISIBLE);
                decidedText.setVisibility(View.GONE);

                Cursor cursor = db.rawQuery("SELECT col1 FROM answ WHERE rowNum = ?", new String[]{String.valueOf(i)});
                Integer tr_fl = 0;
                if (cursor.moveToFirst()) {
                    tr_fl = cursor.getInt(0);
                }
                cursor.close();
                if ((tr_fl.equals(1))) {
                    unsolveButton.setVisibility(View.VISIBLE);
                    decidedText.setVisibility(View.VISIBLE);
                }
            }


            textAnsw1 = getString(getResources().getIdentifier("answ1_" + taskNumber + "_1", "string", requireContext().getPackageName()));
            textAnsw2 = getString(getResources().getIdentifier("answ1_" + taskNumber + "_2", "string", requireContext().getPackageName()));
            textAnsw3 = getString(getResources().getIdentifier("answ1_" + taskNumber + "_3", "string", requireContext().getPackageName()));
            textAnsw4 = getString(getResources().getIdentifier("answ1_" + taskNumber + "_4", "string", requireContext().getPackageName()));
            textAnsw5 = getString(getResources().getIdentifier("answ1_" + taskNumber + "_5", "string", requireContext().getPackageName()));

            actBtn  = "1";



            Fragment TasksList = new TasksFragment();



            View.OnClickListener buttonClickListener = new View.OnClickListener() {
                @SuppressLint({"ResourceAsColor", "SetTextI18n"})
                @Override
                public void onClick(View v) {
                    String buttonName = getResources().getResourceEntryName(v.getId());
                    actBtn  = buttonName.substring(10);

                    for (int i = 1; i <= 5; i++) {
                        WebView textTask = view.findViewById(getResources().getIdentifier("imageTask" + i, "id", requireContext().getPackageName()));
                        EditText editText = view.findViewById(getResources().getIdentifier("filledTextField" + i, "id", requireContext().getPackageName()));
                        TextView trAnsw = view.findViewById(getResources().getIdentifier("trAnswText" + i, "id", requireContext().getPackageName()));
                        Button unsolveButton = view.findViewById(getResources().getIdentifier("unsolveBtn" + i, "id", requireContext().getPackageName()));
                        TextView decidedText = view.findViewById(getResources().getIdentifier("decidedText" + i, "id", requireContext().getPackageName()));
                        int htmlResourceId = getResources().getIdentifier("t1_" + actBtn + "_" + i, "raw", requireContext().getPackageName());
                        textTask.getSettings().setJavaScriptEnabled(true);
                        textTask.loadDataWithBaseURL(null, readHtmlFromRawResource(htmlResourceId), "text/html", "UTF-8", null);
                        trAnsw.setText("");
                        editText.setText("");
                        unsolveButton.setVisibility(View.INVISIBLE);
                        decidedText.setVisibility(View.GONE);
                    }

                    textAnsw1 = getString(getResources().getIdentifier("answ1_" + actBtn + "_1", "string", requireContext().getPackageName()));
                    textAnsw2 = getString(getResources().getIdentifier("answ1_" + actBtn + "_2", "string", requireContext().getPackageName()));
                    textAnsw3 = getString(getResources().getIdentifier("answ1_" + actBtn + "_3", "string", requireContext().getPackageName()));
                    textAnsw4 = getString(getResources().getIdentifier("answ1_" + actBtn + "_4", "string", requireContext().getPackageName()));
                    textAnsw5 = getString(getResources().getIdentifier("answ1_" + actBtn + "_5", "string", requireContext().getPackageName()));

                }
            };

            View.OnClickListener buttonAnswer = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonNum = getResources().getResourceEntryName(v.getId());

                    int editTextId = getResources().getIdentifier("filledTextField" + buttonNum.substring(7), "id", requireContext().getPackageName());
                    EditText editText = view.findViewById(editTextId);
                    String answEditText = editText.getText().toString();

                    int trAnsId = getResources().getIdentifier("answ1_" + actBtn + "_" + buttonNum.substring(7), "string", requireContext().getPackageName());
                    String trAnsw = getString(trAnsId);


                    int trFlAnswId = getResources().getIdentifier("trFlAnswText" + buttonNum.substring(7), "id", requireContext().getPackageName());
                    TextView trFlAnsw = view.findViewById(trFlAnswId);

                    Button unsolveButton = view.findViewById(getResources().getIdentifier("unsolveBtn" + buttonNum.substring(7), "id", requireContext().getPackageName()));
                    TextView decidedText = view.findViewById(getResources().getIdentifier("decidedText" + buttonNum.substring(7), "id", requireContext().getPackageName()));


                    if (!answEditText.equals("")) {
                        if (answEditText.equals(trAnsw)) {
                            String query = "UPDATE answ SET col" + taskNumber + " = 1 WHERE rowNum = " + buttonNum.substring(7);
                            db.execSQL(query);
                            showCorrectAnswerMessage(trFlAnsw);
                            changeButtonColor((Button) v, R.color.green);
                            unsolveButton.setVisibility(View.VISIBLE);
                            decidedText.setVisibility(View.VISIBLE);
                        } else {
                            changeButtonColor((Button) v, R.color.red);
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

            View.OnClickListener buttonUnsolve = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonNum = getResources().getResourceEntryName(v.getId());
                    Button unsolveButton = view.findViewById(getResources().getIdentifier("unsolveBtn" + buttonNum.substring(10), "id", requireContext().getPackageName()));
                    TextView decidedText = view.findViewById(getResources().getIdentifier("decidedText" + buttonNum.substring(10), "id", requireContext().getPackageName()));

                    String query = "UPDATE answ SET col" + buttonNum.substring(10) + " = 0 WHERE rowNum = " + actBtn;
                    db.execSQL(query);
                    unsolveButton.setVisibility(View.INVISIBLE);
                    decidedText.setVisibility(View.GONE);
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

            unsolveButton1.setOnClickListener(buttonUnsolve);
            unsolveButton2.setOnClickListener(buttonUnsolve);
            unsolveButton3.setOnClickListener(buttonUnsolve);
            unsolveButton4.setOnClickListener(buttonUnsolve);
            unsolveButton5.setOnClickListener(buttonUnsolve);

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
}