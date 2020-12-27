package com.bunoza.domagoj.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickListener {

    private RecyclerView  recycler;
    private RecyclerAdapter adapter;
    private EditText editText;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        setupRecyclerData();
        initializeUI();
    }

    private void initializeUI(){
        editText = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEditTextEmpty()){
                addCell();
                }else{
                    Toast.makeText(MainActivity.this,"Unesite ime!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupRecycler(){
        recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this);
        recycler.setAdapter(adapter);
    }

    private void setupRecyclerData(){
        List<String> data = new ArrayList<>();
        data.add(getString(R.string.domagoj));

        adapter.addData(data);
    }

    public void addCell(){
        adapter.addNewCell(editText.getText().toString(), adapter.getItemCount());
        emptyEditText();
    }

    public void removeCell(int position){
        adapter.removeCell(position);
    }

    @Override
    public void onNameClick(int position) {
        Toast.makeText(this, "Position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onButtonClick(int position) {
        removeCell(position);
    }

    public void emptyEditText(){
        editText.setText("");
    }
    public boolean isEditTextEmpty(){
        return editText.getText().toString().trim().length() == 0;
    }
}