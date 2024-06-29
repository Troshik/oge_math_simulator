package com.practicum.oge_math;

import androidx.lifecycle.ViewModel;
import android.graphics.Bitmap;

public class DrawViewModel extends ViewModel {
    private Bitmap new_bitmap;
    private Bitmap last_bitmap;

    public Bitmap getBitmap() {
        return new_bitmap;
    }

    public Bitmap getLastBitmap() {
        return last_bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        last_bitmap = new_bitmap;
        this.new_bitmap = bitmap;
    }
}
