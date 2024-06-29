package com.practicum.oge_math;

import android.content.Intent;
import android.graphics.Bitmap;
import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.kyanogen.signatureview.SignatureView;

import yuku.ambilwarna.AmbilWarnaDialog;


public class DraftFragment extends Fragment {
    private SignatureView signatureView;
    private DrawViewModel drawViewModel;
    ImageButton imgEraser, imgColor, imgUndo;
    SeekBar seekBar;
    TextView txtpensize;
    private int defaultcolor = (R.color.black);// = (R.color.black);


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_draft, container, false);
        signatureView = view.findViewById(R.id.signature_view);

        drawViewModel = new ViewModelProvider(requireActivity()).get(DrawViewModel.class);

        imgEraser = view.findViewById(R.id.btnEraser);
        imgColor = view.findViewById(R.id.btnColor);
        imgUndo = view.findViewById(R.id.btnUndo);
        seekBar = view.findViewById(R.id.penSize);
        txtpensize = view.findViewById(R.id.TxtPenSize);

        signatureView.setPenColor(defaultcolor);

        if (drawViewModel.getBitmap() != null) {
            signatureView.setBitmap(drawViewModel.getBitmap());
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtpensize.setText(progress + "dp");
                signatureView.setPenSize(progress);
                seekBar.setMax(50);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        imgEraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clearCanvas();
                drawViewModel.setBitmap(signatureView.getSignatureBitmap());
                imgUndo.setColorFilter(R.color.black);
            }
        });

        imgColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });

        imgUndo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                signatureView.setBitmap(drawViewModel.getLastBitmap());
                imgUndo.setBackgroundColor(R.color.gray);
            }
        });

        signatureView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility", "ResourceAsColor"})
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                drawViewModel.setBitmap(signatureView.getSignatureBitmap());
                imgUndo.setBackgroundColor(R.color.black);
                return false;
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
                defaultcolor = color;
                signatureView.setPenColor(color);
            }
        });
        ambilWarnaDialog.show();
    }

    @Override
    public void onPause() {
        // Сохранение текущего состояния рисунка
        super.onPause();
        drawViewModel.setBitmap(signatureView.getSignatureBitmap());
    }




}
//drawViewModel.setBitmap(signatureView.getSignatureBitmap());
///}