package com.moodanalyzerexception;

public class MoodAnalyzerException extends RuntimeException {
    public enum ExceptionType
    {
        IS_EMPTY_STRING,IS_NULL_STRING;
    }
    public ExceptionType type;
    public MoodAnalyzerException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
