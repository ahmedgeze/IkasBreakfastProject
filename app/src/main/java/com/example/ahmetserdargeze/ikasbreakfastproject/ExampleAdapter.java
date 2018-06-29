package com.example.ahmetserdargeze.ikasbreakfastproject;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ahmetserdargeze on 29.06.2018.
 */

public class ExampleAdapter extends CursorAdapter {
    private List<String> items;
    private TextView text;

    public ExampleAdapter(Context context, Cursor c, List<String> items) {
        super(context, c, false);
        this.items=items;
    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item, parent, false);

        text = (TextView) view.findViewById(R.id.text);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        text.setText(items.get(cursor.getPosition()));

    }
}
