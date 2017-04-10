package com.example.android.oceanquiznew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.oceanquiznew.R.id.q5_a1;
import static com.example.android.oceanquiznew.R.id.q5_a2;
import static com.example.android.oceanquiznew.R.id.q5_a3;

public class Quiz extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }
// This method checks all questions have been answered before totalling the score

    public void checkAnswers(View view) {
        RadioGroup qOne = (RadioGroup) findViewById(R.id.radioGroup1);
        EditText qTwoA = (EditText) findViewById(R.id.q_two_edit_text);
        String ansTwo = qTwoA.getText().toString();
        RadioGroup qThree = (RadioGroup) findViewById(R.id.radioGroup2);
        CheckBox qFourAOne = (CheckBox) findViewById(R.id.q4_cb1);
        CheckBox qFourATwo = (CheckBox) findViewById(R.id.q4_cb2);
        CheckBox qFourAThree = (CheckBox) findViewById(R.id.q4_cb3);
        CheckBox qFourAFour = (CheckBox) findViewById(R.id.q4_cb4);
        RadioGroup qFive = (RadioGroup) findViewById(R.id.radioGroup8);
        RadioButton qFiveOptionOne = (RadioButton) findViewById(q5_a1);
        RadioButton qFiveOptionTwo = (RadioButton) findViewById(q5_a2);
        RadioButton qFiveOptionThree = (RadioButton) findViewById(q5_a3);
        RadioGroup qSix = (RadioGroup) findViewById(R.id.radioGroup6);
        EditText qSevenA = (EditText) findViewById(R.id.q_seven_edit_text);
        String ansSeven = qSevenA.getText().toString();
        if ((qOne.getCheckedRadioButtonId() == -1)
                || (ansTwo.isEmpty())
                || (qThree.getCheckedRadioButtonId() == -1)
                || (qSix.getCheckedRadioButtonId() == -1)
                || (ansSeven.isEmpty())
                || ((!qFiveOptionOne.isChecked()) & (!qFiveOptionTwo.isChecked()) & (!qFiveOptionThree.isChecked()))
                || ((!qFourAOne.isChecked()) & (!qFourATwo.isChecked()) & (!qFourAThree.isChecked()) & (!qFourAFour.isChecked()))
                ) {
            Toast.makeText(this, getString(R.string.submit_check), Toast.LENGTH_SHORT).show();
        } else {
            showScore(view);
        }
    }
// This method calculates score by evaluating each question individually
    private int calculateScore() {
        int score = 0;
        RadioButton qOneAns = (RadioButton) findViewById(R.id.q1_a1);
        EditText qTwoAns = (EditText) findViewById(R.id.q_two_edit_text);
        RadioButton qThreeAns = (RadioButton) findViewById(R.id.q3_a1);
        CheckBox qFourAOne = (CheckBox) findViewById(R.id.q4_cb1);
        CheckBox qFourAThree = (CheckBox) findViewById(R.id.q4_cb3);
        CheckBox qFourAFour = (CheckBox) findViewById(R.id.q4_cb4);
        RadioButton qFiveAOne = (RadioButton) findViewById(q5_a1);
        RadioButton qSixATwo = (RadioButton) findViewById(R.id.q6_a2);
        EditText qSevenA = (EditText) findViewById(R.id.q_seven_edit_text);
        String qSeven = qSevenA.getText().toString();
        String questionTwoAnswer = getString(R.string.q2_ans);
        String questionSevenAnswer = getString(R.string.q7_ans);
        String qTwo = qTwoAns.getText().toString();

        if (qOneAns.isChecked()) {
            score = score + 1;
        }
        if (qTwo.equals(questionTwoAnswer)) {
            score = score + 1;
        }
        if (qThreeAns.isChecked()) {
            score = score + 1;
        }
        if ((qFourAOne.isChecked()) & (qFourAThree.isChecked()) & (qFourAFour.isChecked())) {
            score = score + 1;
        }
        if (qFiveAOne.isChecked()) {
            score = score + 1;
        }
        if (qSixATwo.isChecked()) {
            score = score + 1;
        }
        if (qSeven.equals(questionSevenAnswer)) {
            score = score + 1;
        }
        return score;
    }
// method to show the final scoreMessage
    public void showScore(View view) {
        int score = calculateScore();
        String scoreMessage = getScoreMessage(score);
        Toast.makeText(this, scoreMessage, Toast.LENGTH_SHORT).show();

    }
//Method to create score message based on the user's result
    private String getScoreMessage(int score) {
        String scoreMessage = "";
        if (score > 6) {
            scoreMessage = getString(R.string.score_message_Great) + " ";
            scoreMessage += getString(R.string.score_message1) + " " + score;
            scoreMessage += "\b" + getString(R.string.score_message_great_2);
            return scoreMessage;
        }
        if (score > 3 & score < 7) {
            scoreMessage = getString(R.string.score_message_Good) + " ";
            scoreMessage += getString(R.string.score_message1) + " " + score;
            scoreMessage += "\b" + getString(R.string.score_message_Good2);
            return scoreMessage;
        }
        if (score < 4) {
            scoreMessage = getString(R.string.score_messgae_not_so_good1) + " ";
            scoreMessage += getString(R.string.score_message1) + " " + score;
            scoreMessage += "\b" + getString(R.string.score_messgae_not_so_good2);
            return scoreMessage;
        }
        return scoreMessage;
    }


}
