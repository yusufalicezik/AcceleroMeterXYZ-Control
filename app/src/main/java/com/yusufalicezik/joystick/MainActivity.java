package com.yusufalicezik.joystick;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        if (Math.abs(x) > Math.abs(y)) {
            if (x < -3) {
               Log.e("Yusufali","Sağa döndün");
            }
            if (x > 3) {
                Log.e("Yusufali","Sola döndün döndün");

            }
        } else {
            if (y < -3) {
                Log.e("Yusufali","Yukarıdasın");

            }
            if (y > 3) {
                Log.e("Yusufali","Aşağıdasın");

            }
        }
        if (x > (-2) && x < (2) && y > (-2) && y < (2)) {
            Log.e("Yusufali","İşlem yok");

        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }

}
