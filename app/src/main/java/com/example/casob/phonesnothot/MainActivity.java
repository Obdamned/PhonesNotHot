package com.example.casob.phonesnothot;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.save_button)
    Button mAskButton;
    @BindView(R.id.ask_button)
    Button mSaveButton;
    @BindView(R.id.wondering_teen)
    ImageView mWonderingTeen;
    @BindView(R.id.teen_question)
    TextView mQuestionTeen;
    @BindView(R.id.big_shaq)
    ImageView mBigShaq;
    @BindView(R.id.big_shaq_answer)
    TextView mShaqAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ask_button)
    public void askTeen() {
        mWonderingTeen.setVisibility(View.VISIBLE);
        mQuestionTeen.setVisibility(View.VISIBLE);
        ShaqAsync waitSync = new ShaqAsync();
        waitSync.execute();
    }

    @OnClick(R.id.save_button)
    public void reset() {
        mWonderingTeen.setVisibility(View.GONE);
        mQuestionTeen.setVisibility(View.GONE);
        mBigShaq.setVisibility(View.GONE);
        mShaqAnswer.setVisibility(View.GONE);
    }

    public void askBigShaq() {
        mBigShaq.setVisibility(View.VISIBLE);
        mShaqAnswer.setVisibility(View.VISIBLE);
    }

    public class ShaqAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            askBigShaq();
        }
    }
}