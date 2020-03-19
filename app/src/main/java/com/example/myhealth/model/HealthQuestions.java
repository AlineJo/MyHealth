package com.example.myhealth.model;

public class HealthQuestions {
    private String question;
    private boolean isRadio;
    private String answer1;
    private String answer2;

    public HealthQuestions(String question, boolean isRadio, String answer1, String answer2) {
        this.question = question;
        this.isRadio = isRadio;
        this.answer1 = answer1;
        this.answer2 = answer2;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isRadio() {
        return isRadio;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }
}
