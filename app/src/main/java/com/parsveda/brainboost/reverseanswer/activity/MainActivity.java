package com.parsveda.brainboost.reverseanswer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parsveda.brainboost.reverseanswer.R;
import com.parsveda.brainboost.reverseanswer.base.Globals;
import com.parsveda.brainboost.reverseanswer.model.GameType;
import com.parsveda.brainboost.reverseanswer.model.Questions;

import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //TextToSpeech textToSpeech;


    RelativeLayout mainPanel;
    Random rand;
    public CountDownTimer timer;
    private boolean ret = false;
    MediaPlayer looseMediaPlayer;
    MediaPlayer winMediaPlayer;


    TextView txtScoreValue, txtBestScoreValue, txtScoreText, txtBestScoreText;

    TextView txtTime;
    TextView txtQuestion;
    Questions questions;
    int questionumber = 0;

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();

        //super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main);

        txtTime = (TextView) findViewById(R.id.txtTime);
        txtTime.setTypeface(Globals.ReckonerFace, Typeface.BOLD);
        txtTime.setTextColor(getResources().getColor(R.color.dark_text));

        txtScoreValue = (TextView) findViewById(R.id.txtScoreValue);
        txtScoreValue.setTypeface(Globals.ReckonerFace, Typeface.BOLD);
        txtScoreValue.setTextColor(getResources().getColor(R.color.dark_text));


        txtScoreText = (TextView) findViewById(R.id.txtScoreText);
        txtScoreText.setTypeface(Globals.ReckonerFace, Typeface.BOLD);
        txtScoreText.setTextColor(getResources().getColor(R.color.dark_text));


        txtBestScoreText = (TextView) findViewById(R.id.txtBestScoreText);
        txtBestScoreText.setTypeface(Globals.ReckonerFace, Typeface.BOLD);
        txtBestScoreText.setTextColor(getResources().getColor(R.color.dark_text));

        txtBestScoreValue = (TextView) findViewById(R.id.txtBestScoreValue);
        txtBestScoreValue.setTypeface(Globals.ReckonerFace, Typeface.BOLD);
        txtBestScoreValue.setTextColor(getResources().getColor(R.color.dark_text));

        looseMediaPlayer = MediaPlayer.create(this, R.raw.loose);
        looseMediaPlayer.setLooping(false);

        winMediaPlayer = MediaPlayer.create(this, R.raw.win);
        winMediaPlayer.setLooping(false);


        if (Globals.currentStage.getType() == GameType.SURVIVAL) {
            txtBestScoreValue.setText(Globals.currentStage.getSurvivalModeBestScore() + "");
        } else if (Globals.currentStage.getType() == GameType.TIME_TRAIL) {
            txtBestScoreValue.setText(Globals.currentStage.getTimeTrailModeBestScore() + "");
        }


        rand = new Random();
        mainPanel = (RelativeLayout) findViewById(R.id.pnlMain);


        questions = Globals.questions.newInstance();
        long seed = System.nanoTime();
        Collections.shuffle(questions, new Random(seed));

        timer = new CountDownTimer(Globals.TimeForAnyStageParts, Globals.IntervalOfShowingTime) {
            public void onTick(long millisUntilFinished) {
                Globals.currentStage.setTime((float) millisUntilFinished / 1000);
                TextView txttime = (TextView) findViewById(R.id.txtTime);
                txttime.setText(Globals.currentStage.getTime() + "");
            }

            public void onFinish() {

                if (Globals.currentStage.getType() == GameType.SURVIVAL) {
                    //clear();
                    //Globals.currentStage.addScore(-1);
                    txtTime.setText("0.000");
                    timer.cancel();
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                } else if (Globals.currentStage.getType() == GameType.TIME_TRAIL) {

                    Globals.currentStage.setTime(0);
                    TextView txttime = (TextView) findViewById(R.id.txtTime);
                    txttime.setText("0.000");
//                clear();
                    //Globals.currentStage.addScore(-1);
                    TextView txtvalue = (TextView) findViewById(R.id.txtScoreValue);
                    txtvalue.setText(Globals.currentStage.getScore() + "");
                    timer.cancel();
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    startActivity(intent);
                    finish();

//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            changeQuestion();
//                            timer.start();
//                        }
//                    }, Globals.DelayBetweenStageParts);

                }
            }
        };


