package com.example.itsolutiontest;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fetchdata extends AppCompatActivity {
private Button addbtn;
    RecyclerView recyclerView;
    ArrayList<model> dataholder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fetchdata);

        addbtn=findViewById(R.id.addbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(fetchdata.this,MainActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbmanager manager = new dbmanager(this);
        Cursor cursor = manager.readAllData();
        dataholder = new ArrayList<>();

        while (cursor.moveToNext()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String memberMobileNumber = cursor.getString(cursor.getColumnIndex("member_mobile_number"));
            @SuppressLint("Range") String contact = cursor.getString(cursor.getColumnIndex("contact"));
            @SuppressLint("Range") String role = cursor.getString(cursor.getColumnIndex("role"));
            @SuppressLint("Range") String subscriptionFee = cursor.getString(cursor.getColumnIndex("subscription_fee"));
            @SuppressLint("Range")  String depositAmount = cursor.getString(cursor.getColumnIndex("deposit_amount"));
            @SuppressLint("Range")   String loanAmount = cursor.getString(cursor.getColumnIndex("loan_amount"));
            @SuppressLint("Range")   String gender = cursor.getString(cursor.getColumnIndex("gender"));
            @SuppressLint("Range") String dateOfBirth = cursor.getString(cursor.getColumnIndex("date_of_birth"));
            @SuppressLint("Range")   String dateOfJoining = cursor.getString(cursor.getColumnIndex("date_of_joining"));
            @SuppressLint("Range")   String maritalStatus = cursor.getString(cursor.getColumnIndex("marital_status"));
            @SuppressLint("Range")  String dateOfMarriage = cursor.getString(cursor.getColumnIndex("date_of_marriage"));
            @SuppressLint("Range") String caste = cursor.getString(cursor.getColumnIndex("caste"));
            @SuppressLint("Range")   String religion = cursor.getString(cursor.getColumnIndex("religion"));
            @SuppressLint("Range")  String category = cursor.getString(cursor.getColumnIndex("category"));
            @SuppressLint("Range")  String aadharNo = cursor.getString(cursor.getColumnIndex("aadhar_no"));

            model obj = new model(memberMobileNumber, contact, role, subscriptionFee,
                    depositAmount, loanAmount, gender, dateOfBirth, dateOfJoining,
                    maritalStatus, dateOfMarriage, caste, religion, category, aadharNo);

            dataholder.add(obj);
        }

        myadapter adapter = new myadapter(dataholder);
        recyclerView.setAdapter(adapter);
    }
}
