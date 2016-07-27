package com.tacademy.sampledesignsupport;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-07-27.
 */
public class TextViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public TextViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView;
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
