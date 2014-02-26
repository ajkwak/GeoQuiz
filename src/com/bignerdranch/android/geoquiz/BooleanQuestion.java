package com.bignerdranch.android.geoquiz;

/**
 * A class representing a single question with a boolean answer ({@code true} or {@code false}).
 *
 * @author Bill Phillips
 * @author Brian Hardy
 * @author ajkwak@users.noreply.github.com (AJ Parmidge)
 */
public class BooleanQuestion {
    private int mQuestion;
    private boolean mAnswer;

    /**
     * Creates a new boolean (True/False) question.
     *
     * @param question the resource ID corresponding to the text of this boolean question
     * @param answer the answer to the question
     */
    public BooleanQuestion(int question, boolean answer) {
        mQuestion = question;
        mAnswer = answer;
    }

    /**
     * Returns the resource ID corresponding to the text of this boolean question.
     */
    public int getQuestion() {
        return mQuestion;
    }

    /**
     * Sets the text of this boolean question to the string resource with the given value.
     */
    protected void setQuestion(int question) {
        mQuestion = question;
    }

    /**
     * Returns whether or not the answer to this question is {@code true}.
     */
    public boolean isTrueQuestion() {
        return mAnswer;
    }

    /**
     * Sets whether the answer to this question is {@code true} or {@code false}.
     */
    protected void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
