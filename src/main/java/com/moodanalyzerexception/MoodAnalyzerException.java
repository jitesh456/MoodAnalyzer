package com.moodanalyzerexception;

public class MoodAnalyzerException extends RuntimeException {
    public enum ExceptionType {
        IS_EMPTY_STRING, IS_NULL_STRING, CLASS_NOT_FOUND, NO_SUCH_METHOD, NO_SUCH_FIELD, FIELD_INVOCATION_ISSUE;

    }

    public ExceptionType type;

    public MoodAnalyzerException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
