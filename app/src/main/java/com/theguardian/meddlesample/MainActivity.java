package com.theguardian.meddlesample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.theguardian.meddle.Form;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private LoginForm loginForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Create new LoginForm");
        loginForm = new LoginForm();
        loginForm.bindViews(findViewById(R.id.email), findViewById(R.id.password), findViewById(R.id.remember_me));
        loginForm.addValidityListener(new Form.FormValidityListener() {
            @Override
            public void onValidityChanged(@NonNull Form form, boolean valid) {
                final String message = valid ? "Form is now valid" : "Form is now invalid";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginForm = null;
    }

    public void onLoginClick(View view) {
        if (loginForm.validate()) {
            // Do login...
            Toast.makeText(this, R.string.logging_in, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
