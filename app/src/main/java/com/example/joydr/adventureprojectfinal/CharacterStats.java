package com.example.joydr.adventureprojectfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CharacterStats extends AppCompatActivity {
    TextView charName_CharStats, charLevel_CharStats,charCurrentEXP_CharStats,charEXPToNextLevel_CharStats, STR_CharStats,
            INTELL_CharStats,DEX_CharStats, attack_CharStats, health_CharStats,intell_CharStats, magic_CharStats, speed_CharStats,dodge_CharStats;
    Button addAttackButton_CharStats, addHealthButton_CharStats, addIntellButton_CharStats,addMagicButton_CharStats,
            addSpeedButton_CharStats,addDodgeButton_CharStats;

    private int levelCounter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats);
        charName_CharStats = findViewById(R.id.charName_CharStats);
        charLevel_CharStats = findViewById(R.id.charLevel_CharStats);
        charCurrentEXP_CharStats = findViewById(R.id.charCurrentEXP_CharStats);
        charEXPToNextLevel_CharStats = findViewById(R.id.charEXPToNextLevel_CharStats);

        STR_CharStats = findViewById(R.id.STR_CharStats);
        INTELL_CharStats = findViewById(R.id.INTELL_CharStats);
        DEX_CharStats = findViewById(R.id.DEX_CharStats);

        attack_CharStats = findViewById(R.id.attack_CharStats);
        health_CharStats = findViewById(R.id.health_CharStats);

        intell_CharStats = findViewById(R.id.intell_CharStats);
        magic_CharStats = findViewById(R.id.magic_CharStats);

        speed_CharStats = findViewById(R.id.speed_CharStats);
        dodge_CharStats = findViewById(R.id.dodge_CharStats);

        addAttackButton_CharStats = findViewById(R.id.addAttackButton_CharStats);
        addHealthButton_CharStats = findViewById(R.id.addHealthButton_CharStats);

        addIntellButton_CharStats = findViewById(R.id.addIntellButton_CharStats);
        addMagicButton_CharStats = findViewById(R.id.addMagicButton_CharStats);

        addSpeedButton_CharStats = findViewById(R.id.addSpeedButton_CharStats);
        addDodgeButton_CharStats = findViewById(R.id.addDodgeButton_CharStats);
        //charName_CharStats = findViewById(R.id.charName_CharStats);

        charName_CharStats.setText(Singleton.getInstance().getCharName());
        charLevel_CharStats.setText("Level: " + Singleton.getInstance().getCharLevel());
        charCurrentEXP_CharStats.setText("Current Exp:" + Singleton.getInstance().getCharCurrentEXP());
        charEXPToNextLevel_CharStats.setText("EXP TNL: " +Singleton.getInstance().getCharEXPToNextLevel());

        STR_CharStats.setText("STR: " +Singleton.getInstance().getSTRPoint());
        INTELL_CharStats.setText("INTELL: " + Singleton.getInstance().getINTELLPoint());
        DEX_CharStats.setText("DEX: " +Singleton.getInstance().getDEXPoint());

        attack_CharStats.setText("Attack: " + Singleton.getInstance().getCharAttack());
        health_CharStats.setText("Health: " + Singleton.getInstance().getCharHealth());
        intell_CharStats.setText("Intell: " + Singleton.getInstance().getCharINTELL());
        magic_CharStats.setText("Magic: " + Singleton.getInstance().getCharMagic());
        speed_CharStats.setText("Speed: " + Singleton.getInstance().getCharSpeed());
        dodge_CharStats.setText("Dodge: " + Singleton.getInstance().getCharDodge());

        addAttackButton_CharStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double strPoint = Double.parseDouble(Singleton.getInstance().getSTRPoint());
                if(strPoint >=1){
                    --strPoint;
                    String nSTRPoint = String.valueOf(strPoint);
                    Singleton.getInstance().setSTRPoint(nSTRPoint);
                   String cAttack = Singleton.getInstance().getCharAttack();
                   double nAttack = Double.parseDouble(cAttack);
                   nAttack++;
                   String setAttack = String.valueOf(nAttack);
                    Singleton.getInstance().setCharAttack(setAttack);
                    attack_CharStats.setText("Attack: " + Singleton.getInstance().getCharAttack());

                }

            }
        });
        addHealthButton_CharStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double strPoint = Double.parseDouble(Singleton.getInstance().getSTRPoint());
                if(strPoint >=1){
                    --strPoint;
                    String nSTRPoint = String.valueOf(strPoint);
                    Singleton.getInstance().setSTRPoint(nSTRPoint);
                    String cHealth = Singleton.getInstance().getCharHealth();
                    double nHealth = Double.parseDouble(cHealth);
                    nHealth++;
                    String setHealth = String.valueOf(nHealth);
                    Singleton.getInstance().setCharHealth(setHealth);
                   String baseHP= Singleton.getInstance().getCharBaseHP();
                    double nbaseHP = Double.parseDouble(baseHP);
                    nbaseHP += 5;
                    String setbaseHP = String.valueOf(nbaseHP);
                    Singleton.getInstance().setCharBaseHP(setbaseHP);

                    health_CharStats.setText("HEALTH: " + Singleton.getInstance().getCharHealth());

                }

            }
        });

        addIntellButton_CharStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double intellpoint = Double.parseDouble(Singleton.getInstance().getINTELLPoint());
                if(intellpoint >=1){
                    --intellpoint;
                    String nINTELLPoint = String.valueOf(intellpoint);
                    Singleton.getInstance().setINTELLPoint(nINTELLPoint);
                    String cIntell = Singleton.getInstance().getCharINTELL();
                    double nIntell= Double.parseDouble(cIntell);
                    nIntell++;
                    String setIntell = String.valueOf(nIntell);
                    Singleton.getInstance().setCharINTELL(setIntell);
                    intell_CharStats.setText("INTELL: " + Singleton.getInstance().getCharINTELL());

                }


            }
        });

        addMagicButton_CharStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double intellpoint = Double.parseDouble(Singleton.getInstance().getINTELLPoint());
                if(intellpoint >=1){
                    --intellpoint;
                    String nINTELLPoint = String.valueOf(intellpoint);
                    Singleton.getInstance().setINTELLPoint(nINTELLPoint);
                    String cMagic = Singleton.getInstance().getCharMagic();
                    double nMagic= Double.parseDouble(cMagic);
                    nMagic++;
                    String setMagic = String.valueOf(nMagic);
                    Singleton.getInstance().setCharMagic(setMagic);

                    String baseMP= Singleton.getInstance().getCharBaseMagic();
                    double nbaseMP = Double.parseDouble(baseMP);
                    nbaseMP += 5;
                    String setbaseMP = String.valueOf(nbaseMP);
                    Singleton.getInstance().setCharBaseMagic(setbaseMP);

                    magic_CharStats.setText("Magic: " + Singleton.getInstance().getCharINTELL());

                }

            }
        });

        addSpeedButton_CharStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dexpoint = Double.parseDouble(Singleton.getInstance().getDEXPoint());
                if(dexpoint >=1){
                    --dexpoint;
                    String nDEXPoint = String.valueOf(dexpoint);
                    Singleton.getInstance().setDEXPoint(nDEXPoint);
                    String cSpeed = Singleton.getInstance().getCharSpeed();
                    double nSpeed= Double.parseDouble(cSpeed);
                    nSpeed++;
                    String setSpeed = String.valueOf(nSpeed);
                    Singleton.getInstance().setCharSpeed(setSpeed);

                    speed_CharStats.setText("Speed: " + Singleton.getInstance().getCharSpeed());

                }

            }
        });

        addDodgeButton_CharStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dexpoint = Double.parseDouble(Singleton.getInstance().getDEXPoint());
                if(dexpoint >=1){
                    --dexpoint;
                    String nDEXPoint = String.valueOf(dexpoint);
                    Singleton.getInstance().setDEXPoint(nDEXPoint);
                    String cDodge = Singleton.getInstance().getCharDodge();
                    double nDodge= Double.parseDouble(cDodge);
                    nDodge++;
                    String setDodge = String.valueOf(nDodge);
                    Singleton.getInstance().setCharDodge(setDodge);

                    speed_CharStats.setText("Dodge: " + Singleton.getInstance().getCharDodge());

                }

                }

        });



    }
}
