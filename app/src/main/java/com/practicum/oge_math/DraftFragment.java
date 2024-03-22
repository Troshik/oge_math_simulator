package com.practicum.oge_math;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.kyanogen.signatureview.SignatureView;
import yuku.ambilwarna.AmbilWarnaDialog;


public class DraftFragment extends Fragment {
    private SignatureView signatureView;
    ImageButton imgEraser, imgColor;
    SeekBar seekBar;
    TextView txtpensize;
    private int defaultcolor = (R.color.black);// = (R.color.black);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_draft, container, false);
        signatureView = view.findViewById(R.id.signature_view);

        imgEraser = view.findViewById(R.id.btnEraser);
        imgColor = view.findViewById(R.id.btnColor);
        seekBar = view.findViewById(R.id.penSize);
        txtpensize = view.findViewById(R.id.TxtPenSize);

        signatureView.setPenColor(defaultcolor);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtpensize.setText(progress + "dp");
                signatureView.setPenSize(progress);
                seekBar.setMax(50);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        imgEraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clearCanvas();
            }
        });

        imgColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });

        return view;


    }

        private void openColorPicker() {
            AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(requireContext(), defaultcolor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                @Override
                public void onCancel(AmbilWarnaDialog dialog) {

                }

                @Override
                public void onOk(AmbilWarnaDialog dialog, int color) {
                    defaultcolor=color;
                    signatureView.setPenColor(color);
                }
            });
            ambilWarnaDialog.show();
        }

}