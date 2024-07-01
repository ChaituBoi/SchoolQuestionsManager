package com.project1.QuestionsManager.Exceptions;

public class QuestionNotFound extends RuntimeException{

    private String message;

    public QuestionNotFound(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
