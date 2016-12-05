package com.domain.some.rps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EnterInfo extends AppCompatActivity {

    Button button1;
    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

        userName = (EditText)findViewById(R.id.txtName);

        button1 = (Button) findViewById(R.id.btnStart);
        button1.setOnClickListener(bstart);

    }

    Button.OnClickListener bstart = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AndroidTutorialApp.userName = userName.getText().toString();
            startActivity(new Intent(EnterInfo.this, ChoiceOfDestiny.class));
        }
    };
}
