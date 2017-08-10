package com.dmariani.kotlinapp.ui.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dmariani.kotlinapp.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.edit_text_user_name);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowPictureButton();
            }
        });
    }

    private void onClickShowPictureButton() {
        String name = nameEditText.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Snackbar.make(button, R.string.user_error_message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.button_skip, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // TODO Show Picture
                        }
                    }).show();
        }

        // TODO Show Picture
    }
}
