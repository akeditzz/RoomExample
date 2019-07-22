package com.amshotzz.roomexample;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.amshotzz.roomexample.databinding.ActivityNewWordBinding;

public class NewWordActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.amshotzz.roomexample.REPLY";

    private ActivityNewWordBinding newWordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newWordBinding = DataBindingUtil.setContentView(this,R.layout.activity_new_word);
        newWordBinding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(newWordBinding.editWord.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = newWordBinding.editWord.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
