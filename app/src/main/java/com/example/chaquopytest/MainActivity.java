package com.example.chaquopytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    TextView twentyeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twentyeight = (TextView)findViewById(R.id.twentyeight);

        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        //this will start Python

        //now Create Python Instance
        Python py = Python.getInstance();
        //now create python object
        PyObject pyObj = py.getModule("script");
        //calls main function
        PyObject obj = pyObj.callAttr("doMusic");
        //display information
        twentyeight.setText(obj.toString());

    }
}