package com.example.joydr.adventureprojectfinal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Arena extends AppCompatActivity {
    TextView f1B1enemyName = null, f1B1enemyLevel = null, f1B1enemyHP = null, f1B1enemyMP = null,
            f1B1charName = null, f1B1charLevel = null, f1B1charHP = null, f1B1charMP = null,
            b1F1battleText = null;

    ImageView f1B1enemyImage = null, f1B1charImage = null;

    Button f1B1hpButton = null, f1B1mpButton = null,
            f1B1charAttack1 = null, f1B1charAttack2 = null, f1B1charSpell1 = null,
            f1B1charFlee = null,
            ArenatoGoToCombatReport = null;

    private BroadcastReceiver broadcastReceiver;
    private SmsManager smsManager;

    //Enemy Online

    private String enemyNumber, enemyNameOnline = "test",enemyLevelOnline ="1", enemyHPOnline =" 100", enemyMPOnline = "100",
            enemyWeaponAttackNameOnline = "sword", enemyWeaponAttack1DamageOnline = "20", enemyWeaponAttack1SpeedOnline ="70",
            enemySpellNameOnline = "fireball", enemyItemNameOnline,
             enemySpellDamageOnline = "40", enemyItemValueOnline;



    //Player Online
    private String playerNameOnline, playerWeaponAttackNameOnline, playerSpellNameOnline, playerItemNameOnline,
            playerWeaponAttackDamageOnline, playerWeaponAttackSpeedOnline, playerSpellDamageOnline, playerItemValueOnline;

    private boolean playerAttacked, enemyAttacked;
    Attack playerOnlineAttack = new Attack();
    //Attack enmeyOnlineAttack = new Attack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);
        enemyNumber = getIntent().getExtras().get("NUMBER").toString();
        smsManager = SmsManager.getDefault();
        TelephonyManager tMgr = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        final String mPhoneNumber = tMgr.getLine1Number();

        f1B1enemyName = findViewById(R.id.ArenaenemyName);
        f1B1enemyLevel = findViewById(R.id.ArenaenemyLevel);
        f1B1enemyHP = findViewById(R.id.ArenaenemyHP);
        f1B1enemyMP = findViewById(R.id.ArenaenemyMP);


        f1B1charName = findViewById(R.id.ArenacharName);
        f1B1charLevel = findViewById(R.id.ArenacharLevel);
        f1B1charHP = findViewById(R.id.ArenacharHP);
        f1B1charMP = findViewById(R.id.ArenacharMP);


        f1B1enemyImage = findViewById(R.id.ArenaenemyImage);
        f1B1charImage = findViewById(R.id.ArenacharImage);

        f1B1hpButton = findViewById(R.id.ArenahpButton);
        f1B1mpButton = findViewById(R.id.ArenampButton);

        f1B1charAttack1 = findViewById(R.id.ArenacharAttack1);
        f1B1charAttack2 = findViewById(R.id.ArenacharAttack2);
        f1B1charSpell1 = findViewById(R.id.ArenacharSpell1);

        f1B1charFlee = findViewById(R.id.ArenacharFlee);
        ArenatoGoToCombatReport = findViewById(R.id.ArenatoGoToCombatReport);

        b1F1battleText = findViewById(R.id.ArenabattleText);
// Enemy
        f1B1enemyName.setText(Singleton.getInstance().bear1.getEnemyName());
        f1B1enemyLevel.setText("Level: " + enemyLevelOnline);
        f1B1enemyHP.setText("HP: " + enemyHPOnline);
        f1B1enemyMP.setText("MP: " + enemyMPOnline);
        // bear attack
        Attack bear1Attack1 = Singleton.getInstance().bear1Attack1;
        Attack bear2Attack2 = Singleton.getInstance().bear1Attack2;
// char
        f1B1charName.setText(Singleton.getInstance().getCharName());
        f1B1charLevel.setText("Level: " + Singleton.getInstance().getCharLevel());
        f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
        f1B1charMP.setText("MP: " + Singleton.getInstance().getCharCurrentMagic());
        //char attack
        Attack charAttack1 = Singleton.getInstance().charAttack1;
        Attack charAttack2 = Singleton.getInstance().charAttack2;

        ArenatoGoToCombatReport.setVisibility(View.INVISIBLE);
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

                if (numberOfHP > 0) {
                    int cCHP = Integer.parseInt(Singleton.getInstance().getCharCurrentHP());
                    cCHP += 25;
                    numberOfHP--;
                    String setHPCount = String.valueOf(numberOfHP);
                    Singleton.getInstance().setHpCount(setHPCount);
                    String setCharHP = String.valueOf(cCHP);
                    Singleton.getInstance().setCharCurrentHP(setCharHP);
                    f1B1hpButton.setText(Singleton.getInstance().getHpCount());
                    f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
                    b1F1battleText.setText(f1B1charName.getText() + " Used a HP to Heal up by: " + setCharHP);
                    smsManager.sendTextMessage(enemyNumber, null,
                            MessageHandler.isItem("Health Potion", 25),
                            null, null);

                } else {
                    b1F1battleText.setText(f1B1charName.getText() + " Has no HP to use!");

                }

            }
        });
        f1B1mpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberOfMP = Integer.parseInt(Singleton.getInstance().getMpCount());

                if (numberOfMP > 0) {
                    int cCMP = Integer.parseInt(Singleton.getInstance().getCharCurrentMagic());
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
                    smsManager.sendTextMessage(enemyNumber, null,
                            MessageHandler.isItem("Magic Potion", 25),
                            null, null);

                } else {
                    b1F1battleText.setText(f1B1charName.getText() + " Has no MP to use!");

                }

            }
        });
        f1B1charAttack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Attack charAttack1 = Singleton.getInstance().charAttack1;
                smsManager.sendTextMessage(enemyNumber, null,
                        MessageHandler.isAttack(Singleton.getInstance().charAttack1.getName(),
                                String.valueOf(Singleton.getInstance().charAttack1.getDamage()),  String.valueOf(Singleton.getInstance().charAttack1.getSpeed())),
                        null, null);
                playerAttacked = true;
                f1B1charAttack1.setText(" Sent Attack 1");
                f1B1charAttack1.setClickable(false);
                f1B1charAttack2.setText(" Sent Attack 1");
                f1B1charAttack2.setClickable(false);
                playerOnlineAttack = charAttack1;
                playerAttacked = true;


            }
        });
        f1B1charAttack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Attack charAttack2 = Singleton.getInstance().charAttack2;
                smsManager.sendTextMessage(enemyNumber, null,
                        MessageHandler.isAttack(Singleton.getInstance().charAttack2.getName(),
                                String.valueOf(Singleton.getInstance().charAttack2.getDamage()),  String.valueOf(Singleton.getInstance().charAttack2.getSpeed())),
                        null, null);
                playerAttacked = true;
                f1B1charAttack1.setText(" Sent Attack 2");
                f1B1charAttack1.setClickable(false);
                f1B1charAttack2.setText(" Sent Attack 2");
                f1B1charAttack2.setClickable(false);
                playerOnlineAttack = charAttack2;
                playerAttacked = true;

            }
        });

        f1B1charSpell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spell charSpell1 = Singleton.getInstance().charSpell1;
                int cMagic = Integer.parseInt(Singleton.getInstance().getCharCurrentMagic());
                int magicCost = Integer.parseInt(Singleton.getInstance().charSpell1.getMagicCost());
                if (cMagic >= magicCost) {

                    b1F1battleText.setText(f1B1charName.getText() + " Has used " + f1B1charSpell1.getText().toString() + "!");

                    cMagic -= magicCost;
                    smsManager.sendTextMessage(enemyNumber, null,
                            MessageHandler.isSpell(Singleton.getInstance().charSpell1.getName(),String.valueOf(Singleton.getInstance().charSpell1.getDamage())),
                            null, null);
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
                } else {
                    b1F1battleText.setText(charSpell1.getName() + " can't be used, not Enough Maigc. Need " + (magicCost - cMagic) + "more Magic to Cast: " + charSpell1.getName());

                }


            }
        });

        f1B1charFlee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // quite
            }
        });

        ArenatoGoToCombatReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CombatReport.class);

                //send exp and gold
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);

            }
        });

        //Broadcast reciver

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(final Context context, Intent intent) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

                    for (SmsMessage m : messages) {
                        final double messageNumber = Double.parseDouble(m.getDisplayOriginatingAddress());
                        double reciverNumber = Double.parseDouble(mPhoneNumber);
                        String text = m.getDisplayMessageBody();

                        System.err.println("text:" + text);

                        if (messageNumber != reciverNumber && MessageHandler.isMessageMove(text)) {
                            // Enemy Attack
                            enemyWeaponAttackNameOnline = String.valueOf(MessageHandler.getAttackName(text));
                            enemyWeaponAttack1DamageOnline = String.valueOf(MessageHandler.getAttackDamage(text));
                            enemyWeaponAttack1SpeedOnline = String.valueOf(MessageHandler.getAttackSpeed(text));
                            enemyAttacked = true;
                        }

                        /*if (messageNumber == reciverNumber && MessageHandler.isMessageMove(text)) {
                            // Enemy Attack
                            enemyWeaponAttackNameOnline = String.valueOf(MessageHandler.getAttackName(text));
                            enemyWeaponAttack1DamageOnline = String.valueOf(MessageHandler.getAttackDamage(text));
                            enemyWeaponAttack1SpeedOnline = String.valueOf(MessageHandler.getAttackSpeed(text));
                            enemyAttacked = true;
                        }
                        */
                        if (enemyAttacked && playerAttacked) {
                            Attack playerAttack = playerOnlineAttack;
                            Attack enemyAttack = new Attack(enemyWeaponAttackNameOnline, Double.parseDouble(enemyWeaponAttack1DamageOnline)
                                    , Double.parseDouble(enemyWeaponAttack1SpeedOnline));
                            OnlineCombat(playerAttack, enemyAttack);
                        }
                        //#TODO store enemy attack then check to see if can attack

                    }
                }




                registerReceiver(broadcastReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));

            }

        };
        }

            public void CheckCharHealth(Double cHP) {
                if (cHP > 0) {

                    // char is alive battle
                    return;
                } else {
                    f1B1charImage.setImageResource(R.drawable.dead);
                    //Char is dead
                    ArenatoGoToCombatReport.setVisibility(View.VISIBLE);
                    f1B1charAttack1.setVisibility(View.INVISIBLE);
                    f1B1charAttack2.setVisibility(View.INVISIBLE);
                    f1B1charSpell1.setVisibility(View.INVISIBLE);
                    f1B1hpButton.setVisibility(View.INVISIBLE);
                    f1B1mpButton.setVisibility(View.INVISIBLE);
                }

            }

            public void CheckEnemyHealth(Double cHP) {
                if (cHP > 0) {

                    // enemy is alive battle
                    return;
                } else {

                    //enemy dead is dead
                    Singleton.getInstance().setQuestTitle("Forest1 Bear1 Combat");
                    Singleton.getInstance().setExpReward(Singleton.getInstance().getForest1Bear1EXPReward());
                    Singleton.getInstance().setGoldReward(Singleton.getInstance().getForest1Bear1GoldReward());
                    f1B1enemyImage.setImageResource(R.drawable.win);
                    ArenatoGoToCombatReport.setVisibility(View.VISIBLE);
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
                        if (bear1Attack1.getSpeed() > charAttack.getSpeed()) {
                            EnemyAttack(bear1Attack1, charAttack);
                            b1F1battleText.setText(f1B1enemyName.getText() + "Attacks first ");
                        } else if (bear1Attack1.getSpeed() == charAttack.getSpeed()) {
                            random = new Random().nextInt(2) + 1;
                            if (random == 1) {
                                EnemyAttack(bear1Attack1, charAttack);
                                b1F1battleText.setText(f1B1enemyName.getText() + "Attacks first ");
                            } else {
                                PlayerAttack(charAttack, bear1Attack1);
                                b1F1battleText.setText(f1B1charName.getText() + "Attacks first ");
                            }
                        } else {
                            PlayerAttack(charAttack, bear1Attack1);
                            b1F1battleText.setText(f1B1charName.getText() + "Attacks first ");
                        }
                        break;

                    case 2:

                        if (bear2Attack2.getSpeed() > charAttack.getSpeed()) {
                            EnemyAttack(bear2Attack2, charAttack);
                            b1F1battleText.setText(f1B1enemyName.getText() + "Attacks first ");
                        } else if (bear2Attack2.getSpeed() == charAttack.getSpeed()) {
                            random = new Random().nextInt(2) + 1;
                            if (random == 1) {
                                EnemyAttack(bear2Attack2, charAttack);
                                b1F1battleText.setText(f1B1enemyName.getText() + "Attacks first ");
                            } else {
                                PlayerAttack(charAttack, bear2Attack2);
                                b1F1battleText.setText(f1B1charName.getText() + "Attacks first ");
                            }
                        } else {
                            PlayerAttack(charAttack, bear2Attack2);
                            b1F1battleText.setText(f1B1charName.getText() + "Attacks first ");
                        }
                        break;

                }

            }

            public void EnemyAttack(Attack enemyAttack, Attack charAttack) {
                Double cCHP = Double.parseDouble(Singleton.getInstance().getCharCurrentHP());
                b1F1battleText.setText(f1B1enemyName.getText() + " uses " + enemyAttack.getName());
                cCHP -= enemyAttack.getDamage();
                b1F1battleText.setText(enemyAttack.getName() + " deals " + enemyAttack.getDamage() + "to" + f1B1charName.getText());
                CheckCharHealth(cCHP);
                String setCharHP = String.valueOf(cCHP);
                Singleton.getInstance().setCharCurrentHP(setCharHP);
                f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
//
                double cEHP = Singleton.getInstance().getEnemyHP();
                b1F1battleText.setText(f1B1charName.getText() + " uses " + charAttack.getName());
                cEHP -= enemyAttack.getDamage();
                b1F1battleText.setText(charAttack.getName() + " deals " + charAttack.getDamage() + "to" + f1B1enemyName.getText());
                CheckEnemyHealth(cEHP);

                Singleton.getInstance().setEnemyHP(cEHP);

                f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());


            }

            public void PlayerAttack(Attack enemyAttack, Attack charAttack) {
                double cEHP = Singleton.getInstance().getEnemyHP();
                b1F1battleText.setText(f1B1charName.getText() + " uses " + charAttack.getName());
                cEHP -= enemyAttack.getDamage();
                b1F1battleText.setText(charAttack.getName() + " deals " + charAttack.getDamage() + "to" + f1B1enemyName.getText());
                CheckEnemyHealth(cEHP);
                Singleton.getInstance().setEnemyHP(cEHP);
                f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());

                //

                Double cCHP = Double.parseDouble(Singleton.getInstance().getCharCurrentHP());
                b1F1battleText.setText(f1B1enemyName.getText() + " uses " + enemyAttack.getName());
                cCHP -= enemyAttack.getDamage();
                b1F1battleText.setText(enemyAttack.getName() + " deals " + enemyAttack.getDamage() + "to" + f1B1charName.getText());
                CheckCharHealth(cCHP);
                String setCharHP = String.valueOf(cCHP);
                Singleton.getInstance().setCharCurrentHP(setCharHP);
                f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());

            }

            public void CheckMagic() {

                int cMagic = Integer.parseInt(Singleton.getInstance().getCharCurrentMagic());
                if (cMagic <= 0) {
                    int setZeroMagic = 0 * cMagic;
                    String setMagic = String.valueOf(setZeroMagic);
                    Singleton.getInstance().setCharCurrentMagic(setMagic);
                    f1B1charMP.setText(Singleton.getInstance().getCharCurrentMagic());
                    f1B1charSpell1.setVisibility(View.INVISIBLE);
                } else {
                    f1B1charSpell1.setVisibility(View.VISIBLE);
                }

            }

   public void  OnlineCombat( Attack playerAttack, Attack enemyAttack){
        if(playerAttack.getSpeed() > enemyAttack.getSpeed()){
            OnlinePlayerCombat(playerAttack,  enemyAttack);
        }
        else if(playerAttack.getSpeed() > enemyAttack.getSpeed()) {
            int random = new Random().nextInt(2) + 1;
            if (random == 1) {
                OnlineEnemyCombat(playerAttack,  enemyAttack);
                b1F1battleText.setText(f1B1enemyName.getText() + "Attacks first ");
            } else {
                OnlinePlayerCombat(playerAttack,  enemyAttack);
                b1F1battleText.setText(f1B1charName.getText() + "Attacks first ");

            }
        }
        else{
            OnlineEnemyCombat(playerAttack,  enemyAttack);


        }
    }

    public void OnlinePlayerCombat(Attack playerAttack, Attack  enemyAttack){
        Double cCHP = Double.parseDouble(Singleton.getInstance().getCharCurrentHP());
        b1F1battleText.setText(f1B1enemyName.getText() + " uses " + enemyAttack.getName());
        cCHP -= enemyAttack.getDamage();
        b1F1battleText.setText(enemyAttack.getName() + " deals " + enemyAttack.getDamage() + "to" + f1B1charName.getText());
        CheckCharHealth(cCHP);
        String setCharHP = String.valueOf(cCHP);
        Singleton.getInstance().setCharCurrentHP(setCharHP);
        f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
//
        double cEHP = Singleton.getInstance().getEnemyHP();
        //b1F1battleText.setText(f1B1charName.getText() + " uses " + charAttack.getName());
        cEHP -= enemyAttack.getDamage();
        //  b1F1battleText.setText(charAttack.getName() + " deals " + charAttack.getDamage() + "to" + f1B1enemyName.getText());
        CheckEnemyHealth(cEHP);

        Singleton.getInstance().setEnemyHP(cEHP);

        f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());

        playerAttacked = false;
        enemyAttacked = false;
        f1B1charAttack1.setText(Singleton.getInstance().getCharAttack1().getName());
        f1B1charAttack1.setClickable(true);
        f1B1charAttack2.setText(Singleton.getInstance().getCharAttack2().getName());
        f1B1charAttack2.setClickable(true);
        playerOnlineAttack = new Attack();



    }

    public void OnlineEnemyCombat(Attack playerAttack, Attack  enemyAttack){
        Double cCHP = Double.parseDouble(Singleton.getInstance().getCharCurrentHP());
        b1F1battleText.setText(f1B1enemyName.getText() + " uses " + enemyAttack.getName());
        cCHP -= enemyAttack.getDamage();
        b1F1battleText.setText(enemyAttack.getName() + " deals " + enemyAttack.getDamage() + "to" + f1B1charName.getText());
        CheckCharHealth(cCHP);
        String setCharHP = String.valueOf(cCHP);
        Singleton.getInstance().setCharCurrentHP(setCharHP);
        f1B1charHP.setText("HP: " + Singleton.getInstance().getCharCurrentHP());
//
        double cEHP = Singleton.getInstance().getEnemyHP();
      //  b1F1battleText.setText(f1B1charName.getText() + " uses " + charAttack.getName());
        cEHP -= enemyAttack.getDamage();
      //  b1F1battleText.setText(charAttack.getName() + " deals " + charAttack.getDamage() + "to" + f1B1enemyName.getText());
        CheckEnemyHealth(cEHP);

        Singleton.getInstance().setEnemyHP(cEHP);

        f1B1enemyHP.setText("HP: " + Singleton.getInstance().getEnemyHP());

        playerAttacked = false;
        enemyAttacked = false;
        f1B1charAttack1.setText(Singleton.getInstance().getCharAttack1().getName());
        f1B1charAttack1.setClickable(true);
        f1B1charAttack2.setText(Singleton.getInstance().getCharAttack2().getName());
        f1B1charAttack2.setClickable(true);
        playerOnlineAttack = new Attack();

    }

        }



