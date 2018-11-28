package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.threeten.bp.Instant;

public class UserAccount extends AppCompatActivity {
    Button createCharButton = null, userAccountSaveButton = null, userAccountExitGameButton = null;
    private DatabaseReference mDatabase;

    String currentUserUID = "";
    String accountName = "";
    String saveDateTime = "";
    String userLevel = "";
    String userEXP = "";
    String userGold = "";
    String userChar = "";
    String charWeapon = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        createCharButton = findViewById(R.id.createCharButton);
        userAccountSaveButton = findViewById(R.id.userAccountSaveButton);
        userAccountExitGameButton = findViewById(R.id.userAccountExitGameButton);

        createCharButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CreateCharacter.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);

            }
        });

        userAccountSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Save to DB

                // Write a message to the database
                //FirebaseDatabase database = FirebaseDatabase.getInstance();
                //DatabaseReference myRef = database.getReference("message");

                //myRef.setValue("Hello, World!");

                currentUserUID = Singleton.getInstance().getUserUID();
                accountName = Singleton.getInstance().getAccountName();
                saveDateTime = Instant.now().toString();
                userLevel = Singleton.getInstance().getUserLevel();
                userEXP = Singleton.getInstance().getUserEXP();
                userGold = Singleton.getInstance().getUserGold();
                userChar = Singleton.getInstance().getCharName();
                charWeapon = Singleton.getInstance().getCharWeaponName();

                mDatabase.child("users").child(currentUserUID).setValue(null);
                mDatabase.child("users").child(currentUserUID).child("accountName").setValue(accountName);
                mDatabase.child("users").child(currentUserUID).child("saveDateTime").setValue(saveDateTime);
                mDatabase.child("users").child(currentUserUID).child("userLevel").setValue(userLevel);
                mDatabase.child("users").child(currentUserUID).child("userEXP").setValue(userEXP);
                mDatabase.child("users").child(currentUserUID).child("userGold").setValue(userGold);
                mDatabase.child("users").child(currentUserUID).child("userChar").setValue(userChar);
                mDatabase.child("users").child(currentUserUID).child("charWeapon").setValue(charWeapon);

            }
        });

        userAccountExitGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
