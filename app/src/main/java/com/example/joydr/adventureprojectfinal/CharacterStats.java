package com.example.joydr.adventureprojectfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CharacterStats extends AppCompatActivity {
    TextView charName_CharStats, charLevel_CharStats,charCurrentEXP_CharStats,charEXPToNextLevel_CharStats, STR_CharStats,
            INTELL_CharStats,DEX_CharStats, attack_CharStats, health_CharStats,intell_CharStats, magic_CharStats, speed_CharStats,dodge_CharStats,

    currentWeapon_CharStats,currentWeaponAttack1Name_CharStats, currentWeaponAttack1Damage_CharStats, currentWeaponAttack1Speed_CharStats,
            currentWeaponAttack2Name_CharStats, currentWeaponAttack2Damage_CharStats, currentWeaponAttack2Speed_CharStats,
    charSpell1Name_CharStats, charSpell1Damage_CharStats, charSpell1Speed_CharStats,
    hpCount_CharStats, mpCount_CharStats;

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

      //  currentWeapon_CharStats, currentWeaponName_CharStats, currentWeaponAttack_CharStats, currentWeaponSpeed_CharStats
        currentWeapon_CharStats = findViewById(R.id.currentWeapon_CharStats);
        currentWeaponAttack1Name_CharStats = findViewById(R.id.currentWeaponAttack1Name_CharStats);
        currentWeaponAttack1Damage_CharStats = findViewById(R.id.currentWeaponAttack1Damage_CharStats);
        currentWeaponAttack1Speed_CharStats = findViewById(R.id.currentWeaponAttack1Speed_CharStats);
        currentWeaponAttack2Name_CharStats = findViewById(R.id.currentWeaponAttack2Name_CharStats);
        currentWeaponAttack2Damage_CharStats = findViewById(R.id.currentWeaponAttack2Damage_CharStats);
        currentWeaponAttack2Speed_CharStats = findViewById(R.id.currentWeaponAttack2Speed_CharStats);
// Spell

        charSpell1Name_CharStats = findViewById(R.id.charSpell1Name_CharStats);
        charSpell1Damage_CharStats = findViewById(R.id.charSpell1Damage_CharStats);
        charSpell1Speed_CharStats = findViewById(R.id.charSpell1Speed_CharStats);

        hpCount_CharStats = findViewById(R.id.hpCount_CharStats);
        mpCount_CharStats = findViewById(R.id.mpCount_CharStats);

        charName_CharStats.setText(Singleton.getInstance().getCharName());
        charLevel_CharStats.setText("Level: " + Singleton.getInstance().getCharLevel());
        charCurrentEXP_CharStats.setText("Current Exp:" + Singleton.getInstance().getCharCurrentEXP());
        charEXPToNextLevel_CharStats.setText("EXP TNL: " +Singleton.getInstance().getCharEXPToNextLevel());
//#TODO in singleton
        hpCount_CharStats.setText("Health potion count: " + Singleton.getInstance().getHpCount());
        mpCount_CharStats.setText("Magic potion count: " + Singleton.getInstance().getMpCount());

        STR_CharStats.setText("STR: " +Singleton.getInstance().getSTRPoint());
        INTELL_CharStats.setText("INTELL: " + Singleton.getInstance().getINTELLPoint());
        DEX_CharStats.setText("DEX: " +Singleton.getInstance().getDEXPoint());

        attack_CharStats.setText("Attack: " + Singleton.getInstance().getCharAttack());
        health_CharStats.setText("Health: " + Singleton.getInstance().getCharHealth());
        intell_CharStats.setText("Intell: " + Singleton.getInstance().getCharINTELL());
        magic_CharStats.setText("Magic: " + Singleton.getInstance().getCharMagic());
        speed_CharStats.setText("Speed: " + Singleton.getInstance().getCharSpeed());
        dodge_CharStats.setText("Dodge: " + Singleton.getInstance().getCharDodge());
//weapon
        currentWeapon_CharStats.setText( "Equiped with " + Singleton.getInstance().getCharWeaponName());
        currentWeaponAttack1Name_CharStats.setText( "" + Singleton.getInstance().getCharAttack1().getName());
        currentWeaponAttack1Damage_CharStats.setText( "Damage: " + Singleton.getInstance().getCharAttack1().getDamage());
        currentWeaponAttack1Speed_CharStats.setText( "Speed: " + Singleton.getInstance().getCharAttack1().getSpeed());
        currentWeaponAttack2Name_CharStats.setText( "" + Singleton.getInstance().getCharAttack2().getName());
        currentWeaponAttack2Damage_CharStats.setText( "Damage: " + Singleton.getInstance().getCharAttack2().getDamage());
        currentWeaponAttack2Speed_CharStats.setText( "Speed:" + Singleton.getInstance().getCharAttack2().getSpeed());

        // spell

        charSpell1Name_CharStats.setText(Singleton.getInstance().getCharSpell1().getName());
        charSpell1Damage_CharStats.setText("Damage: " + String.valueOf(Singleton.getInstance().getCharSpell1().getDamage()));
        charSpell1Speed_CharStats.setText("Speed" +String.valueOf(Singleton.getInstance().getCharSpell1().getSpeed()));

        addAttackButton_CharStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int strPoint = Integer.parseInt(Singleton.getInstance().getSTRPoint());
                if(strPoint >=1){
                    --strPoint;
                    String nSTRPoint = String.valueOf(strPoint);
                    Singleton.getInstance().setSTRPoint(nSTRPoint);
                    STR_CharStats.setText("STR: " + Singleton.getInstance().getSTRPoint());
                   String cAttack = Singleton.getInstance().getCharAttack();
                   int nAttack = Integer.parseInt(cAttack);
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
                int strPoint = Integer.parseInt(Singleton.getInstance().getSTRPoint());
                if(strPoint >=1){
                    --strPoint;
                    String nSTRPoint = String.valueOf(strPoint);
                    Singleton.getInstance().setSTRPoint(nSTRPoint);
                    STR_CharStats.setText("STR: " + Singleton.getInstance().getSTRPoint());
                    String cHealth = Singleton.getInstance().getCharHealth();
                    int nHealth = Integer.parseInt(cHealth);
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
                int intellpoint = Integer.parseInt(Singleton.getInstance().getINTELLPoint());
                if(intellpoint >=1){
                    --intellpoint;
                    String nINTELLPoint = String.valueOf(intellpoint);
                    Singleton.getInstance().setINTELLPoint(nINTELLPoint);
                    INTELL_CharStats.setText("INTELL: " +Singleton.getInstance().getINTELLPoint());
                    String cIntell = Singleton.getInstance().getCharINTELL();
                    int nIntell= Integer.parseInt(cIntell);
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
                int intellpoint = Integer.parseInt(Singleton.getInstance().getINTELLPoint());
                if(intellpoint >=1){
                    --intellpoint;
                    String nINTELLPoint = String.valueOf(intellpoint);
                    Singleton.getInstance().setINTELLPoint(nINTELLPoint);
                    String cMagic = Singleton.getInstance().getCharMagic();
                    INTELL_CharStats.setText("INTELL: " + Singleton.getInstance().getINTELLPoint());
                    int nMagic= Integer.parseInt(cMagic);
                    nMagic++;
                    String setMagic = String.valueOf(nMagic);
                    Singleton.getInstance().setCharMagic(setMagic);

                    String baseMP= Singleton.getInstance().getCharBaseMagic();
                    double nbaseMP = Double.parseDouble(baseMP);
                    nbaseMP += 5;
                    String setbaseMP = String.valueOf(nbaseMP);
                    Singleton.getInstance().setCharBaseMagic(setbaseMP);

                    magic_CharStats.setText("Magic: " + Singleton.getInstance().getCharMagic());

                }

            }
        });

        addSpeedButton_CharStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dexpoint = Integer.parseInt(Singleton.getInstance().getDEXPoint());
                if(dexpoint >=1){
                    --dexpoint;
                    String nDEXPoint = String.valueOf(dexpoint);
                    Singleton.getInstance().setDEXPoint(nDEXPoint);
                    DEX_CharStats.setText("DEX : " +Singleton.getInstance().getDEXPoint());
                    String cSpeed = Singleton.getInstance().getCharSpeed();
                    int nSpeed= Integer.parseInt(cSpeed);
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
                int dexpoint = Integer.parseInt(Singleton.getInstance().getDEXPoint());
                if(dexpoint >=1){
                    --dexpoint;
                    String nDEXPoint = String.valueOf(dexpoint);
                    Singleton.getInstance().setDEXPoint(nDEXPoint);
                    DEX_CharStats.setText("Dex" +Singleton.getInstance().getDEXPoint());
                    String cDodge = Singleton.getInstance().getCharDodge();
                    int nDodge= Integer.parseInt(cDodge);
                    nDodge++;
                    String setDodge = String.valueOf(nDodge);
                    Singleton.getInstance().setCharDodge(setDodge);

                    dodge_CharStats.setText("Dodge: " + Singleton.getInstance().getCharDodge());

                }

                }

        });



    }

    @Override
    protected void  onResume() {
        super.onResume();
        currentWeapon_CharStats = findViewById(R.id.currentWeapon_CharStats);

        currentWeapon_CharStats.setText( "Equiped with " + Singleton.getInstance().getCharWeaponName());
        currentWeaponAttack1Name_CharStats.setText( "" + Singleton.getInstance().getCharAttack1().getName());
        currentWeaponAttack1Damage_CharStats.setText( "Damage: " + Singleton.getInstance().getCharAttack1().getDamage());
        currentWeaponAttack1Speed_CharStats.setText( "Speed: " + Singleton.getInstance().getCharAttack1().getSpeed());
        currentWeaponAttack2Name_CharStats.setText( "" + Singleton.getInstance().getCharAttack2().getName());
        currentWeaponAttack2Damage_CharStats.setText( "Damage: " + Singleton.getInstance().getCharAttack2().getDamage());
        currentWeaponAttack2Speed_CharStats.setText( "Speed: " + Singleton.getInstance().getCharAttack2().getSpeed());
        hpCount_CharStats.setText("Health potion count: " + Singleton.getInstance().getHpCount());
        mpCount_CharStats.setText("Magic potion count: " + Singleton.getInstance().getMpCount());

        STR_CharStats.setText("STR: " +Singleton.getInstance().getSTRPoint());
        INTELL_CharStats.setText("INTELL: " + Singleton.getInstance().getINTELLPoint());
        DEX_CharStats.setText("DEX: " +Singleton.getInstance().getDEXPoint());

        attack_CharStats.setText("Attack: " + Singleton.getInstance().getCharAttack());
        health_CharStats.setText("Health: " + Singleton.getInstance().getCharHealth());
        intell_CharStats.setText("Intell: " + Singleton.getInstance().getCharINTELL());
        magic_CharStats.setText("Magic: " + Singleton.getInstance().getCharMagic());
        speed_CharStats.setText("Speed: " + Singleton.getInstance().getCharSpeed());
        dodge_CharStats.setText("Dodge: " + Singleton.getInstance().getCharDodge());

        // spell

        charSpell1Name_CharStats.setText(Singleton.getInstance().getCharSpell1().getName());
        charSpell1Damage_CharStats.setText("Damage: " + String.valueOf(Singleton.getInstance().getCharSpell1().getDamage()));
        charSpell1Speed_CharStats.setText("Speed" +String.valueOf(Singleton.getInstance().getCharSpell1().getSpeed()));

    }
}
