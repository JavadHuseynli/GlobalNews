
package com.example.javad.globalnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button register;
    EditText username, password, passwordConf;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        db = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.reg_email);
        password = (EditText)findViewById(R.id.reg_pass);
        passwordConf = (EditText)findViewById(R.id.reg_passConfRegis);
        register = (Button)findViewById(R.id.reg_btn);
        back = findViewById(R.id.reg_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strPasswordConf = passwordConf.getText().toString();
                if (strPassword.equals(strPasswordConf)) {
                    Boolean siyahi = db.insertUser(strUsername, strPassword);
                    if (siyahi == true) {
                        Toast.makeText(getApplicationContext(), "Ugurlu alindi emeliyyat", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(RegisActivity.this, LoginActivity.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "\n" +
                                "Siyahı alınmadı", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "\n" +
                            "Şifrələr uyğun gəlmir", Toast.LENGTH_SHORT).show();
                }
            }
        }); }
}
