package com.example.casob.phonesnothot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.save_button) Button mAskButton;
    @BindView(R.id.ask_button) Button mSaveButton;
    @BindView(R.id.wondering_teen) ImageView mWonderingTeen;
    @BindView(R.id.teen_question) TextView mQuestionTeen;
    @BindView(R.id.big_shaq) ImageView mBigShaq;
    @BindView(R.id.big_shaq_answer) TextView mShaqAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //yg6554r
    }
}
