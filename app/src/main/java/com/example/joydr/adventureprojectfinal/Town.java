package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.threeten.bp.Instant;

public class Town extends AppCompatActivity {

    TextView currentCharName = null, currentCharLevel = null, currentUserGold = null;
    Button charStatsButton = null, questButton = null, charShopButton = null, arenaButton = null, chemistButton = null, bankButton = null,
            SaveTownButton=null;
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
        setContentView(R.layout.activity_town);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        currentCharName = findViewById(R.id.currentCharName);
        currentCharLevel = findViewById(R.id.currentCharLevel);
        currentUserGold = findViewById(R.id.currentUserGold);

        charStatsButton = findViewById(R.id.charStatsButton);
        questButton = findViewById(R.id.questButton);
        charShopButton = findViewById(R.id.charShopButton);
        arenaButton = findViewById(R.id.arenaButton);
        chemistButton = findViewById(R.id.chemistButton);
        bankButton = findViewById(R.id.bankButton);
        SaveTownButton= findViewById(R.id.SaveTownButton);


        String level = "Level: ", gold = "Gold: ";
        currentCharName.setText(Singleton.getInstance().getCharName());
        currentCharLevel.setText("Level: " +  Singleton.getInstance().getCharLevel());
        currentUserGold.setText( "Gold: " + Singleton.getInstance().getUserGold());

        charStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CharacterStats
                Intent intent = new Intent(v.getContext(), CharacterStats.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });

        questButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setCharName(currentCharName.getText().toString());

                Intent intent = new Intent(v.getContext(), RegionPicker.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });

        charShopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //#TODO Go to shop
                Singleton.getInstance().setCharName(currentCharName.getText().toString());

                Intent intent = new Intent(v.getContext(), Shop.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });

        arenaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setCharName(currentCharName.getText().toString());

                Intent intent = new Intent(v.getContext(), GameLobby.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
        chemistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setCharName(currentCharName.getText().toString());
                //Chemist
                Intent intent = new Intent(v.getContext(), Chemist.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
        bankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setCharName(currentCharName.getText().toString());
                // #TODO go to anerna Game Lobby
                Intent intent = new Intent(v.getContext(), Bank.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });

        SaveTownButton.setOnClickListener(new View.OnClickListener() {
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
    }


    @Override
    protected void  onResume() {
        super.onResume();
        currentCharName.setText(Singleton.getInstance().getCharName());
        currentCharLevel.setText("Level: " +  Singleton.getInstance().getCharLevel());
        currentUserGold.setText( "Gold: " + Singleton.getInstance().getUserGold());

    }
}
