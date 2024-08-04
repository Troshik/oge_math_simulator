package com.practicum.oge_math;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MainActivity extends AppCompatActivity implements TasksFragment.TasksInterface,Task1_5Fragment.TasksInterface, Task6_19Fragment.TasksInterface, Task20_25Fragment.TasksInterface, DevelopFragment.TasksInterface {
    public ImageButton openTasksButton, openTheoryButton, openDraftButton, openStatisticsButton;
    private final TasksFragment tasksFragment = new TasksFragment();
    DraftFragment draftFragment = new DraftFragment();
    TheoryFragment theoryFragment = new TheoryFragment();
    StatisticsFragment statisticsFragment = new StatisticsFragment();
    public Fragment activeTaskFragment = tasksFragment;
    public String activeNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        copyDatabase();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout, new TasksFragment())
                    .commit();
        }

        openTasksButton = findViewById(R.id.openTasksButton);
        openTheoryButton = findViewById(R.id.openTheoryButton);
        openDraftButton = findViewById(R.id.openDraftButton);
        openStatisticsButton = findViewById(R.id.openStatisticsButton);
        openTasksButton.setColorFilter(R.color.lightblue);

        openDraftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(draftFragment, "0");
                openDraftButton.setColorFilter(getResources().getColor(R.color.nodarkblue));
            }
        });
        openTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(activeTaskFragment, activeNum);
                openTasksButton.setColorFilter(getResources().getColor(R.color.nodarkblue));
            }
        });

        openTheoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(theoryFragment, "0");
                openTheoryButton.setColorFilter(getResources().getColor(R.color.nodarkblue));
            }
        });

        openStatisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(statisticsFragment, "0");
                openStatisticsButton.setColorFilter(getResources().getColor(R.color.nodarkblue));
            }
        });
    }
    public void setNewFragment(Fragment fragment, String buttonNumber) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("buttonNumber", buttonNumber);
        fragment.setArguments(bundle);

        ft.replace(R.id.framelayout, fragment);
        openTasksButton.setColorFilter(null);
        openTheoryButton.setColorFilter(null);
        openDraftButton.setColorFilter(null);
        openStatisticsButton.setColorFilter(null);
        ft.commit();
    }
    public void setActiveFragment(Fragment fr, String btn_num){
        activeTaskFragment = fr;
        activeNum = btn_num;
    }

    private void copyDatabase() {
        File dbFile = getDatabasePath("stat_bd.sqlite");
        if (!dbFile.exists()) {
            try {
                InputStream inputStream = getAssets().open("stat_bd.sqlite");
                String outFileName = dbFile.getPath();
                OutputStream outputStream = Files.newOutputStream(Paths.get(outFileName));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                outputStream.flush();
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}