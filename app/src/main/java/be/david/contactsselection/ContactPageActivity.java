package be.david.contactsselection;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class ContactPageActivity extends AppCompatActivity implements View.OnClickListener {

    private final int PHONE = 0;

    private final int WEBSITE = 1;

    private TextView contactName;
    private TextView contactPhone;
    private TextView contactWebsite;

    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        contactName = (TextView) findViewById(R.id.contactName);
        contactPhone = (TextView) findViewById(R.id.contactPhone);
        contactWebsite = (TextView) findViewById(R.id.contactWebsite);

        Bundle extras = getIntent().getExtras();

        if (extras == null) {

            return;

        }

//        contact = (Contact) extras.getSerializable("Object");

        contact = (Contact) getIntent().getSerializableExtra("Object");

        contactName.setText(contact.getName());
        contactPhone.setText("Phone:" +contact.getPhone());
        contactWebsite.setText("Website:" +contact.getWebsite());

        contactPhone.setOnClickListener(this);
        contactWebsite.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        Intent i = new Intent();

        switch (v.getId()) {

            case R.id.contactPhone:
                i.putExtra("value",contact.getPhone());
                setResult(PHONE,i);
                finish();
                break;
            case R.id.contactWebsite:
                i.putExtra("value",contact.getWebsite());
                setResult(WEBSITE,i);
                finish();
                break;

        }
    }
}
