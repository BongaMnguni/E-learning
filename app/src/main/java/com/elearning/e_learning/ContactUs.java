package com.elearning.e_learning;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class ContactUs extends AppCompatActivity {
    AppCompatButton btnContact;
    EditText number,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        btnContact = (AppCompatButton)findViewById(R.id.btnContact);
        number = (EditText)findViewById(R.id.number);
        message = (EditText)findViewById(R.id.message);

        ArrayList<String> arrayList = new ArrayList<>();
         final String emails []=new String[5];
        emails[0] ="Audrey.Ngcobo@kzndoe.gov.za";
        emails[1] ="thammy202@gmail.com";

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "zanibuthelezi@yahoo.com;busisiwe.dladla@kzndoe.gov.za;thabisa.dumisa@kzndoe.gov.za;muzi.mahlambi@kzndoe.gov.za;themba.mchunu@kzndoe.gov.za;", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "KZN DoE Support");
                intent.putExtra(Intent.EXTRA_TEXT, "Number :\t"+number.getText().toString()+"\n \n "+message.getText().toString());
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });


    }
}
