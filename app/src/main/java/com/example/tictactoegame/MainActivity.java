package com.example.tictactoegame;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //board activity
     int [] states ={2,2,2,2,2,2,2,2,2};
     int [][] winStates = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
     int player = 0;
     int count = 0;
     int won=0;


    @SuppressLint("SetTextI18n")
    public void mark(View view) {
        TextView finalText= (TextView) findViewById(R.id.finalText);
        ImageView counter =(ImageView) view;
        int tagCounter =Integer.parseInt(counter.getTag().toString());

         if(states[tagCounter]==2 && won==0) {
             states[tagCounter]=player;
             if (player == 0 && count <= 9) {
                 counter.setImageResource(R.drawable.first);
                 player = 1;
                 count++;

             } else if (count <= 9) {
                 counter.setImageResource(R.drawable.second);
                 player = 0;
                 count++;
             }
         }

       for(int [] winnerPositions : winStates) {

            if( states[winnerPositions[0]]==states[winnerPositions[1]] && states[winnerPositions[1]]==states[winnerPositions[2]] && states[winnerPositions[0]]!=2)
            {   String winnerOfGame = "";
                if(player==1) {
                    winnerOfGame="First";
                }
                else {
                    winnerOfGame="Second";
                }
                Toast.makeText(this, winnerOfGame+" won game!", Toast.LENGTH_LONG).show();
                won=1;
                finalText.setVisibility(View.VISIBLE);
                finalText.setText(" "+winnerOfGame+" won game!");
            }
        }
       if(count==9 && won==0) {
           Toast.makeText(this, "Game is Tie!", Toast.LENGTH_LONG).show();
           finalText.setVisibility(View.VISIBLE);
           finalText.setText(" Game is Tie!");

       }
    }
    //NEW BUTTON CODE
    public void StartGame(View view) {

            String image = "imageView";
            ImageView counter = (ImageView) findViewById(R.id.image);
            counter.setImageDrawable(null);

             for(int i=0;i<9;i++) {
               states[i]=2;
             }
             player = 0;
             count = 0;
             won=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

