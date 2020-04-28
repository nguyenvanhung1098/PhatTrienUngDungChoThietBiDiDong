package com.example.mygmail;

import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mygmail.adapters.EmailAdapter;
import com.example.mygmail.models.EmailModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<EmailModel> items;
    List<EmailModel> list_old;
    private EditText textSearch;
    private Button btnFavorite;
    private ListView listView;
    Boolean viewFavorite = false;
    EmailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        items.add(new EmailModel("Piter", "Hello. My name is Piter.","what your name?","12:00AM"));
        items.add(new EmailModel("Alice", "Hello. My name is Alice.","what your name?","12:05AM"));
        items.add(new EmailModel("Doremon", "Hello. My name is Doremon.","what your name?","12:10AM"));
        items.add(new EmailModel("Nobita", "Hello.  My name is Nobita.","what your name?","12:15AM"));
        items.add(new EmailModel("Sasuke", "Hello. My name is Sasuke.","what your name?","12:20AM"));
        items.add(new EmailModel("Naruto", "Hello. My name is Naruto.","what your name?","12:25AM"));
        items.add(new EmailModel("Luffy", "Hello. My name is Luffy.","what your name?","12:30AM"));
        items.add(new EmailModel("Sakura", "Hello. My name is Sakura.","what your name?","12:35AM"));
        items.add(new EmailModel("Kakashi", "Hello. My name is Kakashi.","what your name?","12:40AM"));
        items.add(new EmailModel("Itachi", "Hello. My name is Itachi.","what your name?","12:45AM"));
        items.add(new EmailModel("Bob", "Hello. My name is Bob.","what your name?","12:50AM"));
        items.add(new EmailModel("Minato", "Hello. My name is Minato.","what your name?","12:55AM"));
        items.add(new EmailModel("Lee", "Hello. My name is Lee.","what your name?","13:00AM"));
        items.add(new EmailModel("Nami", "Hello. My name is Nami.","what your name?","13:05AM"));
        items.add(new EmailModel("Zoro", "Hello. My name is Zoro.","what your name?","13:10AM"));
        items.add(new EmailModel("Sanji", "Hello. My name is Sanji.","what your name?","13:15AM"));

        list_old = new ArrayList<>();
        adapter = new EmailAdapter(items);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        list_old.clear();
        list_old.addAll(items);
        textSearch = (EditText)findViewById(R.id.text_search);
        listView = (ListView)findViewById(R.id.list_view);
        btnFavorite = (Button)findViewById(R.id.btnFavorite);
        btnFavorite.setBackgroundColor(0xA9A9A9A9);
        textSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length() < 3){
                    adapter = new EmailAdapter(list_old);
                    listView = findViewById(R.id.list_view);
                    listView.setAdapter(adapter);
                }
                else{
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFavorite = !viewFavorite;
                if(viewFavorite == true)
                    btnFavorite.setBackgroundColor(0xFAEBD7D7);
                if(viewFavorite == false)
                    btnFavorite.setBackgroundColor(0xA9A9A9A9);
                searchItem(textSearch.getText().toString());
            }
        });
    }


    public void searchItem (String textToSearch){
        List<EmailModel> listItems ;
        listItems = new ArrayList<>();
        list_old.clear();
        list_old.addAll(items);
        try {
            if(viewFavorite)
                for (EmailModel item : items) {
                    if (item.searchItemFavorite(textToSearch)) {
                        listItems.add(item);
                    }
                }
            else
                for (EmailModel item : items) {
                    if (item.searchItem(textToSearch)) {
                        listItems.add(item);
                    }
                }

            adapter = new EmailAdapter(listItems);
            listView = findViewById(R.id.list_view);
            listView.setAdapter(adapter);
            //adapter.notifyDataSetChanged();
        }catch (Exception e){
            //Log.d(TAG, "Exception:" + e + "");
        }
    }


}
