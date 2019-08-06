package com.example.iptvsmarterspro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;

public class Reclamation extends AppCompatActivity {

    private Button envoyer;
    EditText Code = null;
    EditText Nom = null;
    EditText Prenom = null;
    EditText Tel = null;
    EditText Objet = null;
    EditText Reclamation = null;
    EditText Destinataire = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamation);
        Code = (EditText) findViewById(R.id.Code);
        Nom = (EditText) findViewById(R.id.nom);
        Prenom = (EditText) findViewById(R.id.prenom);
        Tel = (EditText) findViewById(R.id.tel);
        Objet = (EditText) findViewById(R.id.objet);
        Reclamation = (EditText) findViewById(R.id.rec);
        Destinataire = (EditText) findViewById(R.id.à);

        this.envoyer = findViewById(R.id.Envoyer);

        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail(); }


            private void sendEmail() {
               String recipientList = Destinataire.getText().toString();
               String[] recipients = recipientList.split(",");

                String subject = Objet.getText().toString();
                String message = Reclamation.getText().toString();
               // String name = Nom.getText().toString();
                //String pre = Prenom.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                //Intent intent = new Intent(Intent.ACTION_SENDTO);
               intent.putExtra(Intent.EXTRA_EMAIL, recipients);
               // intent.setData(Uri.parse("mailto:" + "example@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT,message);
                try {
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email client"));
                 } catch (android.content.ActivityNotFoundException ex) {
                           Toast.makeText(Reclamation.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}