//        final Button btnBack = (Button) findViewById(R.id.btnBack);
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                clear();
//                timer.cancel();
//                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });


        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtQuestion.setTypeface(Globals.ReckonerFace, Typeface.BOLD);


        Button btnYes = (Button) findViewById(R.id.btnYes);
        btnYes.setTypeface(Globals.ReckonerFace, Typeface.BOLD);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //looseMediaPlayer.start();

                if (Globals.currentStage.getType() == GameType.SURVIVAL) {

                    if (Globals.currentQuestion.getAnswer() == 0) {
                        Globals.currentStage.addScore(1);
                    } else {

                        looseMediaPlayer.start();

                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        startActivity(intent);
                        finish();
                        Globals.textToSpeech.stop();
                        return;
                        //Globals.currentStage.addScore(-1);
                    }
                    winMediaPlayer.start();
                    //Globals.currentStage.addScore(-1);
                    TextView txtvalue = (TextView) findViewById(R.id.txtScoreValue);
                    txtvalue.setText(Globals.currentStage.getScore() + "");
                    changeQuestion();
                    timer.cancel();
                    timer.start();

                } else if (Globals.currentStage.getType() == GameType.TIME_TRAIL) {

                    if (Globals.currentQuestion.getAnswer() == 0) {
                        winMediaPlayer.start();
                        Globals.currentStage.addScore(1);
                    } else {
                        looseMediaPlayer.start();
                        Globals.currentStage.addScore(-1);
                    }
                    //Globals.currentStage.addScore(-1);
                    TextView txtvalue = (TextView) findViewById(R.id.txtScoreValue);
                    txtvalue.setText(Globals.currentStage.getScore() + "");

                    changeQuestion();
                    //timer.cancel();
                    //timer.start();
                }


            }
        });


        Button btnNo = (Button) findViewById(R.id.btnNo);
        btnNo.setTypeface(Globals.ReckonerFace, Typeface.BOLD);

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Globals.currentStage.getType() == GameType.SURVIVAL) {

                    if (Globals.currentQuestion.getAnswer() == 1) {
                        Globals.currentStage.addScore(1);
                    } else {

                        looseMediaPlayer.start();
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        startActivity(intent);
                        finish();
                        Globals.textToSpeech.stop();
                        return;
                        //Globals.currentStage.addScore(-1);
                    }
                    winMediaPlayer.start();
                    //Globals.currentStage.addScore(-1);
                    TextView txtvalue = (TextView) findViewById(R.id.txtScoreValue);
                    txtvalue.setText(Globals.currentStage.getScore() + "");
                    changeQuestion();
                    timer.cancel();
                    timer.start();

                } else if (Globals.currentStage.getType() == GameType.TIME_TRAIL) {

                    if (Globals.currentQuestion.getAnswer() == 1) {
                        winMediaPlayer.start();
                        Globals.currentStage.addScore(1);
                    } else {
                        looseMediaPlayer.start();
                        Globals.currentStage.addScore(-1);
                    }
                    //Globals.currentStage.addScore(-1);
                    TextView txtvalue = (TextView) findViewById(R.id.txtScoreValue);
                    txtvalue.setText(Globals.currentStage.getScore() + "");

                    changeQuestion();
                    //timer.cancel();
                    //timer.start();
                }

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        timer.start();
//        clear();
//        Globals.currentStage.setScore(0);
//        Globals.currentStage.setPartCount(0);
        changeQuestion();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Globals.textToSpeech.stop();
        timer.cancel();
    }

    public boolean checkVictory() {
        boolean vic = true;
        for (Button btn : Globals.buttons) {
            if (btn.isEnabled() == true) {
                vic = false;
                break;
            }
        }
        return vic;
    }

    public void clear() {
        mainPanel.removeAllViews();
//        for (Button btn : Globals.buttons) {
//            mainPanel.removeView(btn);
//        }
        Globals.buttons.clear();
        Globals.currentStage.setCurrentValue(0);

    }

    public void changeQuestion() {
        Globals.currentQuestion = questions.get(questionumber);

        txtQuestion.setText(Globals.currentQuestion.getText());
        Globals.textToSpeech.speak(txtQuestion.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

        questionumber++;
        questionumber = Math.min(questions.size() - 1, questionumber);

    }

}
