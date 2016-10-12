package be.david.contactsselection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContactIntentActivity extends AppCompatActivity {

    private final int PHONE = 0;

    private final int WEBSITE = 1;

    private ListView listView;

    private ArrayAdapter<String> adapter;

    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_intent);

        listView = (ListView) findViewById(R.id.listView1);

        contacts = new ArrayList<>();

        contacts.add(new Contact("Android One","111-1111-1111","www.androidATC.com"));
        contacts.add(new Contact("Android Two","222-2222-2222","www.google.com"));
        contacts.add(new Contact("Android Three","333-3333-3333","www.realdolmen.com"));
        contacts.add(new Contact("Android Four","444-4444-4444","www.pokemon.com"));

        List<String> listName = new ArrayList<>();




    }


}
