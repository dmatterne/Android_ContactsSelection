package be.david.contactsselection;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

        contacts.add(new Contact("Android One", "111-1111-1111", "www.androidATC.com"));
        contacts.add(new Contact("Android Two", "222-2222-2222", "www.google.com"));
        contacts.add(new Contact("Android Three", "333-3333-3333", "www.realdolmen.com"));
        contacts.add(new Contact("Android Four", "444-4444-4444", "www.pokemon.com"));

        List<String> listName = new ArrayList<>();

        for (int i = 0; i < contacts.size(); i++) {

            listName.add(contacts.get(i).getName());

        }

        Log.d("Contacts", "" + listName.toString());

        adapter = new ArrayAdapter<>(ContactIntentActivity.this, android.R.layout.simple_list_item_1, listName);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ContactIntentActivity.this, ContactPageActivity.class);
                i.putExtra("Object", contacts.get(position));

                startActivityForResult(i, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) {
            return;
        }
        Bundle resultData = data.getExtras();
        String value = resultData.getString("value");

        switch (resultCode) {

            case PHONE:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
//                        ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CALL_PHONE},0);
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + value)));
                break;

            case WEBSITE:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + value)));
                break;

        }




    }
}
