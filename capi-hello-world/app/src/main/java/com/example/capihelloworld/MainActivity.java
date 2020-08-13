package com.example.capihelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // Used to load the 'MainActivityJNI' library on application startup.
    static {
        System.loadLibrary("MainActivityJNI");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        initVsomeip();

        startService(new Intent(this, ServiceCommonApiSrv.class));
        startService(new Intent(this, ServiceCommonApiClt.class));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    private void initVsomeip() {
        File vsomeipBaseDir = new File(getCacheDir(), "vsomeip");
        vsomeipBaseDir.mkdir();

        try {
            Os.setenv("VSOMEIP_BASE_PATH", vsomeipBaseDir.getAbsolutePath() + "/", true);
        } catch (ErrnoException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "vsomeipBaseDir: " + vsomeipBaseDir.getAbsolutePath());
        Log.d(TAG, "Os.getenv(\"VSOMEIP_BASE_PATH\"): " + Os.getenv("VSOMEIP_BASE_PATH"));
    }
}
