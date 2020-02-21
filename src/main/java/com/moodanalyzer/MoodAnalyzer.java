
package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {
        this.message = "default";
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

    /* public boolean equals(Object another) {
         if (this.message.equals(((MoodAnalyzer)another).message))
             return true;
         return false;
     }*/
    public boolean equals(Object another) {
        if (this.message.equals(((MoodAnalyzer) another).message))
            return true;
        return false;
    }
}