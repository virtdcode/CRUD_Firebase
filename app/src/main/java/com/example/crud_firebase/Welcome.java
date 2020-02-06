package com.example.crud_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crud_firebase.dao.DAOUser;
import com.example.crud_firebase.dao.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    private EditText usrCity;
    private EditText usrEmail;
    private TextView welcomeMessage;
    private Map<String,String> userMap;
    private Button editButton;
    private Button saveButton;
    private ProgressDialog progressDialog;

    private User user;

    private FirebaseUser mUser;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // UI
        usrCity = findViewById(R.id.usrCityEdit);
        usrEmail = findViewById(R.id.usrEmailEdit);
        welcomeMessage = findViewById(R.id.welcome);
        editButton = findViewById(R.id.editProf);
        saveButton = findViewById(R.id.saveProf);
        editButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        // MODELO
        userMap = new HashMap<>();
        // FIREBASE
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        // METODOS
        getUser();
        setEditable(false);
    }

    private void getUser() {
        DAOUser.getInstance().select(mUser.getUid());
        UpdateUi();
    }


    private void UpdateUi(){
        welcomeMessage.setText("Bienvenido " + user.getName() + " " + user.getSurname());

    }
    private void saveChanges() {
        User usr = new User(usrCity.getText().toString(),usrEmail.getText().toString(),"","","");
        DAOUser.update(usr);
    }

    private void setEditable(boolean b) {
        usrCity.setEnabled(b);
        usrEmail.setEnabled(b);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editProf:
                setEditable(true);
                break;
            case R.id.saveProf:
                saveChanges();
                setEditable(false);
                break;
        }
    }

}
