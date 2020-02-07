package com.example.crud_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crud_firebase.dao.User;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;


public class User_list extends AppCompatActivity {
    private FirebaseListAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        listMessages();
    }

    public void listMessages(){
        String URL_REALTIME_DATABASE = "";
        // Recogemos en el objeto listOfMessages el elemento de ListView de la vista
        ListView listOfMessages = (ListView)findViewById(R.id.userlist);
        // Le ponemos de contexto a Firebase la actividad
        Firebase.setAndroidContext(this);
        // Creamos un objeto Firebase al que le pasamos la URL de la base de datos
        Firebase mDatabase = new Firebase(URL_REALTIME_DATABASE);
        // Inicializamos la clase anónima FireBaseListAdapter pasando como parámetros la actividad, la clase
        // del modelo, el layout que tendran los items de la lista y por último la referencia de la
        // base de datos
        myAdapter = new FirebaseListAdapter<User>(this, User.class,R.layout.list_template_view,mDatabase.child("users")) {

            @Override
            protected void populateView(View view, User user, int i) {

                // Cogemos las referencias del layout que le hemos puesto para los items en objetos
                // del tipo TextView
                TextView userName = (TextView)view.findViewById(R.id.user_name);
                TextView userMail = (TextView)view.findViewById(R.id.user_mail);
                TextView userPhone = (TextView)view.findViewById(R.id.user_phone);

                // Asignamos su valor mediante setText
                userName.setText(user.getName()+" "+user.getSurname());
                userMail.setText(user.getMail());
                userPhone.setText(user.getPhone());

            }
        };
        // Asignamos el adapter a la lista
        listOfMessages.setAdapter(myAdapter);
    }

}
