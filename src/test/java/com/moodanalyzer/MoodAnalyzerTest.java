package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {


    @Test
    public void givenHappyMood() {
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
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.IS_NULL_STRING,e.type);
        }

    }

}
