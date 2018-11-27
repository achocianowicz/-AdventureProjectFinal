package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Town extends AppCompatActivity {

    TextView currentCharName = null, currentCharLevel = null, currentUserGold = null;
    Button charStatsButton = null, questButton = null, charShopButton = null, arenaButton = null, chemistButton = null, bankButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town);

        currentCharName = findViewById(R.id.currentCharName);
        currentCharLevel = findViewById(R.id.currentCharLevel);
        currentUserGold = findViewById(R.id.currentUserGold);

        charStatsButton = findViewById(R.id.charStatsButton);
        questButton = findViewById(R.id.questButton);
        charShopButton = findViewById(R.id.charShopButton);
        arenaButton = findViewById(R.id.arenaButton);
        chemistButton = findViewById(R.id.chemistButton);
        bankButton = findViewById(R.id.bankButton);

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

                Intent intent = new Intent(v.getContext(), Arena.class);
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
    }


    @Override
    protected void  onResume() {
        super.onResume();
        currentCharName.setText(Singleton.getInstance().getCharName());
        currentCharLevel.setText("Level: " +  Singleton.getInstance().getCharLevel());
        currentUserGold.setText( "Gold: " + Singleton.getInstance().getUserGold());

    }
}
