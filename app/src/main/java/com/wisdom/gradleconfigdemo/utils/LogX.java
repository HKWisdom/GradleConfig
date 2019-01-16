/**
 * Log.java[V 1.0.0]
 * classes : com.com.eric.xlee.log
 * Xlee Create at 17 Nov 2015 14:14:54
 */
package com.wisdom.gradleconfigdemo.utils;


import android.text.TextUtils;
import android.util.Log;

/**
 * <p>Print log auto set TAG as CallerName and click logs will jump to the logged codes.</p>
 * <p>LogX in MainActivity.java:
 * <ul><li><code>
 * LogX.i("Hello world!");
 * </code></li>
 * <li><code>
 * I/MainActivity: (MainActivity.java:19)#onCreate  Hello world!
 * </code></li>
 * </ul>
 * Click (MainActivity.java:19) IDE will jump to MainActivity.java and located at line 19
 *
 */
public class LogX {
    private static boolean sIsDebug = true;


    private static final String DEFAULT_TAG = "Log";

    public static void i(String paramString) {
        if (sIsDebug) {
            String[] paramStrings = getLogTextAndFileName(paramString);
            Log.i(paramStrings[0], paramStrings[1]);
        }
    }

    public static void i(String paramString1, String paramString2) {
        if (sIsDebug)
            Log.i(paramString1, getLogText(paramString2));
    }

    public static void isDebug(boolean paramBoolean) {
        sIsDebug = paramBoolean;
    }

    public static void d(String paramString) {
        if (sIsDebug) {
            String[] paramStrings = getLogTextAndFileName(paramString);
            Log.d(paramStrings[0], paramStrings[1]);
        }
    }

    public static void d(String paramString1, String paramString2) {
        if (sIsDebug)
            Log.d(paramString1, getLogText(paramString2));
    }

    public static void e(String paramString) {
        if (sIsDebug) {
            String[] paramStrings = getLogTextAndFileName(paramString);
            Log.e(paramStrings[0], paramStrings[1]);
        }
    }

    public static void e(String paramString1, String paramString2) {
        if (sIsDebug)
            Log.e(paramString1, getLogText(paramString2));
    }

    public static void w(String paramString) {
        if (sIsDebug) {
            String[] paramStrings = getLogTextAndFileName(paramString);
            Log.w(paramStrings[0], paramStrings[1]);
        }
    }

    public static void w(String paramString1, String paramString2) {
        if (sIsDebug)
            Log.w(paramString1, getLogText(paramString2));
    }

    public static void v(String paramString) {
        if (sIsDebug) {
            String[] paramStrings = getLogTextAndFileName(paramString);
            Log.v(paramStrings[0], paramStrings[1]);
        }
    }

    public static void v(String paramString1, String paramString2) {
        if (sIsDebug) {
            Log.v(paramString1, getLogText(paramString2));
        }
    }

    private static String getLogText(String paramString) {
        StackTraceElement traceElement = new Throwable().fillInStackTrace().getStackTrace()[2];
        return getLogTextWithStackTraceElement(traceElement, paramString);
    }

    private static String[] getLogTextAndFileName(String paramString) {
        StackTraceElement traceElement = new Throwable().fillInStackTrace().getStackTrace()[2];
        return new String[]{getFileNameTAG(traceElement), getLogTextWithStackTraceElement(traceElement, paramString)};
    }

    private static String getLogTextWithStackTraceElement(StackTraceElement traceElement, String paramString) {
        if (null != traceElement) {
            return new StringBuilder().append(getFileLocation(traceElement))
                    .append("#").append(traceElement.getMethodName()).append("  ")
                    .append(paramString).toString();
        } else {
            return paramString;
        }
    }

    private static String getFileLocation(StackTraceElement traceElement) {
        if (traceElement == null) return "Null";
        return "(" + traceElement.getFileName() + ":" + traceElement.getLineNumber() + ")";
    }

    private static String getFileNameTAG(StackTraceElement traceElement) {
        if (null != traceElement) {
            String fileName = traceElement.getFileName();
            if (TextUtils.isEmpty(fileName) || !fileName.contains(".")) {
                return DEFAULT_TAG;
            } else {
                return fileName.split("\\.")[0];
            }
        }
        return DEFAULT_TAG;
    }
}