package com.example.joydr.adventureprojectfinal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity
{
    TextView accountNameText = null, passwordText = null;
    Button loginButton = null;
    private String accountName = null, password = null;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser = null;
    String currentUserUID = null;
    Context packageContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        accountNameText = findViewById(R.id.accountNameText);
        passwordText = findViewById(R.id.passwordText);
        loginButton = findViewById(R.id.loginButton);

        accountNameText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                accountName = accountNameText.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        passwordText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                password = passwordText.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                packageContext = v.getContext();
                startSignIn();

                /*
                if(accountName.equals(Singleton.getInstance().getAccountName()) && password.equals( Singleton.getInstance().getPassword()))
                {
                    Intent intent = new Intent(v.getContext(), UserAccount.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    v.getContext().startActivity(intent);
                }
                else
                {
                    loginButton.setText(" Try Again!");
                }
                */
            }
        });
    }

    @Override
    public void onStart()
    {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void startSignIn()
    {
        mAuth.signInWithEmailAndPassword(accountName, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    //updateUI(user);

                    Singleton.getInstance().setAccountName(accountName);
                    Singleton.getInstance().setPassword(password);

                    if (currentUser != null)
                    {
                        currentUserUID = currentUser.getUid();
                        Singleton.getInstance().setUserUID(currentUserUID);
                    }

                    Intent intent = new Intent(packageContext, UserAccount.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    packageContext.startActivity(intent);
                }
                else
                {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "signInWithEmail:failure", task.getException());
                    //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                    //Toast.LENGTH_SHORT).show();
                    //updateUI(null);
                    loginButton.setText(" Try Again!");
                }
                // ...
            }
        });
    }
}
