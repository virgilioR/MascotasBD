package com.virgilio.mascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Contacto extends AppCompatActivity {

    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    GMailSender sender = new GMailSender("correo", "pass");
                    sender.sendMail("This is Subject",
                            "This is Body",
                            "sender",
                            "recipients");
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });
    }


}