package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Town extends AppCompatActivity {

    TextView currentCharName = null, currentCharLevel = null, currentUserGold = null;
    Button charStatsButton = null, questButton = null, charShopButton = null, anernaButton = null;

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
        anernaButton = findViewById(R.id.arenaButton);

            String level = "Level: ", gold = "Gold: ";
        currentCharName.setText(Singleton.getInstance().getCharName());
        currentCharLevel.setText(level +  Singleton.getInstance().getCharLevel());
        currentUserGold.setText( "Gold: " + Singleton.getInstance().getUserGold());

        charStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // use EXp to upgrade char
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

                Intent intent = new Intent(v.getContext(), RegionPicker.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });

        anernaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setCharName(currentCharName.getText().toString());
                // #TODO go to anerna Game Lobby
                Intent intent = new Intent(v.getContext(), RegionPicker.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
    }
}
