package com.parsveda.brainboost.reverseanswer.base;

import android.content.res.Resources;
import android.util.TypedValue;

import java.util.Random;

/**
 * Created by kami on 12/16/2016.
 */
public class Utils {

    private static Random rand = new Random();

//    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

//    public static int generateViewId() {
//        for (; ; ) {
//            final int result = sNextGeneratedId.get();
//            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
//            int newValue = result + 1;
//            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
//            if (sNextGeneratedId.compareAndSet(result, newValue)) {
//                return result;
//            }
//        }
//    }

    public static int convertDpToPixel(Resources res, int dp) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, res.getDisplayMetrics());
        return px;

    }

//    public static RelativeLayout.LayoutParams createLayout(Resources res, String attrib) {
//
//
////        Globals.currentStage.addPartCount(1);
//        Level level = null;
//        for (Level lvl : Globals.levels) {
//            if (lvl.getPartCount() > Globals.currentStage.getPartCount()) {
//                level = lvl;
//                break;
//            }
//        }
//
//
//        int sizeVar = 0;
//        if (level != null) {
//            sizeVar = level.getSizeVar();
//        } else {
//            sizeVar = 15;
//        }
//
//        int size = 0;
//
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Utils.convertDpToPixel(res, 100), Utils.convertDpToPixel(res, 100));
//        //Log.d(Globals.LOG_TAG, attrib);
//        String[] attribs = attrib.trim().split(",");
//        for (String att : attribs) {
//            String[] parts = att.trim().split(":");
//            int px = 0;
//
//            switch (parts[0]) {
//                case "align_parent_start":
//                    params.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);
//                    break;
//                case "align_parent_top":
//                    params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
//                    break;
//                case "align_parent_bottom":
//                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
//                    break;
//                case "align_parent_right":
//                    params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
//                    break;
//                case "align_parent_left":
//                    params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
//                    break;
//                case "align_parent_end":
//                    params.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
//                    break;
//
//                case "to_end_of":
//                    params.addRule(RelativeLayout.END_OF, Globals.IDS[Integer.parseInt(parts[1])]);
//                    break;
//                case "to_start_of":
//                    params.addRule(RelativeLayout.START_OF, Globals.IDS[Integer.parseInt(parts[1])]);
//                    break;
//                case "align_bottom":
//                    params.addRule(RelativeLayout.ALIGN_BOTTOM, Integer.parseInt(parts[1]));
//                    break;
//                case "align_end":
//                    params.addRule(RelativeLayout.ALIGN_END, Integer.parseInt(parts[1]));
//                    break;
//
//                case "align_top":
//                    params.addRule(RelativeLayout.ALIGN_TOP, Integer.parseInt(parts[1]));
//                    break;
//                case "below":
//                    params.addRule(RelativeLayout.BELOW, Integer.parseInt(parts[1]));
//                    Log.d(Globals.LOG_TAG, "BELOW : " + Integer.parseInt(parts[1]));
//                    break;
//                case "center_horizontal":
//                    params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
//                    break;
//                case "center_vertical":
//                    params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
//                    break;
//                case "center_in_parent":
//                    params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
//                    break;
//                case "align_start":
//                    params.addRule(RelativeLayout.ALIGN_START, Globals.IDS[Integer.parseInt(parts[1])]);
//                    break;
//                case "margin_start":
//                    px = Utils.convertDpToPixel(res, Integer.parseInt(parts[1]));
//                    params.setMarginStart(px);
//                    break;
//                case "margin_end":
//                    px = Utils.convertDpToPixel(res, Integer.parseInt(parts[1]));
//                    params.setMarginEnd(px);
//                    break;
//                case "margin_top":
//                    px = Utils.convertDpToPixel(res, Integer.parseInt(parts[1]));
//                    params.topMargin = px;
//                    break;
//                case "margin_bottom":
//                    px = Utils.convertDpToPixel(res, Integer.parseInt(parts[1]));
//                    params.bottomMargin = px;
//                    break;
//                case "margin_left":
//                    px = Utils.convertDpToPixel(res, Integer.parseInt(parts[1]));
//                    params.leftMargin = px;
//                    break;
//                case "margin_right":
//                    px = Utils.convertDpToPixel(res, Integer.parseInt(parts[1]));
//                    params.rightMargin = px;
//                    break;
//                case "width":
//                    if (size == 0) {
//                        size = rand.nextInt(sizeVar);
//                        int sign = rand.nextInt(2);
//                        size = sign == 0 ? size : -size;
//                    }
//                    px = Utils.convertDpToPixel(res, Integer.parseInt(parts[1]) + size);
//                    params.width = px;
//                    break;
//                case "height":
//                    if (size == 0) {
//                        size = rand.nextInt(sizeVar);
//                        int sign = rand.nextInt(2);
//                        size = sign == 0 ? size : -size;
//                    }
//                    px = Utils.convertDpToPixel(res, Integer.parseInt(parts[1]) + size);
//                    params.height = px;
//                    break;
//            }
//        }
//        return params;
//    }


}
