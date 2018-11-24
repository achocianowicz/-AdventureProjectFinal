package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView accountNameText = null, passwordText = null;
    Button loginButton = null;

    private String accountName =null, password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountNameText = findViewById(R.id.accountNameText);
        passwordText = findViewById(R.id.passwordText);

        loginButton = findViewById(R.id.loginButton);

        accountNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                accountName = accountNameText.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passwordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = passwordText.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(accountName.equals(Singleton.getInstance().getAccountName()) && password.equals( Singleton.getInstance().getPassword())){
                    Intent intent = new Intent(v.getContext(), UserAccount.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    v.getContext().startActivity(intent);

                }

                else {
                    loginButton.setText(" Try Again!");

                }
            }
        });


    }
}
