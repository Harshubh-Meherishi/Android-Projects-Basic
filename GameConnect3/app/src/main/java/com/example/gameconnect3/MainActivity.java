package com.example.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//0: red, 1: yellow, 2:empty
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
int activeplayer = 0;
boolean gameActive = true;
public void dropin(View view){


    ImageView counter = (ImageView)view;
   int tappedCounter =  Integer.parseInt(counter.getTag().toString());
   if(gameState[tappedCounter] == 2 && gameActive) {
       gameState[tappedCounter] = activeplayer;
       counter.setTranslationY(-1500);
       if (activeplayer == 0) {
           counter.setImageResource(R.drawable.yellow);
           activeplayer = 1;

       } else {
           counter.setImageResource(R.drawable.red);
           activeplayer = 0;
       }
       counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
       for (int[] winningPosition : winningPositions) {
           if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
               String winner;
               gameActive =false;
               if (activeplayer == 1)
                   winner = "Yellow";
               else
                   winner = "Red";
            //   Toast.makeText(this, winner + " has won!! ", Toast.LENGTH_SHORT).show();
               Button play = (Button) findViewById(R.id.PlayAgain);
               TextView winner1 = (TextView) findViewById(R.id.winnerTextView);
               winner1.setText( winner + " has Won!!");

               play.setVisibility(View.VISIBLE);
               winner1.setVisibility(View.VISIBLE);
           }
       }
   }

}
public void PlayGameAgain(View view){
    Button play = (Button) findViewById(R.id.PlayAgain);
    TextView winner1 = (TextView) findViewById(R.id.winnerTextView);
    play.setVisibility(View.INVISIBLE);
    winner1.setVisibility(View.INVISIBLE);
    androidx.gridlayout.widget.GridLayout grid = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.Grid);
    for(int i =0;i<grid.getChildCount();i++){
        ImageView child = (ImageView) grid.getChildAt(i);
        child.setImageDrawable(null);

    }
    for(int i =0; i<gameState.length;i++)
    {
        gameState[i] =2;
    }

    activeplayer = 0;
    gameActive = true;
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
