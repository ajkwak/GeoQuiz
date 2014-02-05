package com.bignerdranch.android.geoquiz;

/**
 * A class representing a single question with a boolean answer ({@code true} or {@code false}.
 * 
 * @author Bill Phillips
 * @author Brian Hardy
 * @author AJ Parmidge
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    /**
     * Creates a new boolean (True/False) question.
     *
     * @param question the text of the boolean question
     * @param trueQuestion the answer to the question
     */
    public TrueFalse(int question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    /**
     * Returns the text of this boolean question.
     */
    public int getQuestion() {
        return mQuestion;
    }

    /**
     * Sets the text of this boolean question to the string resource with the given value.
     */
    public void setQuestion(int question) {
        mQuestion = question;
    }

    /**
     * Returns whether or not the answer to this question is {@code true}.
     */
    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    /**
     * Sets whether the answer to this question is {@code true} or {@code false}.
     */
    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }
}
