package com.practicum.oge_math;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StatisticsFragment extends Fragment {
    private SQLiteDatabase db;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        DatabaseHelper dbHelper = new DatabaseHelper(requireContext());
        db = dbHelper.getWritableDatabase();

        for (int i = 1; i <= 25; i++) {
            ProgressBar progressBar = view.findViewById(getResources().getIdentifier("pbTask" + i, "id", requireContext().getPackageName()));
            TextView textView = view.findViewById(getResources().getIdentifier("tvTask" + i + "Progress", "id", requireContext().getPackageName()));
            TextView textNum = view.findViewById(getResources().getIdentifier("tvTask" + i, "id", requireContext().getPackageName()));
            Integer progress = getSumForNum(String.valueOf(i));
            progressBar.setProgress(progress);
            textView.setText(progress + "/7");
            textNum.setText("Задание " + i);
        }

        return  view;
    }



    private Integer getSumForNum(String num) {
        Cursor cursor = db.rawQuery("SELECT SUM(col1) + SUM(col2) + SUM(col3) + SUM(col4) + SUM(col5) + SUM(col6) + SUM(col7) FROM answ WHERE rowNum = ?", new String[]{num});

        Integer summ = null;
        if (cursor.moveToFirst()) {
            summ = cursor.getInt(0);
        }
        cursor.close();
        return summ;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }


}