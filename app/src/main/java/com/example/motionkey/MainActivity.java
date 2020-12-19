package com.example.motionkey;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton startStop = (ToggleButton) findViewById(R.id.buttonStartStop);
        startStop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (!validateInput() || !startServer())
                        startStop.setChecked(false);
                }
                else
                    stopServer();
            }
        });
    }

    private boolean startServer() {
        Toast.makeText(MainActivity.this, "Server started", Toast.LENGTH_SHORT).show();
        return true;
    }

    private boolean stopServer() {
        Toast.makeText(MainActivity.this, "Server stopped", Toast.LENGTH_SHORT).show();
        return true;
    }

    private boolean validateInput() {
        EditText magnitude = (EditText) findViewById(R.id.editTextMagnitude);

        if (magnitude.getText().toString().length() == 0) {
            magnitude.setError( "Magnitude value required" );
            return false;
        }

        return true;
    }

}