package com.simona.dictionarr1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText inputET, searchET;
    Button addbtn, searchBtn;
    ArrayList<Wordd> dictionar;
    private RecyclerView rv;
    AdapterWord wordAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    public void addWordToDictionary(View v) {
        try {
            String currentWord = inputET.getText().toString().trim();
            if (currentWord != null) {
                dictionar.add(new Wordd(currentWord));
                inputET.setText(null);
                wordAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchForWordinDictionary(View v) {
        try {
            String currentWord = searchET.getText().toString().trim();
            if (currentWord != null) {
                boolean foundInDictionary = false;
                for (Wordd w : dictionar) {
                    if (w.getWordd().equalsIgnoreCase(currentWord)) {
                        foundInDictionary = true;
                        break;
                    }
                }
                if (foundInDictionary) {
                    Toast.makeText(this, currentWord + " este in dictionar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, currentWord + " NU este in dictionar", Toast.LENGTH_SHORT).show();
                }
                hidekeyboard();
                searchET.setText(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void hidekeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchET.getWindowToken(), 0);
    }

    void initViews() {
        inputET = findViewById(R.id.inputEditText);
        searchET = findViewById(R.id.searchEditText);
        addbtn = findViewById(R.id.addButton);
        searchBtn = findViewById(R.id.searchButton);
        dictionar = new ArrayList<>();
        rv = findViewById(R.id.listWordsRV);
        wordAdapter = new AdapterWord(this, dictionar);
        rv.setAdapter(wordAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));
    }

}