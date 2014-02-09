package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * A class representing an activity in which users can cheat by viewing the answer to the current
 * quiz question.
 *
 * @author Bill Phillips
 * @author Brian Hardy
 * @author AJ Parmidge
 */
public class CheatActivity extends Activity {
    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.bignerdranch.android.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";

    private boolean mAnswerIsTrue;
    private boolean mAnswerIsShown;
    private TextView mVerifyCheatIntentTextView;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        // Answer will not be shown until the user presses the button.
        setAnswerShownResult(false);

        Intent i = getIntent();
        mAnswerIsTrue = i.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerIsShown = i.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);

        mVerifyCheatIntentTextView = (TextView) findViewById(R.id.verify_cheat_intent_text_view);
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mShowAnswer = (Button) findViewById(R.id.show_answer_button);
        if (mAnswerIsShown) {
            showAnswer();
        } else {
            mVerifyCheatIntentTextView.setText(R.string.verify_cheat_intent_text);
            mShowAnswer.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    showAnswer();
                }
            });
        }
    }

    private void showAnswer() {
        mVerifyCheatIntentTextView.setText(R.string.accept_cheat_intent_text);
        if (mAnswerIsTrue) {
            mAnswerTextView.setText(R.string.true_button);
        } else {
            mAnswerTextView.setText(R.string.false_button);
        }
        mShowAnswer.setEnabled(false);
        setAnswerShownResult(true);
    }
}
