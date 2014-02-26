package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
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
 * @author ajkwak@users.noreply.github.com (AJ Parmidge)
 */
public class CheatActivity extends Activity {
    // private static final String TAG = "CheatActivity";
    /**
     * Key for storing whether or not the answer to a question is true as an extra in an
     * {@link Intent}.
     */
    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.bignerdranch.android.geoquiz.answer_is_true";
    /**
     * Key for storing whether or not the user cheated on a question as an extra in an
     * {@link Intent}.
     */
    public static final String EXTRA_USER_CHEATED =
            "com.bignerdranch.android.geoquiz.extra_user_cheated";
    /**
     * Key for storing whether or not the user cheated into the saved instance state {@link Bundle}
     * for an {@link Activity}.
     */
    public static final String KEY_USER_CHEATED = "com.bignerdranch.android.geoquiz.user_cheated";

    private boolean mAnswerIsTrue;
    private boolean mAnswerIsShown;
    private TextView mVerifyCheatIntentTextView;
    private TextView mAnswerTextView;
    private TextView mApiLevelTextView;
    private Button mShowAnswer;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_USER_CHEATED, isAnswerShown);
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
        if (savedInstanceState != null) {
            mAnswerIsShown = savedInstanceState.getBoolean(KEY_USER_CHEATED, false);
        } else {
            mAnswerIsShown = i.getBooleanExtra(EXTRA_USER_CHEATED, false);
        }

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

        mApiLevelTextView = (TextView) findViewById(R.id.api_level_text_view);
        mApiLevelTextView.setText(String.format(getString(R.string.api_level_text),
                Build.VERSION.SDK_INT));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY_USER_CHEATED, mAnswerIsShown);
    }

    private void showAnswer() {
        mAnswerIsShown = true;
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
