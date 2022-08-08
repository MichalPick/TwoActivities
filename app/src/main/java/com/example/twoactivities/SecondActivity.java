package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    //define the key for the Intent extra
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);

        //Get the Intent that activated this Activity
        Intent intent = getIntent();
        //Get the string containing the message from the Intent extras
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //get a reference to the TextView for the message from the layout
        TextView textView = findViewById(R.id.text_message);
        //update TextView with the string from the Intent
        textView.setText(message);
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();

        //create new intent for the response
        Intent replyIntent = new Intent();
        //add data to the intent
        replyIntent.putExtra(EXTRA_REPLY, reply);
        //to indicate that the response was successful use the activity code
        setResult(RESULT_OK,replyIntent);
        // close the Activity and return to MainActivity
        finish();
    }
}