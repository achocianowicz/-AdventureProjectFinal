package com.example.joydr.adventureprojectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateCharacter extends AppCompatActivity {
Button createCharToTownButton = null, saveCharTestButton = null;

EditText charName = null;

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);

        createCharToTownButton = findViewById(R.id.createCharToTownButton);
        charName = findViewById(R.id.charName);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        createCharToTownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton.getInstance().setCharName(charName.getText().toString());
                Singleton.getInstance().setSavedCharName(charName.getText().toString());

                String  currentUserUID = Singleton.getInstance().getUserUID();
                String accountName = Singleton.getInstance().getAccountName();
                String charName = Singleton.getInstance().getAccountName();
                mDatabase.child("users").child(currentUserUID).setValue(null);
                mDatabase.child("users").child(currentUserUID).child("accountName").setValue(accountName);
                mDatabase.child("users").child(currentUserUID).child("charName").setValue(charName);

                Intent intent = new Intent(v.getContext(), Town.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                v.getContext().startActivity(intent);
            }
        });



    }
}
