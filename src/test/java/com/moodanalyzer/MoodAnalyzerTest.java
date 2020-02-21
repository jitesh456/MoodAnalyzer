package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;
import com.sun.tools.javac.code.Attribute;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLOutput;

public class MoodAnalyzerTest {

    @Test
    public void givenHappyMood_WhenProper_ReturnMood() {
        try {
            MoodAnalyzer analyzeHappyMood = new MoodAnalyzer("This is happy mood");
            String mood = analyzeHappyMood.analyzeMood();
            Assert.assertEquals("happy", mood);

        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMood_WhenNull_ReturnCustom() {
        try {
            MoodAnalyzer analyzeSadMood = new MoodAnalyzer("This is sad message");
            String mood = analyzeSadMood.analyzeMood();
            Assert.assertEquals("sad", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMood_WhenNull_ReturnCustomException() {

        try {

            MoodAnalyzer forNull = new MoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.IS_NULL_STRING, e.type);

        }
    }

    @Test
    public void givenMood_WhenNull_ShouldReturnProperExceptionMessage() {

        try {
            MoodAnalyzer analyzeForEmpty = new MoodAnalyzer("");

        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.IS_NULL_STRING, e.type);
        }

    }

    @Test
    public void givenMood_WhenProper_ReturnObject() {
        MoodAnalyzer mood = MoodAnalyzerFactory.createAnalyseMood("this is happy mood", "com.moodanalyzer.MoodAnalyzer",String.class);
        Assert.assertEquals("happy", mood.analyzeMood());
    }

    @Test
    public void givenMood_WhenEqual_ReturnObject() {
        try {
            MoodAnalyzer mood = MoodAnalyzerFactory.createAnalyseMood();
            Assert.assertEquals(new MoodAnalyzer(), mood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenClassName_WhenNotProper_ReturnException() {
        try {
            MoodAnalyzer mood = MoodAnalyzerFactory.createAnalyseMood("this is happy mood", "com.moodanalyzer.moodAnalyzer",String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }

    }

    @Test
    public void givenConstructorName_WhenNotProper_ReturnException() {
        try {
            MoodAnalyzer mood = MoodAnalyzerFactory.createAnalyseMood("this is happy mood", "com.moodanalyzer.MoodAnalyzer",Integer.class);
        }catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }
}

