package com.parsveda.brainboost.reverseanswer.base;

import android.content.Context;
import android.graphics.Typeface;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;

import com.parsveda.brainboost.reverseanswer.model.Level;
import com.parsveda.brainboost.reverseanswer.model.Question;
import com.parsveda.brainboost.reverseanswer.model.Questions;
import com.parsveda.brainboost.reverseanswer.model.Score;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by kami on 12/16/2016.
 */
public class Globals {

    public static List<Button> buttons = new ArrayList<>();

    public static Context context;

    public static File fileSaveData;
    public static final String SAVE_FILE_NAME = "player.json";
    public static boolean CanSaveData = false;

    public static int DelayBetweenStageParts = 100;
    public static int TimeForAnyStageParts = 3000;
    public static int IntervalOfShowingTime = 100;

    public static final int EARNING_SCRORE_FOR_NORMAL_MODE = 1;
    public static final int EARNING_SCRORE_FOR_REVERSE_MODE = 2;
    public static final int EARNING_SCRORE_FOR_COMPLEX_MODE = 3;


    public static Typeface ReckonerFace;

    public static String LOG_TAG = "Three_Seconds";
//    public static int currentValue = 0;
//    public static int score = 0;
//    public static float time = 0.0f;


    public static Score currentStage = new Score();


    //public static List<Preset> presets = new ArrayList<>();
    //public static List<StageItem> stages = new ArrayList<>();


    public static List<Level> levels = new ArrayList<>();


    //public static int selectedPresetId = 0;
    public static final int IDS[] = {1101, 1102, 1103, 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118, 1119, 1120};


    public static Questions questions = new Questions();

    public static Question currentQuestion = new Question();

    public  static TextToSpeech textToSpeech;

//    public static void loadPresets() {
//        try {
//
//            InputStream is = context.getAssets().open("Presets.xml");
//            //Log.d(Globals.LOG_TAG, "csdasadasd");
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(is);
//
//            Element element = doc.getDocumentElement();
//            element.normalize();
//            NodeList nList = doc.getElementsByTagName("Preset");
//
//            for (int i = 0; i < nList.getLength(); i++) {
//                Node node = nList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Preset preset = new Preset();
//                    //Element element2 = (Element) node;
//                    Log.d(Globals.LOG_TAG, "------------------------------------------");
//                    preset.setName(((Element) node).getAttribute("name") + "");
//                    preset.setId(Integer.parseInt(((Element) node).getAttribute("id") + ""));
//                    Log.d(Globals.LOG_TAG, ((Element) node).getAttribute("id") + "");
//                    Log.d(Globals.LOG_TAG, ((Element) node).getAttribute("name") + "");
//
//                    NodeList nList2 = ((Element) node).getElementsByTagName("View");
//
//
//                    for (int j = 0; j < nList2.getLength(); j++) {
//                        Node node2 = nList2.item(j);
//                        if (node2.getNodeType() == Node.ELEMENT_NODE) {
//
//                            //Element element3 = (Element) node2;
//                            ViewModel mdl = new ViewModel();
//                            Log.d(Globals.LOG_TAG, ((Element) node2).getAttribute("attrib") + "");
//                            Log.d(Globals.LOG_TAG, ((Element) node2).getAttribute("id") + "");
//                            mdl.setAttribs(((Element) node2).getAttribute("attrib") + "");
//                            mdl.setId(Integer.parseInt(((Element) node2).getAttribute("id") + ""));
//
//                            preset.getModels().add(mdl);
//                        }
//                    }
//                    Globals.presets.add(preset);
//                }
//            }
//        } catch (Exception e) {
//            Log.d(Globals.LOG_TAG, e.getMessage().toString());
//        }
//
//
//    }


//    public static void loadStages() {
//        try {
//
//            InputStream is = context.getAssets().open("Stages.xml");
//            //Log.d(Globals.LOG_TAG, "csdasadasd");
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(is);
//
//            Element element = doc.getDocumentElement();
//            element.normalize();
//            NodeList nList = doc.getElementsByTagName("Stage");
//
//            for (int i = 0; i < nList.getLength(); i++) {
//                Node node = nList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    StageItem stageItem = new StageItem();
//                    //Element element2 = (Element) node;
//                    Log.d(Globals.LOG_TAG, "------------------------------------------");
//                    stageItem.setTitle(((Element) node).getAttribute("title") + "");
//
//                    stageItem.setId(Integer.parseInt(((Element) node).getAttribute("id") + ""));
//                    stageItem.setType(StageType.fromInteger(Integer.parseInt(((Element) node).getAttribute("type") + "")));
//                    stageItem.setTargetType(StageTargetType.fromInteger(Integer.parseInt(((Element) node).getAttribute("target_type") + "")));
//                    stageItem.setTarget(Integer.parseInt(((Element) node).getAttribute("target") + ""));
//                    stageItem.setChances(Integer.parseInt(((Element) node).getAttribute("chances") + ""));
//
//
//                    //Log.d(Globals.LOG_TAG, ((Element) node).getAttribute("id") + "");
//                    //Log.d(Globals.LOG_TAG, "type: " + stageItem.getType() + "");
//
//                    //Log.d(Globals.LOG_TAG, ((Element) node).getAttribute("title") + "");
//
////                    NodeList nList2 = ((Element) node).getElementsByTagName("View");
//
//
////                    for (int j = 0; j < nList2.getLength(); j++) {
////                        Node node2 = nList2.item(j);
////                        if (node2.getNodeType() == Node.ELEMENT_NODE) {
////
////                            //Element element3 = (Element) node2;
////                            ViewModel mdl = new ViewModel();
////                            Log.d(Globals.LOG_TAG, ((Element) node2).getAttribute("attrib") + "");
////                            Log.d(Globals.LOG_TAG, ((Element) node2).getAttribute("id") + "");
////                            mdl.setAttribs(((Element) node2).getAttribute("attrib") + "");
////                            mdl.setId(Integer.parseInt(((Element) node2).getAttribute("id") + ""));
////
////                            preset.getModels().add(mdl);
////                        }
////                    }
//                    Globals.stages.add(stageItem);
//                }
//            }
//        } catch (Exception e) {
//            Log.d(Globals.LOG_TAG, e.getMessage().toString());
//        }
//
//
//    }

