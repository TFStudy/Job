package com.ztf.usercenter.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.ztf.usercenter.R;

public class LoginMainActivity extends AppCompatActivity {

    private TextView toreg;
    private Button tologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        toreg = (TextView) findViewById(R.id.toreg);
        tologin = (Button) findViewById(R.id.tologin);
        toreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginMainActivity.this, RegisterActivity.class));
            }
        });
        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginMainActivity.this,LoginActivity.class));
            }
        });
    }
}
