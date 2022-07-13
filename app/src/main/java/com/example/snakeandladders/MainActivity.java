package com.example.snakeandladders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.example.snakeandladders.adapter.GridBoxAdapter;
import com.example.snakeandladders.model.GridBox;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridView grids;
    int currentPosition = -1;
    ArrayList<GridBox> gridBoxArrayList = new ArrayList<>();
    GridBoxAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grids = findViewById(R.id.grids);

        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, true, false, false));
        gridBoxArrayList.add(new GridBox(true, false, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, true, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, true, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(true, false, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, true, false, false));
        gridBoxArrayList.add(new GridBox(true, false, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(true, false, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(true, false, false, false));
        gridBoxArrayList.add(new GridBox(false, true, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(true, false, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(false, true, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));
        gridBoxArrayList.add(new GridBox(true, false, false, false));
        gridBoxArrayList.add(new GridBox(false, true, false, false));
        gridBoxArrayList.add(new GridBox(false, false, true, false));

        adapter = new GridBoxAdapter(this, gridBoxArrayList);
        grids.setAdapter(adapter);
    }

    public void generateRandomFor1(View view) {
        Random random = new Random();
        TextView textView = (TextView) findViewById(R.id.random_player_1);
        int diceValue = random.nextInt(6);
        textView.setText(String.valueOf(diceValue));



        if(currentPosition != -1) {
            GridBox replaceGrid = gridBoxArrayList.get(currentPosition);
            replaceGrid.setCurrentPosition(false);
            gridBoxArrayList.add(currentPosition, replaceGrid);
            gridBoxArrayList.remove(currentPosition+1);
        }

        currentPosition = currentPosition + diceValue;
        GridBox newGrid = gridBoxArrayList.get(currentPosition);
        newGrid.setCurrentPosition(true);
        gridBoxArrayList.add(currentPosition, newGrid);
        gridBoxArrayList.remove(currentPosition);

        synchronized(adapter){
            adapter.notifyDataSetChanged();
        }
    }

}