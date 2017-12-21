package com.example.casob.phonesnothot;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.hardware.Sensor.TYPE_LIGHT;
import static android.hardware.Sensor.TYPE_PRESSURE;
import static android.hardware.Sensor.TYPE_RELATIVE_HUMIDITY;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "Light";
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
    @BindView(R.id.temperature)
    TextView mTemperature;

    private MediaPlayer ShaqSound = new MediaPlayer();

    private SensorManager mSensorManager;
    Sensor mLight;
    Sensor mPressure;
    Sensor mHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(TYPE_LIGHT);
        mPressure = mSensorManager.getDefaultSensor(TYPE_PRESSURE);
        mHumidity = mSensorManager.getDefaultSensor(TYPE_RELATIVE_HUMIDITY);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mHumidity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @OnClick(R.id.ask_button)
    public void askTeen() {
        mWonderingTeen.setVisibility(View.VISIBLE);
        mQuestionTeen.setVisibility(View.VISIBLE);
        WaitAsync waitSync = new WaitAsync();
        waitSync.execute();

    }

    public void askBigShaq() {
        mBigShaq.setVisibility(View.VISIBLE);
        mShaqAnswer.setVisibility(View.VISIBLE);
        getRandomSound();
        ShaqSound.start();
    }

    private void getRandomSound() {
        Random random = new Random();
        int randomInt = random.nextInt(9 - 1 + 1) + 1;

        switch (randomInt) {
            case 1:
                ShaqSound = MediaPlayer.create(this, R.raw.mans_never_be_hot);
                break;
            case 2:
                ShaqSound = MediaPlayer.create(this, R.raw.boom);
                break;
            case 3:
                ShaqSound = MediaPlayer.create(this, R.raw.no_ketchup);
                break;
            case 4:
                ShaqSound = MediaPlayer.create(this, R.raw.raw_sauce);
                break;
            case 5:
                ShaqSound = MediaPlayer.create(this, R.raw.smoke_trees);
                break;
            case 6:
                ShaqSound = MediaPlayer.create(this, R.raw.the_ting_goes_skraa);
                break;
            case 7:
                ShaqSound = MediaPlayer.create(this, R.raw.two_plus_two);
                break;
            case 8:
                ShaqSound = MediaPlayer.create(this, R.raw.yo);
                break;
            case 9:
                ShaqSound = MediaPlayer.create(this, R.raw.you_done_now);
                break;
        }
    }

    @OnClick(R.id.save_button)
    public void reset() {
        mWonderingTeen.setVisibility(View.GONE);
        mQuestionTeen.setVisibility(View.GONE);
        mBigShaq.setVisibility(View.GONE);
        mShaqAnswer.setVisibility(View.GONE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        int mSensor = sensor.getType();
        switch (mSensor) {
            case TYPE_LIGHT:
                int light = (int) event.values[0];
                Log.i(TAG, "Het amount of light is" + light);
                String string = String.valueOf(light);
                mTemperature.setText(string);
                mTemperature.setVisibility(View.VISIBLE);
            case TYPE_PRESSURE:
                //placeholder
            case TYPE_RELATIVE_HUMIDITY:
                //placeholder
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public class WaitAsync extends AsyncTask<Void, Void, Void> {

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
