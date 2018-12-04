package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Plains1Loin1Combat extends AppCompatActivity {


    TextView f1B1enemyName = null, f1B1enemyLevel = null, f1B1enemyHP = null, f1B1enemyMP = null,
            f1B1charName = null, f1B1charLevel = null, f1B1charHP = null, f1B1charMP= null,
            b1F1battleText = null;

    ImageView f1B1enemyImage = null, f1B1charImage = null;

    Button f1B1hpButton = null,f1B1mpButton = null,
            f1B1charAttack1 = null, f1B1charAttack2 = null, f1B1charSpell1 = null,
            f1B1toGoToReward = null,
            f1B1toGoToFailQuest = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plains1_loin1_combat);

        f1B1enemyName = findViewById(R.id.p1L1enemyName);
        f1B1enemyLevel = findViewById(R.id.p1L1enemyLevel);
        f1B1enemyHP = findViewById(R.id.p1L1enemyHP);
        f1B1enemyMP = findViewById(R.id.p1L1enemyMP);


        f1B1charName = findViewById(R.id.p1L1charName);
        f1B1charLevel = findViewById(R.id.p1L1charLevel);
        f1B1charHP = findViewById(R.id.p1L1charHP);
        f1B1charMP = findViewById(R.id.p1L1charMP);


        f1B1enemyImage = findViewById(R.id.p1L1enemyImage);
        f1B1charImage = findViewById(R.id.p1L1charImage);

        f1B1hpButton = findViewById(R.id.p1L1hpButton);
        f1B1mpButton = findViewById(R.id.p1L1mpButton);

        f1B1charAttack1 = findViewById(R.id.p1L1charAttack1);
        f1B1charAttack2 = findViewById(R.id.p1L1charAttack2);
        f1B1charSpell1 = findViewById(R.id.p1L1charSpell1);


        f1B1toGoToReward = findViewById(R.id.p1L1toGoToReward);
        f1B1toGoToFailQuest = findViewById(R.id.p1L1toGoToFailQuest);

        b1F1battleText = findViewById(R.id.p1L1battleText);
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
        f1B1toGoToFailQuest.setVisibility(View.INVISIBLE);
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
                    String setCharHP = String.valueOf(cCHP);
                    Singleton.getInstance().setCharCurrentHP(setCharHP);
                    f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());

                    numberOfHP--;
                    String setHPCount = String.valueOf(numberOfHP);
                    Singleton.getInstance().setHpCount(setHPCount);
                    f1B1hpButton.setText(Singleton.getInstance().getHpCount());

                    b1F1battleText.setText(f1B1charName.getText() + " Used a HP to Heal up to: " + setCharHP);

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
                    // add magice
                    cCMP += 25;
                    String setCharMP = String.valueOf(cCMP);
                    Singleton.getInstance().setCharCurrentMagic(setCharMP);
                    CheckMagic();
                    f1B1charMP.setText("MP: " + Singleton.getInstance().getCharCurrentMagic());
                    // minus potion
                    numberOfMP--;
                    String setMPCount = String.valueOf(numberOfMP);
                    Singleton.getInstance().setMpCount(setMPCount);
                    f1B1mpButton.setText(Singleton.getInstance().getMpCount());

                    b1F1battleText.setText(f1B1charName.getText() + " Used a MP to Power up");


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
                    cEHP -= (charSpell1.getDamage() + Double.parseDouble(Singleton.getInstance().getCharMagic()));
                    b1F1battleText.setText(charSpell1.getName() + " deals " + (charSpell1.getDamage() + Double.parseDouble(Singleton.getInstance().getCharMagic()))
                            + "to" + f1B1enemyName.getText());
                    CheckEnemyHealth(cEHP);
                    Singleton.getInstance().setEnemyHP(cEHP);
                    f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());
                }
                else{
                    b1F1battleText.setText(charSpell1.getName() + " can't be used, not Enough Maigc. Need " + (magicCost - cMagic)  + "more Magic to Cast: " + charSpell1.getName());

                }


            }
        });



        f1B1toGoToReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), QuestReward.class);
                Singleton.getInstance().setPlainsQuest1Done(true);
                //send exp and gold
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);

            }
        });

        f1B1toGoToFailQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FailQuest.class);
                f1B1charImage.setImageResource(R.drawable.peasant2);
                Singleton.getInstance().setEnemyHP(Singleton.getInstance().getEnemyBaseHP());
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
                finish();

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


            Singleton.getInstance().setQuestTitle("Forest1 Bear1 Combat");
            Singleton.getInstance().setExpReward(0);
            Singleton.getInstance().setGoldReward(0);

            f1B1toGoToFailQuest.setVisibility(View.VISIBLE);
            f1B1charAttack1.setVisibility(View.INVISIBLE);
            f1B1charAttack2.setVisibility(View.INVISIBLE);
            f1B1charSpell1.setVisibility(View.INVISIBLE);
            f1B1hpButton.setVisibility(View.INVISIBLE);
            f1B1mpButton.setVisibility(View.INVISIBLE);
        }

    }

    public void CheckEnemyHealth(Double cHP){
        if(cHP > 0){

            // enemy is alive battle
            return;
        }
        else{

            //enemy dead is dead
            Singleton.getInstance().setQuestTitle("Plains 1 Loin 1 Combat");
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

    public void CharDodge(Attack enemyAttack, Attack  charAttack){

    }

    public void EnemyHit( Attack enemyAttack, Attack  charAttack){


    }
    public void EnemyAttack( Attack enemyAttack, Attack  charAttack){
        Double cCHP =  Double.parseDouble(Singleton.getInstance().getCharCurrentHP());
        b1F1battleText.setText(f1B1enemyName.getText() + " uses " + enemyAttack.getName());

        //  CharDodge( enemyAttack, charAttack);
        int hit = new Random().nextInt(100) + 1;
        int charDodge = Integer.parseInt(Singleton.getInstance().getCharDodge());
        if(charDodge > hit)
        {
            b1F1battleText.setText(charAttack.getName() + " misses with the Attack on  "  + f1B1enemyName.getText());
            // miss
        }

        else{

            // EnemyHit( enemyAttack, charAttack);
            cCHP -= enemyAttack.getDamage();
            b1F1battleText.setText(enemyAttack.getName() + " deals " + enemyAttack.getDamage() + "to" + f1B1charName.getText());
            CheckCharHealth(cCHP);
            String setCharHP = String.valueOf(cCHP);
            Singleton.getInstance().setCharCurrentHP(setCharHP);
            f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
        }


//
        double cEHP =  Singleton.getInstance().getEnemyHP();
        b1F1battleText.setText(f1B1charName.getText() + " uses " + charAttack.getName());
        cEHP -= (charAttack.getDamage() + Double.parseDouble(Singleton.getInstance().getCharAttack()));
        b1F1battleText.setText(charAttack.getName() + " deals " + (charAttack.getDamage() + Double.parseDouble(Singleton.getInstance().getCharAttack()))
                + "to" + f1B1enemyName.getText());
        CheckEnemyHealth(cEHP);

        Singleton.getInstance().setEnemyHP(cEHP);

        f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());
        RegenerateHPandMP();
    }

    public void PlayerAttack( Attack enemyAttack, Attack  charAttack){
        double cEHP =  Singleton.getInstance().getEnemyHP();
        b1F1battleText.setText(f1B1charName.getText() + " uses " + charAttack.getName());
        cEHP -= (charAttack.getDamage() + Double.parseDouble(Singleton.getInstance().getCharAttack()));
        b1F1battleText.setText(charAttack.getName() + " deals " + (charAttack.getDamage() + Double.parseDouble(Singleton.getInstance().getCharAttack()))
                + "to" + f1B1enemyName.getText());
        CheckEnemyHealth(cEHP);
        Singleton.getInstance().setEnemyHP(cEHP);
        f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());

        //

        Double cCHP =  Double.parseDouble(Singleton.getInstance().getCharCurrentHP());
        int hit = new Random().nextInt(100) + 1;
        int charDodge = Integer.parseInt(Singleton.getInstance().getCharDodge());
        if(charDodge > hit)
        {
            b1F1battleText.setText(charAttack.getName() + " misses with the Attack on  "  + f1B1enemyName.getText());
            // miss
        }

        else{
            // EnemyHit( enemyAttack, charAttack);
            cCHP -= enemyAttack.getDamage();
            b1F1battleText.setText(enemyAttack.getName() + " deals " + enemyAttack.getDamage() + "to" + f1B1charName.getText());
            CheckCharHealth(cCHP);
            String setCharHP = String.valueOf(cCHP);
            Singleton.getInstance().setCharCurrentHP(setCharHP);
            f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
        }
        RegenerateHPandMP();

    }

    public void CheckMagic() {
        Spell charSpell1 = Singleton.getInstance().charSpell1;
        int cMagic =  Integer.parseInt(Singleton.getInstance().getCharCurrentMagic());
        int magicCost = Integer.parseInt(Singleton.getInstance().charSpell1.getMagicCost());

        if( cMagic <= 0){
            int setZeroMagic = 0 * cMagic;
            String setMagic = String.valueOf(setZeroMagic);
            Singleton.getInstance().setCharCurrentMagic(setMagic);
            f1B1charMP.setText(Singleton.getInstance().getCharCurrentMagic());
            f1B1charSpell1.setVisibility(View.INVISIBLE);
        }

        else if(cMagic >= magicCost) {

            f1B1charSpell1.setVisibility(View.VISIBLE);
        }


        else {
            f1B1charSpell1.setVisibility(View.INVISIBLE);

        }

    }

    public void RegenerateHPandMP(){
        Double cCHP =  Double.parseDouble(Singleton.getInstance().getCharCurrentHP());
        Double healthReg = Double.parseDouble(Singleton.getInstance().getCharHealth());
        int cMagic =  Integer.parseInt(Singleton.getInstance().getCharCurrentMagic());
        int magicReg = Integer.parseInt(Singleton.getInstance().getCharINTELL());

        cCHP +=healthReg;
        String newCharHp = String.valueOf(cCHP);
        Singleton.getInstance().setCharCurrentHP(newCharHp);
        f1B1charHP.setText(Singleton.getInstance().getCharCurrentHP());

        cMagic +=magicReg;
        String newCharMp = String.valueOf(cMagic);
        Singleton.getInstance().setCharCurrentMagic(newCharMp);
        CheckMagic();
        f1B1charMP.setText(Singleton.getInstance().getCharCurrentMagic());


    }

    @Override
    protected void  onResume() {
        super.onResume();

        f1B1charName.setText(Singleton.getInstance().getCharName());
        f1B1charLevel.setText("Level: " +Singleton.getInstance().getCharLevel());
        f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
        f1B1charMP.setText("MP: " +Singleton.getInstance().getCharCurrentMagic());
        //char attack
        Attack charAttack1 = Singleton.getInstance().charAttack1;
        Attack charAttack2 = Singleton.getInstance().charAttack2;

        f1B1toGoToReward.setVisibility(View.INVISIBLE);
        f1B1toGoToFailQuest.setVisibility(View.INVISIBLE);
        f1B1charAttack1.setText(Singleton.getInstance().getCharAttack1().getName());
        f1B1charAttack2.setText(Singleton.getInstance().getCharAttack2().getName());
        f1B1charSpell1.setText(Singleton.getInstance().getCharSpell1().getName());
        f1B1hpButton.setText(Singleton.getInstance().getHpCount());
        f1B1mpButton.setText(Singleton.getInstance().getMpCount());


    }

}
