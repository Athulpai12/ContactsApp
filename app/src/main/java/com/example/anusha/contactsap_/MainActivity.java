package com.example.anusha.contactsap_;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Button contactAddButton;
    ListView listContacts;

    ArrayList<Contacts> arrayListContact;
    ContactsAdapter contactAdapter;
    Contacts contacts;

    final int View1 = 1, Delete1 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListContact = new ArrayList<Contacts>();

        listContacts = (ListView) findViewById(R.id.listView);

        contactAddButton = (Button) findViewById(R.id.contactAddButton);


        contactAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Data.class);
                startActivityForResult(intent, 1);


            }
        });

        contactAdapter = new ContactsAdapter(MainActivity.this, arrayListContact);

        listContacts.setAdapter(contactAdapter);

        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                registerForContextMenu(listContacts);

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.listView) {
            menu.add(0, View1, 1, "View");
            menu.add(0, Delete1, 2, "Delete");

        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case View1:

                Intent intent6 = new Intent(MainActivity.this, ContactDetail.class);
                AdapterView.AdapterContextMenuInfo info1 = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int index1 = info1.position;

                intent6.putExtra("details", arrayListContact.get(index1));

                startActivity(intent6);

                break;

            case Delete1:
                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();

                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int index = info.position;

                Log.e("index", index + " ");
                arrayListContact.remove(index);
                contactAdapter.notifyDataSetChanged();

                break;

        }
        return true;


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == 2) {

            contacts = (Contacts) data.getSerializableExtra("data");

            arrayListContact.add(contacts);
            contactAdapter.notifyDataSetChanged();
        }


    }
}