    public static void loadQuestions() {
        try {
            InputStream is = context.getAssets().open("Questions.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            Element element = doc.getDocumentElement();
            element.normalize();
            NodeList nList = doc.getElementsByTagName("Question");
            for (int i = 0; i < nList.getLength(); i++) {

                //Log.d(Globals.LOG_TAG, "QQQ" + i);

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Question question = new Question();
                    //Element element2 = (Element) node;
                    Log.d(Globals.LOG_TAG, "------------------------------------------");
                    question.setText(((Element) node).getAttribute("text") + "");
                    //question.setId(Integer.parseInt(((Element) node).getAttribute("id") + ""));
                    question.setId(i);
                    question.setAnswer(Integer.parseInt(((Element) node).getAttribute("answer") + ""));
                    Globals.questions.add(question);
                }
            }
        } catch (Exception e) {
            Log.d(Globals.LOG_TAG, e.getMessage().toString());
        }
    }

//    public static void loadLevels() {
//        try {
//
//            InputStream is = context.getAssets().open("Levels.xml");
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(is);
//
//            Element element = doc.getDocumentElement();
//            element.normalize();
//            NodeList nList = doc.getElementsByTagName("Level");
//
//            for (int i = 0; i < nList.getLength(); i++) {
//                Node node = nList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Level level = new Level();
//                    //Element element2 = (Element) node;
//                    Log.d(Globals.LOG_TAG, "------------------------------------------");
//
//                    level.setId(Integer.parseInt(((Element) node).getAttribute("id") + ""));
//                    level.setPartCount(Integer.parseInt(((Element) node).getAttribute("part_count") + ""));
//                    level.setSizeVar(Integer.parseInt(((Element) node).getAttribute("size_var") + ""));
//                    String prst = ((Element) node).getAttribute("preset_shapes_count") + "";
//                    Log.d(Globals.LOG_TAG, prst);
//                    String[] prsts = prst.trim().split(",");
//
//                    for (String s : prsts) {
//                        level.getPresetShapesCount().add(Integer.parseInt(s));
//                    }
//
//                    Globals.levels.add(level);
//                }
//            }
//        } catch (Exception e) {
//            Log.d(Globals.LOG_TAG, e.getMessage().toString());
//        }
//
//
//    }


}
