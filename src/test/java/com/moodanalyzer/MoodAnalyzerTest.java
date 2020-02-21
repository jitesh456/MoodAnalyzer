package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;
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
        MoodAnalyzer mood = MoodAnalyzerFactory.createAnalyseMood("this is happy mood", "com.moodanalyzer.MoodAnalyzer", String.class);
        Assert.assertEquals("happy", mood.analyzeMood());
    }

    @Test
    public void givenMood_WhenEqualUsingDefaultConstructor_ReturnObject() {
        try {
            MoodAnalyzer mood = MoodAnalyzerFactory.createAnalyseMood("this is happy mood", "", String.class);
            Assert.assertEquals(new MoodAnalyzer(), mood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenClassName_WhenNotProperUsingDefaultConstructor_ReturnException() {
        try {
            MoodAnalyzer mood = MoodAnalyzerFactory.createAnalyseMood("this is happy mood", "", String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }

    }

    @Test
    public void givenClassName_WhenNotProperUsingParameterize_ReturnException() {
        try {
            MoodAnalyzer mood = MoodAnalyzerFactory.createAnalyseMood("this is happy mood", "com.moodanalyzer.moodAnalyzer", String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }

    }


    @Test
    public void givenConstructorName_WhenNotProperUsingParametrizeConstructor_ReturnException() {
        try {
            MoodAnalyzer mood = MoodAnalyzerFactory.createAnalyseMood("this is happy mood", "com.moodanalyzer.MoodAnalyzer", Integer.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenObject_WhenEqualUsingParametrizeConstructor_ReturnObject() {
        MoodAnalyzer factoryMood = MoodAnalyzerFactory.createAnalyseMood("this is happy mood", "com.moodanalyzer.MoodAnalyzer", String.class);
        Assert.assertEquals(factoryMood, new MoodAnalyzer("this is happy mood"));
    }

}

