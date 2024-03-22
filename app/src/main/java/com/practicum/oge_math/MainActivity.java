package com.practicum.oge_math;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements TasksFragment.TasksInterface,Task1_5Fragment.TasksInterface, Task6_19Fragment.TasksInterface, Task20_25Fragment.TasksInterface, DevelopFragment.TasksInterface {
    public ImageButton openTasksButton, openTheoryButton, openDraftButton, openStatisticsButton;
    private final TasksFragment tasksFragment = new TasksFragment();
    DraftFragment draftFragment = new DraftFragment();
    public Fragment activeTaskFragment = tasksFragment;
    public String activeNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout, new TasksFragment())
                    .commit();
        }

        openTasksButton = findViewById(R.id.openTasksButton);
        openTheoryButton = findViewById(R.id.openTheoryButton);
        openDraftButton = findViewById(R.id.openDraftButton);
        openTasksButton.setColorFilter(R.color.nodarkblue);

        openDraftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(draftFragment, "0");
                openDraftButton.setColorFilter(R.color.nodarkblue);;
            }
        });
        openTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(activeTaskFragment, activeNum);
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
        openDraftButton.setColorFilter(null);
        ft.commit();
    }
    public void setActiveFragment(Fragment fr, String btn_num){
        activeTaskFragment = fr;
        activeNum = btn_num;
    }

}