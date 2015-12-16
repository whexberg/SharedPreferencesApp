package com.whexberg.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.whexberg.sharedpreferencesapp.preferences";
    private static final String KEY_EDITTEXT = "KEY_EDITTEXT";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPreferences;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mSharedPreferences = getSharedPreferences( PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        String editTextString = mSharedPreferences.getString( KEY_EDITTEXT, "");
        mEditText.setText( editTextString );
     }

    @Override
    protected void onPause() {
        super.onPause();

        mEditor.putString(KEY_EDITTEXT, mEditText.getText().toString() );
        mEditor.apply();
    }
}
