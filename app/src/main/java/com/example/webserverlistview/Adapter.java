package com.example.webserverlistview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<String> {
    private Activity activity;
    private String[] judul_adapter;
    private Integer[] image_adapter;

    Adapter(Activity activity, String[] judul_adapter, Integer[] image_adapter) {
        super(activity, R.layout.item_list, judul_adapter);
        this.activity = activity;
        this.judul_adapter = judul_adapter;
        this.image_adapter = image_adapter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint({"ViewHolder", "InflateParams"}) View view = activity.getLayoutInflater().inflate(R.layout.item_list, null, true);
        ImageView imageView = view.findViewById(R.id.card_image);
        imageView.setImageResource(image_adapter[position]);
        TextView textView = view.findViewById(R.id.card_text);
        textView.setText(judul_adapter[position]);
        return view;
    }
}
