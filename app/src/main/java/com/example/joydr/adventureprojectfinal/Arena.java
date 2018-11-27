package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Arena extends AppCompatActivity {
    TextView f1B1enemyName = null, f1B1enemyLevel = null, f1B1enemyHP = null, f1B1enemyMP = null,
            f1B1charName = null, f1B1charLevel = null, f1B1charHP = null, f1B1charMP= null,
            b1F1battleText = null;

    ImageView f1B1enemyImage = null, f1B1charImage = null;

    Button f1B1hpButton = null,f1B1mpButton = null,
            f1B1charAttack1 = null, f1B1charAttack2 = null, f1B1charSpell1 = null,
            f1B1charFlee = null,
            f1B1toGoToReward = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);





            f1B1enemyName = findViewById(R.id.ArenaenemyName);
            f1B1enemyLevel = findViewById(R.id.ArenaenemyLevel);
            f1B1enemyHP = findViewById(R.id.ArenaenemyHP);
            f1B1enemyMP = findViewById(R.id.f1B1enemyMP);


            f1B1charName = findViewById(R.id.ArenacharName);
            f1B1charLevel = findViewById(R.id.ArenacharLevel);
            f1B1charHP = findViewById(R.id.ArenacharHP);
            f1B1charMP = findViewById(R.id.ArenacharMP);


            f1B1enemyImage = findViewById(R.id.ArenaenemyImage);
            f1B1charImage = findViewById(R.id.ArenacharImage);

            f1B1hpButton = findViewById(R.id.ArenahpButton);
            f1B1mpButton = findViewById(R.id.f1B1mpButton);

            f1B1charAttack1 = findViewById(R.id.ArenacharAttack1);
            f1B1charAttack2 = findViewById(R.id.ArenacharAttack2);
            f1B1charSpell1 = findViewById(R.id.ArenacharSpell1);

            f1B1charFlee = findViewById(R.id.ArenacharFlee);
            f1B1toGoToReward = findViewById(R.id.ArenatoGoToReward);

            b1F1battleText = findViewById(R.id.ArenabattleText);
// Enemy
            f1B1enemyName.setText(Singleton.getInstance().bear1.getEnemyName());
            f1B1enemyLevel.setText("Level: " +Singleton.getInstance().bear1.getBearLevel());
            f1B1enemyHP.setText("HP: " + String.valueOf(Singleton.getInstance().bear1.getEnemyHP()));
            f1B1enemyMP.setText("MP: " + String.valueOf(Singleton.getInstance().bear1.getEnemyMP()));
            // bear attack
            Attack bear1Attack1 = Singleton.getInstance().bear1Attack1;
            Attack bear2Attack2 = Singleton.getInstance().bear1Attack2;
