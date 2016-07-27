package com.tacademy.sampledesignsupport;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Tacademy on 2016-07-27.
 */
public class ElevationImageView extends ImageView {

    float elevation = 0f;

    public ElevationImageView(Context context) {
        super(context);
    }

    public ElevationImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setElevation(float elevation) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(elevation);
        } else {
            this.elevation = elevation;
        }
    }
}