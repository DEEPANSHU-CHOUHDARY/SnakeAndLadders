package com.example.snakeandladders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.example.snakeandladders.adapter.GridBoxAdapter;
import com.example.snakeandladders.model.GridBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridView grids;
    int currentPosition = -1;
    List<GridBox> gridBoxArrayList = new ArrayList<>();
    List<Integer> greens = new ArrayList<>();
    List<Integer> reds = new ArrayList<>();
    GridBoxAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grids = findViewById(R.id.grids);
        
        populateGreenGrids();
        populateRedGrids();
        populateGridsForGame();

        adapter = new GridBoxAdapter(this, gridBoxArrayList);
        grids.setAdapter(adapter);
    }

    private void populateRedGrids() {
        reds.add(2);
        reds.add(11);
        reds.add(15);
        reds.add(18);
        reds.add(22);
        reds.add(27);
        reds.add(33);
    }

    private void populateGreenGrids() {
        greens.add(1);
        greens.add(6);
        greens.add(9);
        greens.add(14);
        greens.add(23);
        greens.add(31);
        greens.add(34);
    }

    private void populateGridsForGame() {
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
    }

    public void generateRandomFor1(View view) {
        Random random = new Random();
        TextView textView = (TextView) findViewById(R.id.random_player_1);
        int diceValue = random.nextInt(6);
        while(diceValue == 0) {
            diceValue = random.nextInt(6);
        }
        textView.setText(String.valueOf(diceValue));

        if(currentPosition != -1) {
            GridBox replaceGrid = gridBoxArrayList.get(currentPosition);
            replaceGrid.setCurrentPosition(false);
            gridBoxArrayList.set(currentPosition, replaceGrid);
        }

        currentPosition = currentPosition + diceValue;
        if(currentPosition >= 35) return;
        GridBox newGrid = gridBoxArrayList.get(currentPosition);
        int nextGreen;
        int previousRed;
        if(newGrid.isGreen()) {
            nextGreen = greens.get(greens.indexOf(currentPosition) + 1);
            if(greens.indexOf(nextGreen)<(greens.size()-1)){
                newGrid = gridBoxArrayList.get(nextGreen);
            }
            currentPosition = nextGreen;
        } else if(newGrid.isRed()) {
            previousRed = reds.get(reds.indexOf(currentPosition) - 1);
            if(reds.indexOf(previousRed) > 0) {
                newGrid = gridBoxArrayList.get(previousRed);
            }
            currentPosition = previousRed;
        }
        newGrid.setCurrentPosition(true);
        gridBoxArrayList.set(currentPosition, newGrid);

        synchronized(adapter){
            adapter.notifyDataSetChanged();
        }
    }
}