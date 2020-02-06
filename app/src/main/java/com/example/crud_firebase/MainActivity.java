package com.example.crud_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud_firebase.dao.DAOUser;
import com.example.crud_firebase.dao.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText textEmail;
    private EditText textPass;
    private EditText textCity;
    private EditText userName;
    private EditText phoneTxt;
    private ProgressDialog progressDialog;
    private Button regButton;
    private Button logButton;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TESTING
        DAOUser.getInstance().signOut();

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Initialize Firebase Database reference


        phoneTxt = findViewById(R.id.phonetxt);
        textEmail = (EditText) findViewById(R.id.mail);
        textPass = (EditText) findViewById(R.id.pass);
        userName = (EditText) findViewById(R.id.uName);
        textCity = (EditText) findViewById(R.id.apellidos);


        progressDialog = new ProgressDialog(this);
        regButton = (Button) findViewById(R.id.signup);
        logButton = (Button) findViewById(R.id.login);

        regButton.setOnClickListener(this);
        logButton.setOnClickListener(this);
    }

    /**
     * Método para registrar al usuario
     */
    public void SignUpUser(){
        final String email = textEmail.getText().toString().trim();
        final String password = textPass.getText().toString().trim();
        final String uname = userName.getText().toString().trim();
        final String apellidos = textCity.getText().toString().trim();
        final String phone = phoneTxt.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Introduce un valor en email",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Introduce un valor en contraseña",Toast.LENGTH_LONG).show();
            return;
        }
        User user = new User(uname,apellidos,phone,email,"");
        user.setPassword(password);
        DAOUser.getInstance().insert(user);
    }

    /**
     * Metodo para loguear al usuario
     */
    private void LogInUser() {
        final String email = textEmail.getText().toString().trim();
        final String password = textPass.getText().toString().trim();
        final String uname = userName.getText().toString().trim();
        final String apellidos = textCity.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Introduce un valor en email",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Introduce un valor en contraseña",Toast.LENGTH_LONG).show();
            return;
        }
        User user = new User(uname,apellidos,email,password);
        DAOUser.getInstance().SignIn(user);
        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(this,Welcome.class));
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup:
                SignUpUser();
                break;
            case R.id.login:
                LogInUser();
        }
    }




}
