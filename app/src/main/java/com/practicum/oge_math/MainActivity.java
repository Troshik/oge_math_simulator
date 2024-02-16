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
    public Fragment activeTaskFragment = tasksFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openTasksButton = findViewById(R.id.openTasksButton);
        openTheoryButton = findViewById(R.id.openTheoryButton);


        setNewFragment(tasksFragment, "0");
        openTasksButton.setColorFilter(R.color.nodarkblue);

        openTheoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(theoryFragment, "0");
                openTheoryButton.setColorFilter(R.color.nodarkblue);;
            }
        });
        openTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(activeTaskFragment, "0");
                openTasksButton.setColorFilter(R.color.nodarkblue);
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
        ft.commit();
    }
    public void setActiveFragment(){
        if (activeTaskFragment == tasksFragment) {
            activeTaskFragment = Task6_19;
        } else {
            activeTaskFragment = tasksFragment;
        }
    }

}