// char
            f1B1charName.setText(Singleton.getInstance().getCharName());
            f1B1charLevel.setText("Level: " +Singleton.getInstance().getCharLevel());
            f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
            f1B1charMP.setText("MP: " +Singleton.getInstance().getCharCurrentMagic());
            //char attack
            Attack charAttack1 = Singleton.getInstance().charAttack1;
            Attack charAttack2 = Singleton.getInstance().charAttack2;

            f1B1toGoToReward.setVisibility(View.INVISIBLE);
            f1B1charAttack1.setText(Singleton.getInstance().getCharAttack1().getName());
            f1B1charAttack2.setText(Singleton.getInstance().getCharAttack2().getName());
            f1B1charSpell1.setText(Singleton.getInstance().getCharSpell1().getName());
            f1B1hpButton.setText(Singleton.getInstance().getHpCount());
            f1B1mpButton.setText(Singleton.getInstance().getMpCount());
            CheckMagic();
            //#TODO set image views

            f1B1hpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int numberOfHP = Integer.parseInt(Singleton.getInstance().getHpCount());

                    if(numberOfHP > 0){
                        int cCHP =  Integer.parseInt(Singleton.getInstance().getCharCurrentHP());
                        cCHP += 25;
                        numberOfHP--;
                        String setHPCount = String.valueOf(numberOfHP);
                        Singleton.getInstance().setHpCount(setHPCount);
                        String setCharHP = String.valueOf(cCHP);
                        Singleton.getInstance().setCharCurrentHP(setCharHP);
                        f1B1hpButton.setText(Singleton.getInstance().getHpCount());
                        f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
                        b1F1battleText.setText(f1B1charName.getText() + " Used a HP to Heal up by: " + setCharHP);

                    }
                    else{
                        b1F1battleText.setText(f1B1charName.getText() + " Has no HP to use!");

                    }

                }
            });
            f1B1mpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int numberOfMP = Integer.parseInt(Singleton.getInstance().getMpCount());

                    if(numberOfMP > 0){
                        int cCMP =  Integer.parseInt(Singleton.getInstance().getCharCurrentMagic());
                        cCMP += 25;
                        String setCharMP = String.valueOf(cCMP);
                        numberOfMP--;
                        String setMPCount = String.valueOf(numberOfMP);
                        Singleton.getInstance().setMpCount(setMPCount);
                        f1B1mpButton.setText(Singleton.getInstance().getMpCount());
                        Singleton.getInstance().setCharCurrentMagic(setCharMP);
                        f1B1charMP.setText("MP: " + Singleton.getInstance().getCharCurrentMagic());
                        b1F1battleText.setText(f1B1charName.getText() + " Used a MP to Power up");
                        CheckMagic();

                    }
                    else {
                        b1F1battleText.setText(f1B1charName.getText() + " Has no MP to use!");

                    }

                }
            });
            f1B1charAttack1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Attack charAttack1 = Singleton.getInstance().charAttack1;
                    Combat( charAttack1);

                }
            });
            f1B1charAttack2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Attack charAttack2 = Singleton.getInstance().charAttack2;
                    Combat( charAttack2);

                }
            });

            f1B1charSpell1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Spell charSpell1 = Singleton.getInstance().charSpell1;
                    int cMagic =  Integer.parseInt(Singleton.getInstance().getCharCurrentMagic());
                    int magicCost = Integer.parseInt(Singleton.getInstance().charSpell1.getMagicCost());
                    if(cMagic >= magicCost) {

                        b1F1battleText.setText(f1B1charName.getText() + " Has used " + f1B1charSpell1.getText().toString() + "!");

                        cMagic -= magicCost;
                        String setNewCurrentMana = String.valueOf(cMagic);
                        Singleton.getInstance().setCharCurrentMagic(setNewCurrentMana);
                        CheckMagic();
                        double cEHP = Singleton.getInstance().getEnemyHP();
                        b1F1battleText.setText(f1B1charName.getText() + " uses " + charSpell1.getName());
                        cEHP -= charSpell1.getDamage();
                        b1F1battleText.setText(charSpell1.getName() + " deals " + charSpell1.getDamage() + "to" + f1B1enemyName.getText());
                        CheckEnemyHealth(cEHP);
                        Singleton.getInstance().setEnemyHP(cEHP);
                        f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());
                    }
                    else{
                        b1F1battleText.setText(charSpell1.getName() + " can't be used, not Enough Maigc. Need " + (magicCost - cMagic)  + "more Magic to Cast: " + charSpell1.getName());

                    }


                }
            });

            f1B1charFlee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // run to town as a loser
                }
            });

            f1B1toGoToReward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), QuestReward.class);

                    //send exp and gold
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    v.getContext().startActivity(intent);

                }
            });

        }

        public void CheckCharHealth(Double cHP){
            if(cHP > 0){

                // char is alive battle
                return;
            }
            else{
                f1B1charImage.setImageResource(R.drawable.dead);
                //Char is dead
            }

        }

        public void CheckEnemyHealth(Double cHP){
            if(cHP > 0){

                // enemy is alive battle
                return;
            }
            else{

                //enemy dead is dead
                Singleton.getInstance().setQuestTitle("Forest1 Bear1 Combat");
                Singleton.getInstance().setExpReward(Singleton.getInstance().getForest1Bear1EXPReward());
                Singleton.getInstance().setGoldReward(Singleton.getInstance().getForest1Bear1GoldReward());
                f1B1enemyImage.setImageResource(R.drawable.win);
                f1B1toGoToReward.setVisibility(View.VISIBLE);
                f1B1charAttack1.setVisibility(View.INVISIBLE);
                f1B1charAttack2.setVisibility(View.INVISIBLE);
                f1B1charSpell1.setVisibility(View.INVISIBLE);
                f1B1hpButton.setVisibility(View.INVISIBLE);
                f1B1mpButton.setVisibility(View.INVISIBLE);

            }

        }

        public void Combat(Attack charAttack) {
            Attack bear1Attack1 = Singleton.getInstance().bear1Attack1;
            Attack bear2Attack2 = Singleton.getInstance().bear1Attack2;

            int random = new Random().nextInt(2) + 1;
            String point = "1";
            switch (random)

            {
                case 1:
                    if(bear1Attack1.getSpeed() > charAttack.getSpeed()) {
                        EnemyAttack(bear1Attack1, charAttack);
                        b1F1battleText.setText(f1B1enemyName.getText() + "Attacks first ");
                    }
                    else if(bear1Attack1.getSpeed() == charAttack.getSpeed()){
                        random = new Random().nextInt(2) + 1;
                        if(random == 1) {
                            EnemyAttack(bear1Attack1, charAttack);
                            b1F1battleText.setText(f1B1enemyName.getText() + "Attacks first ");
                        }
                        else{
                            PlayerAttack( charAttack, bear1Attack1 );
                            b1F1battleText.setText(f1B1charName.getText() + "Attacks first ");
                        }
                    }
                    else{
                        PlayerAttack( charAttack, bear1Attack1 );
                        b1F1battleText.setText(f1B1charName.getText() + "Attacks first ");
                    }
                    break;

                case 2:

                    if(bear2Attack2.getSpeed() > charAttack.getSpeed()) {
                        EnemyAttack(bear2Attack2, charAttack);
                        b1F1battleText.setText(f1B1enemyName.getText() + "Attacks first ");
                    }
                    else if(bear2Attack2.getSpeed() == charAttack.getSpeed()){
                        random = new Random().nextInt(2) + 1;
                        if(random == 1) {
                            EnemyAttack(bear2Attack2, charAttack);
                            b1F1battleText.setText(f1B1enemyName.getText() + "Attacks first ");
                        }
                        else{
                            PlayerAttack( charAttack, bear2Attack2 );
                            b1F1battleText.setText(f1B1charName.getText() + "Attacks first ");
                        }
                    }
                    else{
                        PlayerAttack( charAttack, bear2Attack2 );
                        b1F1battleText.setText(f1B1charName.getText() + "Attacks first ");
                    }
                    break;

            }

        }

        public void EnemyAttack( Attack enemyAttack, Attack  charAttack){
            Double cCHP =  Double.parseDouble(Singleton.getInstance().getCharCurrentHP());
            b1F1battleText.setText(f1B1enemyName.getText() + " uses " + enemyAttack.getName());
            cCHP -= enemyAttack.getDamage();
            b1F1battleText.setText(enemyAttack.getName() + " deals " + enemyAttack.getDamage() + "to" + f1B1charName.getText());
            CheckCharHealth(cCHP);
            String setCharHP = String.valueOf(cCHP);
            Singleton.getInstance().setCharCurrentHP(setCharHP);
            f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
//
            double cEHP =  Singleton.getInstance().getEnemyHP();
            b1F1battleText.setText(f1B1charName.getText() + " uses " + charAttack.getName());
            cEHP -= enemyAttack.getDamage();
            b1F1battleText.setText(charAttack.getName() + " deals " + charAttack.getDamage() + "to" + f1B1enemyName.getText());
            CheckEnemyHealth(cEHP);

            Singleton.getInstance().setEnemyHP(cEHP);

            f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());




        }

        public void PlayerAttack( Attack enemyAttack, Attack  charAttack){
            double cEHP =  Singleton.getInstance().getEnemyHP();
            b1F1battleText.setText(f1B1charName.getText() + " uses " + charAttack.getName());
            cEHP -= enemyAttack.getDamage();
            b1F1battleText.setText(charAttack.getName() + " deals " + charAttack.getDamage() + "to" + f1B1enemyName.getText());
            CheckEnemyHealth(cEHP);
            Singleton.getInstance().setEnemyHP(cEHP);
            f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());

            //

            Double cCHP =  Double.parseDouble(Singleton.getInstance().getCharCurrentHP());
            b1F1battleText.setText(f1B1enemyName.getText() + " uses " + enemyAttack.getName());
            cCHP -= enemyAttack.getDamage();
            b1F1battleText.setText(enemyAttack.getName() + " deals " + enemyAttack.getDamage() + "to" + f1B1charName.getText());
            CheckCharHealth(cCHP);
            String setCharHP = String.valueOf(cCHP);
            Singleton.getInstance().setCharCurrentHP(setCharHP);
            f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());

        }

        public void CheckMagic() {

            int cMagic =  Integer.parseInt(Singleton.getInstance().getCharCurrentMagic());
            if( cMagic <= 0){
                int setZeroMagic = 0 * cMagic;
                String setMagic = String.valueOf(setZeroMagic);
                Singleton.getInstance().setCharCurrentMagic(setMagic);
                f1B1charMP.setText(Singleton.getInstance().getCharCurrentMagic());
                f1B1charSpell1.setVisibility(View.INVISIBLE);
            }
            else {
                f1B1charSpell1.setVisibility(View.VISIBLE);
            }

        }

    }

