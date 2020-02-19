
package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() {

        try {
            if (message.contains("happy")) {
                return "happy";
            }
            if (message.isEmpty()) {
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.IS_EMPTY_STRING, "message is empty");
            } else {
                return "sad";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.IS_NULL_STRING, "not a valid message");
        }
    }
}