package com.xkeshi.yunplugintest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xkeshi.yunplugin.activity.RemoteActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RemoteActivity.class);
                intent.putExtra("dexPath", getDir("odex", Context.MODE_PRIVATE).getAbsolutePath() + File.separator
                        + "temp.apk");
                intent.putExtra("theme", R.style.AppTheme);
                startActivity(intent);
            }
        });
    }
}
