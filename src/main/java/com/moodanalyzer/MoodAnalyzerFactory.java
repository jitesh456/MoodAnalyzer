package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;
import com.sun.tools.javac.code.Attribute;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {


    public static MoodAnalyzer createAnalyseMood(String message, String className, Class constructor) {

        Constructor<?> moodAnalyzeClass = null;
        try {
            if (className.isEmpty()) {
                moodAnalyzeClass = Class.forName("com.moodanalyzer.MoodAnalyzer").getConstructor();
                MoodAnalyzer moodAnalyse = (MoodAnalyzer) moodAnalyzeClass.newInstance();
                return moodAnalyse;

            } else {

                moodAnalyzeClass = Class.forName(className).getConstructor(constructor);
                MoodAnalyzer moodAnalyse = (MoodAnalyzer) moodAnalyzeClass.newInstance(message);
                return moodAnalyse;
            }


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


    public static String invokeRuntimeMethod(String message, String methodName) {

        Class<?> classMood = null;
        try {
            classMood = Class.forName("com.moodanalyzer.MoodAnalyzer");
            Object object = classMood.getConstructor(String.class).newInstance(message);
            Method message1 = object.getClass().getDeclaredMethod(methodName);
            return (String) message1.invoke(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static String setFieldValue(String message, String fieldName) {
        try {
            Class<?> aClass = Class.forName("com.moodanalyzer.MoodAnalyzer");
            Object o = aClass.getConstructor().newInstance();

            Field field = o.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(o, message);
            return (String) o.getClass().getMethod("analyzeMood").invoke(o);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.FIELD_INVOCATION_ISSUE, e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_FIELD, e.getMessage());
        }
        return null;
    }
}


