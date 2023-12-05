package com.practicum.oge_math;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements TasksFragment.TasksInterface, Task6_19Fragment.TasksInterface {
    private ImageButton openTasksButton, openTheoryButton, openDraftButton, openStatisticsButton;
    private FrameLayout framelayout;
    private TasksFragment tasksFragment = new TasksFragment();
    private TheoryFragment theoryFragment = new TheoryFragment();
    private Fragment Task6_19 = new Task6_19Fragment();
    private Fragment activeTaskFragment = tasksFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openTasksButton = findViewById(R.id.openTasksButton);
        openTheoryButton = findViewById(R.id.openTheoryButton);


        setNewFragment(tasksFragment);
        openTasksButton.setColorFilter(R.color.nodarkblue);

        openTheoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(theoryFragment);
                openTheoryButton.setColorFilter(R.color.nodarkblue);;
            }
        });
        openTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(activeTaskFragment);
                openTasksButton.setColorFilter(R.color.nodarkblue);
            }
        });
    }
    public void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framelayout, fragment);
        if (fragment == activeTaskFragment) {
            if (activeTaskFragment == tasksFragment) {
                activeTaskFragment = Task6_19;
            } else {
                activeTaskFragment = tasksFragment;
            }

        }
        openTasksButton.setColorFilter(null);
        openTheoryButton.setColorFilter(null);
        ft.commit();
    }

}