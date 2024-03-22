package com.practicum.oge_math;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


public class TheoryFragment extends Fragment {

    int num = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_theory, container, false);

        ImageView help = view.findViewById(R.id.imageHelp);
        ImageButton Forward = view.findViewById(R.id.imageButtonF);
        ImageButton Back = view.findViewById(R.id.imageButtonB);
        int[] images = {R.drawable.spr1, R.drawable.spr2, R.drawable.spr3, R.drawable.spr4};

        help.setImageResource(images[num]);

        Forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num < 3) {
                    num = num + 1;
                    help.setImageResource(images[num]);
                }
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num > 0) {
                    num = num - 1;
                    help.setImageResource(images[num]);
                }
            }
        });

        return view;
    }
}