package com.sparta.thespringsons.finalapiproject.model.fields;

public class Awards {

    private Integer wins;

    private Integer nominations;

    private String text;

    public Integer getNominations() {
        return nominations;
    }

    public String getText() {
        return text;
    }
    public Integer getWins() {
        return wins;
    }

    @Override
    public String toString() {
        return "Awards{" +
                "nominations=" + nominations +
                ", text='" + text + '\'' +
                ", wins=" + wins +
                '}' +
                '\n';
    }
}
