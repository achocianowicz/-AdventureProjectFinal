package com.example.joydr.adventureprojectfinal;

import android.Manifest;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameLobby extends AppCompatActivity
{
    String primarySentName = "PrimarySentTest";
    String receivedName = "receivedTest";
    String secondarySentName = "SecondarySentTest";
    //String primaryReceivedName = "PrimaryReceivedTesting";
    int receivedNameLength = -1;
    //int primaryReceivedNameLength = -1;

    EditText phoneNumberText, messageText = null;

    TextView receivedPhopneNumberText, receivedMessageText = null;
    Button  sendButton = null;

    private BroadcastReceiver broadcastReceiver;
    private SmsManager smsManager = SmsManager.getDefault();

    private boolean isStarfishButton =false, isTankButton = false,isGulfclubButton =false ;

    //added
    //  Button accpetButton =null, declineButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);

        //primarySentName = getIntent().getExtras().get("PLAYER_NAME").toString();
        // = primarySentName;

        phoneNumberText = findViewById(R.id.phoneNumberText);

        receivedMessageText = findViewById(R.id.receivedMessageText);
        receivedPhopneNumberText = findViewById(R.id.receivedPhoneNumberText);


        sendButton = findViewById(R.id.sendMessageButton);

        /*
        accpetButton.setVisibility(View.INVISIBLE);
        declineButton.setVisibility(View.INVISIBLE);
        accpetButton.setEnabled(false);
        declineButton.setEnabled(false);
        */

        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.SEND_SMS,
                android.Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.READ_SMS,
                android.Manifest.permission.RECEIVE_SMS},1);

        sendButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String number = phoneNumberText.getText().toString();

                smsManager.sendTextMessage(number, null, "$ASSIGN4TTT$NAME,,," + primarySentName,
                        null, null);

                smsManager.sendTextMessage(number, null, MessageHandler.getInviteMessage(),
                        null, null);

                smsManager.sendTextMessage(number, null, "$ASSIGN4TTT$NAME,,," + primarySentName,
                        null, null);
            }
        });

        /*
        accpetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberText.getText().toString();
                String message = " I accept your Request";
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Intent intent = new Intent(v.getContext(), Arena.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });
        */

        /*
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberText.getText().toString();
                String message = " I ani't play no fool";
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                accpetButton.setVisibility(View.INVISIBLE);
                declineButton.setVisibility(View.INVISIBLE);
                accpetButton.setEnabled(false);
                declineButton.setEnabled(false);

            }
        });
        */

        SMSReceiver smsReceiver = new SMSReceiver(this);

        if(!isSmsPermissionGranted())
        {
            requestReadAndSendSmsPermission();
        }

        broadcastReceiver = new BroadcastReceiver()
        {
            @Override
            public void onReceive(final Context context, Intent intent)
            {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
                {
                    SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

                    for (SmsMessage m: messages)
                    {
                        final String number = m.getDisplayOriginatingAddress();
                        String text = m.getDisplayMessageBody();

                        System.err.println("text:" + text);

                        if (MessageHandler.isNameMessage(text))
                        {
                            receivedNameLength = text.length();
                            receivedName = text.substring(19, receivedNameLength);

                            //System.err.println("Meow:" + receivedName);
                        }
                        else if (MessageHandler.isMessageInvite(text))
                        {
                            new AlertDialog.Builder(GameLobby.this)
                                    .setTitle("Game Invite")
                                    .setMessage("Would you like to play a game with " + number + "?")
                                    .setIcon(android.R.drawable.ic_dialog_alert)

                                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                                    {
                                        public void onClick(DialogInterface dialog, int whichButton)
                                        {
                                            smsManager.sendTextMessage(number, null,
                                                    "$ASSIGN4TTT$NAME,,," + secondarySentName,
                                                    null, null);

                                            smsManager.sendTextMessage(number, null,
                                                    MessageHandler.getAcceptMessage(), null, null);

                                            smsManager.sendTextMessage(number, null,
                                                    "$ASSIGN4TTT$NAME,,," + secondarySentName,
                                                    null, null);

                                            Intent i = new Intent(context, Arena.class);
                                            i.putExtra("NUMBER", number);
                                            i.putExtra("RECEIVED_NAME", receivedName);
                                            i.putExtra("STARTING_TURN", true);
                                            i.putExtra("SYMBOL", "tank");
                                            i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                            startActivity(i);
                                        }
                                    })

                                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which)
                                        {
                                            smsManager.sendTextMessage(number, null,
                                                    MessageHandler.getDenyMessage(), null, null);
                                        }
                                    })

                                    .show();
                        }
                        else if (MessageHandler.isMessageAccept(text))
                        {
                            Intent i = new Intent(context, Arena.class);
                            i.putExtra("NUMBER", number);
                            i.putExtra("RECEIVED_NAME", receivedName);
                            i.putExtra("STARTING_TURN", false);
                            i.putExtra("SYMBOL", "starfish");
                            i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(i);
                        }
                        else if (MessageHandler.isMessageDeny(text))
                        {
                            Toast.makeText(GameLobby.this, "Invitation Rejected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        };

        registerReceiver(broadcastReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    public void displayMessage(String number, String message)
    {
        receivedPhopneNumberText.setText(number);
        receivedMessageText.setText(message);
        /*
        accpetButton.setVisibility(View.VISIBLE);
        declineButton.setVisibility(View.VISIBLE);
        accpetButton.setEnabled(true);
        declineButton.setEnabled(true);
        */
    }

    /** * Check if we have SMS permission */
    public boolean isSmsPermissionGranted()
    {
        return ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_SMS)
                == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECEIVE_SMS)
                        == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE)
                        == PackageManager.PERMISSION_GRANTED;
    }

    /** * Request runtime SMS permission*/
    private void requestReadAndSendSmsPermission()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_SMS))
        {

        }
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_SMS,
                android.Manifest.permission.SEND_SMS,
                android.Manifest.permission.RECEIVE_SMS,
                Manifest.permission.READ_PHONE_STATE}, 1);
    }
}