package com.parsveda.brainboost.reverseanswer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

public class ResultActivity extends AppCompatActivity {


    private File file;
    //private static final String FILENAME = "player.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_result);

        //Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Reckoner.ttf");
        //Log.d(Globals.LOG_TAG, "11111111111");

        TextView txtScore = (TextView) findViewById(R.id.txtScore);
        Button btnRetry = (Button) findViewById(R.id.btnRetry);
        Button btnShare = (Button) findViewById(R.id.btnShare);
        Button btnMenu = (Button) findViewById(R.id.btnMenu);
        //Log.d(Globals.LOG_TAG, "11111111111");

        txtScore.setTypeface(Globals.ReckonerFace, Typeface.BOLD);


//        if (Globals.currentStage.getTouchOrderType() == StageTouchOrderType.NORMAL) {
//            txtScore.setTextColor(ContextCompat.getColor(ResultActivity.this, R.color.mid_blue));
//        } else if (Globals.currentStage.getTouchOrderType() == StageTouchOrderType.REVERSE) {
//            txtScore.setTextColor(ContextCompat.getColor(ResultActivity.this, R.color.dark_teal));
//        }

        txtScore.setText(Globals.currentStage.getScore() + "");
        btnRetry.setTypeface(Globals.ReckonerFace, Typeface.BOLD);
        btnMenu.setTypeface(Globals.ReckonerFace, Typeface.BOLD);
        btnShare.setTypeface(Globals.ReckonerFace, Typeface.BOLD);


        //Log.d(Globals.LOG_TAG, "11111111111");
//        File extDir = getExternalFilesDir(null);
//        //String path = extDir.getAbsolutePath();
//        Globals.fileSaveData = new File(extDir, Globals.SAVE_FILE_NAME);

        File extDir = getExternalFilesDir(null);
        String path = extDir.getAbsolutePath();
        file = new File(extDir, Globals.SAVE_FILE_NAME);


