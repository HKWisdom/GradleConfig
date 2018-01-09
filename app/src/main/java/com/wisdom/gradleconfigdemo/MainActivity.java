package com.wisdom.gradleconfigdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wisdom.gradleconfigdemo.readassets.control.LoadConfigData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadConfigData.load(this);
    }
}
