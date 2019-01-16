package com.wisdom.gradleconfigdemo.utils;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogUtils {
    private static final String TAG = "api";
    private static final boolean DEBUG = true;
    private static final int JSON_INDENT = 2;
    private static final AtomicBoolean sInited = new AtomicBoolean(false);

    private static final String PREFIX = " ┌─────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String LINE_PREFIX = " │ ";
    private static final String MID_SEP = " ├─────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String SUFFIX = " └─────────────────────────────────────────────────────────────────────────────────────────────";

    public static void i(String msgs) {
        print(Log.INFO, msgs);
    }

    private static void print(int level, String msgs) {
        if (!DEBUG)
            return;
        Log.println(level, TAG, PREFIX);
        printMethod(level);
        Log.println(level, TAG, MID_SEP);
        if (TextUtils.isEmpty(msgs)) {
            Log.println(level, TAG, wrap("Empty"));
        } else {
            String[] splits = msgs.split("\n");
            for (String s : splits) {
                Log.println(level, TAG, wrap(s));
            }
        }
        Log.println(level, TAG, SUFFIX);
    }

    private static void printMethod(int level) {
        if (!DEBUG)
            return;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            int count = stackTrace.length;
            int logNum = 0;
            for (int i = 0; i < count; i++) {
                StackTraceElement traceElement = stackTrace[i];
                String className = traceElement.getClassName();
                String logUtilClassName = LogUtil.class.getName();
                if (className != null) {
                    if (className.startsWith("java")
                            || className.startsWith("android")
                            || className.startsWith("dalvik")
                            || className.startsWith("system")
                            || className.startsWith(logUtilClassName)) {
                        continue;
                    }
                    Log.println(level, TAG, wrap(getTraceInfo(traceElement)));
                    logNum++;
                    if (logNum >= 3) {
                        break;
                    }
                }
            }
        }
    }

    private static String getTraceInfo(StackTraceElement traceElement) {
        if (traceElement == null) return "Null";
        return traceElement.getClassName()
                + "."
                + traceElement.getMethodName()
                + " ("
                + traceElement.getFileName()
                + ":"
                + traceElement.getLineNumber()
                + ")";
    }

    private static String wrap(String s) {
        return LINE_PREFIX + s;
    }


    private LogUtils() {
    }

    public static void e(String s) {
        print(Log.ERROR, s);
    }


    public static void v(String s) {
        print(Log.VERBOSE, s);
    }

    public static void d(String s) {
        print(Log.DEBUG, s);
    }

    /**
     * log.json
     *
     * @param json
     */
    public static void json(String json) {
        if (TextUtils.isEmpty(json)) {
            print(Log.INFO, "Empty/Null json content");
            return;
        }
        try {
            json = json.trim();
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                String message = jsonObject.toString(JSON_INDENT);
                print(Log.INFO, message);
                return;
            }
            if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                String message = jsonArray.toString(JSON_INDENT);
                print(Log.INFO, message);
                return;
            }
            print(Log.ERROR, "Invalid Json");
        } catch (JSONException e) {
            print(Log.ERROR, "Invalid Json");
        }
    }

    /**
     * log.json
     *
     * @param json
     */
    public static void json(String prefix, String json) {
        String pre = prefix == null ? " " : prefix + "\n";
        if (TextUtils.isEmpty(json)) {
            print(Log.INFO, pre + "Empty/Null json content");
            return;
        }
        try {
            json = json.trim();
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                String message = jsonObject.toString(JSON_INDENT);
                print(Log.INFO, pre + message);
                return;
            }
            if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                String message = jsonArray.toString(JSON_INDENT);
                print(Log.INFO, pre + message);
                return;
            }
            print(Log.ERROR, pre + "Invalid Json");
        } catch (JSONException e) {
            print(Log.ERROR, pre + "Invalid Json");
        }
    }

    public static void object(Object o) {
        if (o == null) {
            e("Invalid Param Null");
            return;
        }
        String s = o.toString();
        StringBuilder stringBuilder = new StringBuilder();
        if (s.contains("{") && s.contains("}")) {
            int left = s.indexOf("{");
            int right = s.lastIndexOf("}");
            stringBuilder.append(s.substring(0, left + 1)).append("\n");
            String content = s.substring(left + 1, right);
            String end = s.substring(right);
            if (content.contains(",")) {
                String[] split = content.split(",");
                for (String sp : split) {
                    stringBuilder.append("    ").append(sp).append(",").append("\n");
                }
            } else {
                stringBuilder.append(content).append("\n");
            }
            stringBuilder.append(end);
            print(Log.INFO, stringBuilder.toString());
        } else {
            print(Log.INFO, s);
        }


    }

    public static void array(String tag, Object[] array) {
        i(tag + "\n" + Arrays.toString(array));
    }
}
