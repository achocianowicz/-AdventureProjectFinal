package com.example.joydr.adventureprojectfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Chemist extends AppCompatActivity {
TextView spell1Name_Chemist = null, spell1Cost_Chemist = null, showUsersGold_Chemist = null, boughtText_Chemist = null;

ImageView spell1Image_Chemist = null;

Button spell1Buy_Chemist =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemist);

        spell1Name_Chemist = findViewById(R.id.spell1Name_Chemist);
        spell1Cost_Chemist = findViewById(R.id.spell1Cost_Chemist);

        showUsersGold_Chemist = findViewById(R.id.showUsersGold_Chemist);
        boughtText_Chemist = findViewById(R.id.boughtText_Chemist);

        spell1Image_Chemist = findViewById(R.id.spell1Image_Chemist);
        spell1Buy_Chemist = findViewById(R.id.spell1Buy_Chemist);

        spell1Name_Chemist.setText(Singleton.getInstance().fireball.getName());
        spell1Cost_Chemist.setText(String.valueOf(Singleton.getInstance().fireball.getCost()));

        showUsersGold_Chemist.setText(Singleton.getInstance().getUserGold());
        boughtText_Chemist.setText("Bought Nothing Yet!");
        spell1Image_Chemist.setBackgroundResource(R.drawable.fireball);

        spell1Buy_Chemist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cW1 = Integer.parseInt(spell1Cost_Chemist.getText().toString().trim());
                int uCG = Integer.parseInt(Singleton.getInstance().getUserGold());
                uCG -=   cW1 ;
                String nUG = String.valueOf(uCG);
                Singleton.getInstance().setUserGold(nUG);
                showUsersGold_Chemist.setText(Singleton.getInstance().getUserGold());
                Singleton.getInstance().setCharSpellName(spell1Name_Chemist.getText().toString().trim());
                Singleton.getInstance().setCharSpell1(Singleton.getInstance().fireball);
                spell1Buy_Chemist.setVisibility(View.INVISIBLE);

                CheckGold();
                boughtText_Chemist.setText("Bought:" + spell1Name_Chemist.getText().toString().trim() + " !");
            }
        });

    }

    public void CheckGold() {
        int cS1 = Integer.parseInt(spell1Cost_Chemist.getText().toString().trim());
        int uCG = Integer.parseInt(Singleton.getInstance().getUserGold());
        /*
        int cW2 = Integer.parseInt(costWeapon2Text.getText().toString().trim());
        int cW3 = Integer.parseInt(costWeapon3Text.getText().toString().trim());
        int cHP = Integer.parseInt(costHPText.getText().toString().trim());
        int cMP = Integer.parseInt(costMPText.getText().toString().trim());
        int uCG = Integer.parseInt(Singleton.getInstance().getUserGold());
*/
        if(cS1 > uCG){
            spell1Buy_Chemist.setVisibility(View.INVISIBLE);
        }
        /*
        if(cW2 > uCG){
            buyWeapon2.setVisibility(View.INVISIBLE);
        }
        if(cW3 > uCG){
            buyWeapon3.setVisibility(View.INVISIBLE);
        }
        if(cHP > uCG){
            buyHPButton.setVisibility(View.INVISIBLE);
        }
        if(cMP > uCG){
            buyMPButton.setVisibility(View.INVISIBLE);
        }
*/
        showUsersGold_Chemist.setText(Singleton.getInstance().getUserGold());

    }
}