        try {

            if (Globals.currentStage.getType() == GameType.SURVIVAL) {
                if (Globals.currentStage.getScore() > Globals.currentStage.getSurvivalModeBestScore()) {
                    createFile();
                    Globals.currentStage.setSurvivalModeBestScore(Globals.currentStage.getScore());
                }
            } else if (Globals.currentStage.getType() == GameType.TIME_TRAIL) {
                if (Globals.currentStage.getScore() > Globals.currentStage.getTimeTrailModeBestScore()) {
                    createFile();
                    Globals.currentStage.setTimeTrailModeBestScore(Globals.currentStage.getScore());
                }
            }


            //readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

//
//        try {
//
//            Log.d(Globals.LOG_TAG, "PRIOR BEST SCORE :" + getBestScore());
//            Log.d(Globals.LOG_TAG, "PRESENT BEST SCORE :" + Globals.currentStage.getScore());
//
//            if (Globals.currentStage.getScore() > getBestScore()) {
//                createFile();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.currentStage.setScore(0);
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.exit(0);
                Globals.currentStage.setScore(0);
                Intent intent = new Intent(ResultActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }


//    public void createFile() throws IOException, JSONException {
//
//        if (!Globals.CanSaveData) {
//            return;
//        }
//
//        JSONArray data = new JSONArray();
//        JSONObject tour;
//
//        tour = new JSONObject();
//
//        tour.put("best_score", Globals.currentStage.getScore());
//        data.put(tour);
//
//        String text = data.toString();
//
//        FileOutputStream fos = new FileOutputStream(Globals.fileSaveData);
//        fos.write(text.getBytes());
//        fos.close();
//
//    }
//
//
//    public int getBestScore() throws IOException, JSONException {
//
//        FileInputStream fis = new FileInputStream(Globals.fileSaveData);
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        StringBuffer b = new StringBuffer();
//
//        while (bis.available() != 0) {
//            char c = (char) bis.read();
//            b.append(c);
//
//        }
//
//        JSONArray data = new JSONArray(b.toString());
//        int bestScore = 0;
//        StringBuffer toursBuffer = new StringBuffer();
//        for (int i = 0; i < data.length(); i++) {
//            bestScore = data.getJSONObject(i).getInt("best_score");
//        }
//
//        bis.close();
//        return bestScore;
//
//    }


    public void createFile() throws IOException, JSONException {

        if (!checkExternalStorage()) {
            return;
        }

        JSONArray data = new JSONArray();
        JSONObject tour;


        tour = new JSONObject();

        if (Globals.currentStage.getType() == GameType.SURVIVAL) {
            tour.put("best_score_survival", Globals.currentStage.getScore());
            tour.put("best_score_time_trail", Globals.currentStage.getTimeTrailModeBestScore());
        } else if (Globals.currentStage.getType() == GameType.TIME_TRAIL) {
            tour.put("best_score_time_trail", Globals.currentStage.getScore());
            tour.put("best_score_survival", Globals.currentStage.getSurvivalModeBestScore());
        }
        //tour.put("best_score", Globals.currentStage.getScore());
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

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(text.getBytes());
        fos.close();
    }

    public void readFile() throws IOException, JSONException {

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuffer b = new StringBuffer();

        while (bis.available() != 0) {
            char c = (char) bis.read();
            b.append(c);

        }

        JSONArray data = new JSONArray(b.toString());

        StringBuffer toursBuffer = new StringBuffer();
        for (int i = 0; i < data.length(); i++) {
            String tour = data.getJSONObject(i).getString("best_score");
            toursBuffer.append(tour + "\n");
        }

        Log.d(Globals.LOG_TAG, toursBuffer.toString());
//        TextView txt1 = (TextView) findViewById(R.id.textView1);
//        txt1.setText(toursBuffer.toString());
        bis.close();


    }


    public int getBestScore() throws IOException, JSONException {

        FileInputStream fis = new FileInputStream(Globals.fileSaveData);
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuffer b = new StringBuffer();

        while (bis.available() != 0) {
            char c = (char) bis.read();
            b.append(c);

        }

        Log.d(Globals.LOG_TAG, b.toString());
        JSONArray data = new JSONArray(b.toString());
        int bestScore = 0;

        StringBuffer toursBuffer = new StringBuffer();

//        for (int i = 0; i < data.length(); i++) {
//            if (Globals.currentStage.getTouchOrderType() == StageTouchOrderType.NORMAL) {
//                bestScore = data.getJSONObject(i).getInt("best_score_normal");
//            } else if (Globals.currentStage.getTouchOrderType() == StageTouchOrderType.REVERSE) {
//                bestScore = data.getJSONObject(i).getInt("best_score_reverse");
//            }
//
//            Log.d(Globals.LOG_TAG, "BEEEEESSSSSSTTTT : " + bestScore);
//        }

        bis.close();
        return bestScore;

    }


    public int getBestScoreForNormalMode() throws IOException, JSONException {

        FileInputStream fis = new FileInputStream(Globals.fileSaveData);
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuffer b = new StringBuffer();

        while (bis.available() != 0) {
            char c = (char) bis.read();
            b.append(c);

        }

        Log.d(Globals.LOG_TAG, b.toString());
        JSONArray data = new JSONArray(b.toString());
        int bestScore = 0;

        StringBuffer toursBuffer = new StringBuffer();
        for (int i = 0; i < data.length(); i++) {
            bestScore = data.getJSONObject(i).getInt("best_score_normal");
            //Log.d(Globals.LOG_TAG, "BEST_SCORE_NORMAL: " + bestScore);
        }

        bis.close();
        return bestScore;

    }


    public int getBestScoreForReverseMode() throws IOException, JSONException {

        FileInputStream fis = new FileInputStream(Globals.fileSaveData);
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuffer b = new StringBuffer();

        while (bis.available() != 0) {
            char c = (char) bis.read();
            b.append(c);

        }

        Log.d(Globals.LOG_TAG, b.toString());
        JSONArray data = new JSONArray(b.toString());
        int bestScore = 0;

        StringBuffer toursBuffer = new StringBuffer();
        for (int i = 0; i < data.length(); i++) {
            bestScore = data.getJSONObject(i).getInt("best_score_revrese");
            //Log.d(Globals.LOG_TAG, "BEST_SCORE_REVERS: " + bestScore);
        }

        bis.close();
        return bestScore;

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


}
