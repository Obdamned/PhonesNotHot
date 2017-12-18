package com.example.casob.phonesnothot;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

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
    MediaPlayer ShaqSound = new MediaPlayer();

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
        WaitAsync waitSync = new WaitAsync();
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
        getRandomSound(ShaqSound);
        ShaqSound.start();
    }

    private MediaPlayer getRandomSound(MediaPlayer shaqSound) {
        Random random = new Random();
        int randomInt = random.nextInt(10 - 1 + 1) + 1;
        MediaPlayer ShaqSound = shaqSound;

        switch (randomInt) {
            case 1:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
            case 2:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
            case 3:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
            case 4:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
            case 5:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
            case 6:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
            case 7:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
            case 8:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
            case 9:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
        }
        return ShaqSound;
    }

    public class WaitAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(2000);
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