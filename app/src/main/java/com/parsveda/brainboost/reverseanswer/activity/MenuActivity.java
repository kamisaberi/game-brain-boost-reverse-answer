package com.parsveda.brainboost.reverseanswer.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parsveda.brainboost.reverseanswer.R;
import com.parsveda.brainboost.reverseanswer.base.Globals;
import com.parsveda.brainboost.reverseanswer.model.GameType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_menu);

        TextView txtScoreValue = (TextView) findViewById(R.id.txtScoreValue);
        txtScoreValue.setTypeface(Globals.ReckonerFace, Typeface.BOLD);

        TextView txtScoreText = (TextView) findViewById(R.id.txtScoreText);
        txtScoreText.setTypeface(Globals.ReckonerFace, Typeface.BOLD);

        Button btnPlayOneChance =    (Button) findViewById(R.id.btnPlayOneChance);
        btnPlayOneChance.setTypeface(Globals.ReckonerFace, Typeface.BOLD);
        btnPlayOneChance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Globals.currentStage.setType(GameType.SURVIVAL);
                Globals.TimeForAnyStageParts = 2500;
                //Globals.currentStage.setTouchOrderType(StageTouchOrderType.NORMAL);
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Globals.currentStage.setScore(0);

        Button btnPlayTimeTrail = (Button) findViewById(R.id.btnPlayTimeTrail);
        btnPlayTimeTrail.setTypeface(Globals.ReckonerFace, Typeface.BOLD);
        btnPlayTimeTrail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MenuActivity.this, "NOT TADAY", Toast.LENGTH_LONG).show();
                Globals.currentStage.setType(GameType.TIME_TRAIL);
                Globals.TimeForAnyStageParts = 60000;
                //Globals.currentStage.setTouchOrderType(StageTouchOrderType.COMPLEX);
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Globals.context = getBaseContext();

        File extDir = getExternalFilesDir(null);
        //String path = extDir.getAbsolutePath();
        Globals.fileSaveData = new File(extDir, Globals.SAVE_FILE_NAME);


        try {

            if (Globals.fileSaveData.exists() == false) {
                createFile();
            }

            getBestScore();
            //txtScoreText.setText(Globals.currentStage.getSurvivalModeBestScore() + Globals.currentStage.getTimeTrailModeBestScore() + Globals.currentStage.getComplexModeBestScore() + "");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


//        try {
//            createFile();
//            readFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }




        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float percent = 0.8f;
        int seventyVolume = (int) (maxVolume*percent);
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, seventyVolume, 0);




    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();


        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

    }

    public boolean checkExternalStorage() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {

//            TextView txt1 = (TextView) findViewById(R.id.textView1);
//            txt1.setText("External Storage Read Only");

        } else {
//            TextView txt1 = (TextView) findViewById(R.id.textView1);
//            txt1.setText("External Storage Unavailable");

        }
        return false;
    }


    public void createFile() throws IOException, JSONException {

        if (!checkExternalStorage()) {
            return;
        }


        JSONArray data = new JSONArray();
        JSONObject tour;


        tour = new JSONObject();

        tour.put("best_score_survival", 0);
        tour.put("best_score_time_trail", 0);
//        tour.put("price", 900);
        data.put(tour);

//        tour = new JSONObject();
//        tour.put("tour", "Pars Gulf");
//        tour.put("price", 1200);
//        data.put(tour);
//
//        tour = new JSONObject();
//        tour.put("tour", "Omman See");
//        tour.put("price", 600);
//        data.put(tour);


        String text = data.toString();

        FileOutputStream fos = new FileOutputStream(Globals.fileSaveData);
        fos.write(text.getBytes());
        fos.close();


//        TextView txt1 = (TextView) findViewById(R.id.textView1);
//        txt1.setText("File written To Disk:\n" + data.toString());


    }


    public void getBestScore() throws IOException, JSONException {


        FileInputStream fis = new FileInputStream(Globals.fileSaveData);
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuffer b = new StringBuffer();

        while (bis.available() != 0) {
            char c = (char) bis.read();
            b.append(c);

        }

        Log.d(Globals.LOG_TAG, b.toString());

        JSONArray data = new JSONArray(b.toString());

        StringBuffer toursBuffer = new StringBuffer();
        for (int i = 0; i < data.length(); i++) {
            //Log.d(Globals.LOG_TAG, "HAHA ");
            //String s = data.getJSONObject(i).getString("best_score_normal");
            //Log.d(Globals.LOG_TAG, s);
            Globals.currentStage.setSurvivalModeBestScore(data.getJSONObject(i).getInt("best_score_survival"));
            Globals.currentStage.setTimeTrailModeBestScore(data.getJSONObject(i).getInt("best_score_time_trail"));
            //Globals.currentStage.setComplexModeBestScore(data.getJSONObject(i).getInt("best_score_complex"));
            //Log.d(Globals.LOG_TAG, "NORMAL : " + Globals.currentStage.getSurvivalModeBestScore() + "  REVERSE : " + Globals.currentStage.getTimeTrailModeBestScore() + "  REVERSE : " + Globals.currentStage.getComplexModeBestScore());
        }

        bis.close();


        //return bestScoreNormal + bestScoreReverse;

    }

}
