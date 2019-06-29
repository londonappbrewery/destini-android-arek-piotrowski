package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyText;
    private Button buttonTop;
    private Button buttonBottom;
    private int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = findViewById(R.id.storyTextView);
        buttonTop = findViewById(R.id.buttonTop);
        buttonBottom = findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mStoryIndex = 3;
                } else if (mStoryIndex == 2) {
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    mStoryIndex = 6;
                }

                if (mStoryIndex == 3) {
                    storyText.setText(R.string.T3_Story);
                    buttonTop.setText(R.string.T3_Ans1);
                    buttonBottom.setText(R.string.T3_Ans2);
                } else {
                    storyText.setText(R.string.T6_End);
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            showEndingDialog();
                        }
                    }, 5000);
                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    mStoryIndex = 4;
                } else if (mStoryIndex == 3) {
                    mStoryIndex = 5;
                }

                if (mStoryIndex == 2) {
                    storyText.setText(R.string.T2_Story);
                    buttonTop.setText(R.string.T2_Ans1);
                    buttonBottom.setText(R.string.T2_Ans2);
                } else if (mStoryIndex == 4) {
                    storyText.setText(R.string.T4_End);
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            showEndingDialog();
                        }
                    }, 5000);
                } else {
                    storyText.setText(R.string.T6_End);
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            showEndingDialog();
                        }
                    }, 5000);
                }

            }
        });

    }

    private void showEndingDialog() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Game Over!");
        alert.setCancelable(false);
        alert.setMessage("You can restart or quit: ");
        alert.setNegativeButton("Start over", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                finish();
                Intent intent = new Intent( getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        alert.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                finish();
            }
        });
        alert.show();
    }
}
