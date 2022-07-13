package com.example.snakeandladders.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.snakeandladders.R;
import com.example.snakeandladders.model.GridBox;

import java.util.ArrayList;


public class GridBoxAdapter extends ArrayAdapter<GridBox> {
    public GridBoxAdapter(@NonNull Context context, ArrayList<GridBox> gridBoxList) {
        super(context, 0, gridBoxList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        GridBox gridBox = getItem(position);
        CardView card = listItemView.findViewById(R.id.card);
        ImageView image = listItemView.findViewById(R.id.image);
        card.setCardBackgroundColor(gridBox.isGreen() ? Color.GREEN : (gridBox.isRed() ? Color.RED : Color.WHITE));
        if(gridBox.isCurrentPosition()) {
            image.setImageResource(R.drawable.icons8_person_48);
        }
        return listItemView;

    }
}
