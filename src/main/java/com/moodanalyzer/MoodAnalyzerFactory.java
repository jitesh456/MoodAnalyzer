package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {
    public MoodAnalyzerFactory() {

    }

    public static MoodAnalyzer createAnalyseMood(String message, String className, Class constructor) {

        Constructor<?> moodAnalyzeClass = null;
        try {
            moodAnalyzeClass = Class.forName(className).getConstructor(constructor);
            MoodAnalyzer moodAnalyse = (MoodAnalyzer) moodAnalyzeClass.newInstance(message);
            return moodAnalyse;

        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.CLASS_NOT_FOUND, e.getMessage());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyzer createAnalyseMood() {

        Constructor<?> moodAnalyzeClass = null;
        try {
            moodAnalyzeClass = Class.forName("com.moodanalyzer.MoodAnalyzer").getConstructor();
            MoodAnalyzer moodAnalyse = (MoodAnalyzer) moodAnalyzeClass.newInstance();
            return moodAnalyse;

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}


