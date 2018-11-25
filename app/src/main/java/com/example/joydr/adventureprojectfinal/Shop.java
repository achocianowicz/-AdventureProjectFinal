package com.example.joydr.adventureprojectfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Shop extends AppCompatActivity {
TextView weapon1Text, weapon2Text, weapon3Text,
    costWeapon1Text,costWeapon2Text,costWeapon3Text, costHPText, costMPText, showUsersGold, boughtText;

    ImageView weaponImage1,weaponImage2,weaponImage3;

Button buyWeapon1, buyWeapon2, buyWeapon3, buyHPButton, buyMPButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        weapon1Text = findViewById(R.id.weapon1Text);
        weapon2Text = findViewById(R.id.weapon2Text);
        weapon3Text = findViewById(R.id.weapon3Text);

        costWeapon1Text = findViewById(R.id.costWeapon1Text);
        costWeapon2Text = findViewById(R.id.costWeapon2Text);
        costWeapon3Text = findViewById(R.id.costWeapon3Text);

        costHPText = findViewById(R.id.costHPText);
        costMPText = findViewById(R.id.costMPText);

        showUsersGold = findViewById(R.id.showUsersGold);
        boughtText = findViewById(R.id.boughtText);

        weaponImage1 = findViewById(R.id.weaponImage1);
        weaponImage2 = findViewById(R.id.weaponImage2);
        weaponImage3 = findViewById(R.id.weaponImage3);

        buyWeapon1 = findViewById(R.id.buyWeapon1);
        buyWeapon2 = findViewById(R.id.buyWeapon2);
        buyWeapon3 = findViewById(R.id.buyWeapon3);

        buyHPButton = findViewById(R.id.buyHPButton);
        buyMPButton = findViewById(R.id.buyMPButton);

        // Set Items
        boughtText.setText("Nothing Bought!");
        weapon1Text.setText(Singleton.getInstance().getWeapon1Name());
        weaponImage1.setBackgroundResource(R.drawable.sword);
        costWeapon1Text.setText(Singleton.getInstance().getWeapon1Cost());

        weapon2Text.setText(Singleton.getInstance().getWeapon2Name());
        weaponImage2.setBackgroundResource(R.drawable.axe);
        costWeapon2Text.setText(Singleton.getInstance().getWeapon2Cost());

        weapon3Text.setText(Singleton.getInstance().getWeapon3Name());
        weaponImage3.setBackgroundResource(R.drawable.spear);
        costWeapon3Text.setText(Singleton.getInstance().getWeapon3Cost());



        // see if user has enough gold to buy items
        CheckGold();


        buyWeapon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cW1 = Integer.parseInt(costWeapon1Text.getText().toString().trim());
                int uCG = Integer.parseInt(Singleton.getInstance().getUserGold());
                uCG -=   cW1 ;
                String nUG = String.valueOf(uCG);
                Singleton.getInstance().setUserGold(nUG);
                showUsersGold.setText(Singleton.getInstance().getUserGold());
                Singleton.getInstance().setCharWeaponName(weapon1Text.getText().toString().trim());
                Singleton.getInstance().setCharWeaponAttack(Singleton.getInstance().getWeapon1Attack());
                Singleton.getInstance().setCharWeaponSpeed(Singleton.getInstance().getWeapon1Speed());
                CheckGold();
                boughtText.setText("Bought:" + weapon1Text.getText().toString().trim() + " !");


            }
        });

        buyWeapon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cW2 = Integer.parseInt(costWeapon2Text.getText().toString().trim());
                int uCG = Integer.parseInt(Singleton.getInstance().getUserGold());
                uCG -=   cW2 ;
                String nUG = String.valueOf(uCG);
                Singleton.getInstance().setUserGold(nUG);
                showUsersGold.setText(Singleton.getInstance().getUserGold());
                Singleton.getInstance().setCharWeaponName(weapon2Text.getText().toString().trim());
                Singleton.getInstance().setCharWeaponAttack(Singleton.getInstance().getWeapon2Attack());
                Singleton.getInstance().setCharWeaponSpeed(Singleton.getInstance().getWeapon2Speed());
                CheckGold();
                boughtText.setText("Bought:" + weapon2Text.getText().toString().trim() + " !");


            }
        });

        buyWeapon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cW3 = Integer.parseInt(costWeapon3Text.getText().toString().trim());
                int uCG = Integer.parseInt(Singleton.getInstance().getUserGold());
                uCG -=   cW3 ;
                String nUG = String.valueOf(uCG);
                Singleton.getInstance().setUserGold(nUG);
                showUsersGold.setText(Singleton.getInstance().getUserGold());
                Singleton.getInstance().setCharWeaponName(weapon3Text.getText().toString().trim());
                Singleton.getInstance().setCharWeaponAttack(Singleton.getInstance().getWeapon3Attack());
                Singleton.getInstance().setCharWeaponSpeed(Singleton.getInstance().getWeapon3Speed());
                CheckGold();
                boughtText.setText("Bought:" + weapon3Text.getText().toString().trim() + " !");


            }
        });
        buyHPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cHP = Integer.parseInt(costHPText.getText().toString().trim());
                int uCG = Integer.parseInt(Singleton.getInstance().getUserGold());
                uCG -=   cHP ;
                String nUG = String.valueOf(uCG);
                Singleton.getInstance().setUserGold(nUG);
                showUsersGold.setText(Singleton.getInstance().getUserGold());
                int stackOfHP = Integer.parseInt(Singleton.getInstance().getHpCount());
                stackOfHP++;
                String setNewStackOfHP = String.valueOf(stackOfHP);
                Singleton.getInstance().setHpCount(setNewStackOfHP);
                CheckGold();
                boughtText.setText("Bought: Health Potion !");


            }
        });
        buyMPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cMP = Integer.parseInt(costMPText.getText().toString().trim());
                int uCG = Integer.parseInt(Singleton.getInstance().getUserGold());
                uCG -=   cMP ;
                String nUG = String.valueOf(uCG);
                Singleton.getInstance().setUserGold(nUG);
                showUsersGold.setText(Singleton.getInstance().getUserGold());
                int stackOfMP = Integer.parseInt(Singleton.getInstance().getMpCount());
                stackOfMP++;
                String setNewStackOfMP = String.valueOf(stackOfMP);
                Singleton.getInstance().setMpCount(setNewStackOfMP);
                CheckGold();
                boughtText.setText("Bought: Magic Potion !");


            }
        });

    }

   public void CheckGold() {
       int cW1 = Integer.parseInt(costWeapon1Text.getText().toString().trim());
       int cW2 = Integer.parseInt(costWeapon2Text.getText().toString().trim());
       int cW3 = Integer.parseInt(costWeapon3Text.getText().toString().trim());
       int cHP = Integer.parseInt(costHPText.getText().toString().trim());
       int cMP = Integer.parseInt(costMPText.getText().toString().trim());
       int uCG = Integer.parseInt(Singleton.getInstance().getUserGold());

       if(cW1 > uCG){
           buyWeapon1.setVisibility(View.INVISIBLE);
       }
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

       showUsersGold.setText(Singleton.getInstance().getUserGold());

   }
}
