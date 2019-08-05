package com.example.iptvsmarterspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button tv;
    private Button contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            this.tv =  findViewById(R.id.tv);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), TvEnDirect.class);
                startActivity(otherActivity);
                finish();
            }
        });
                this.contact =  findViewById(R.id.contact);

                contact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent otherActivity2 = new Intent(getApplicationContext(), Reclamation.class);
                        startActivity(otherActivity2);
                        finish();
            }
        });
    }
}
