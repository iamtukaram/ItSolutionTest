package com.example.itsolutiontest;






import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText memberNameEditText;
    private EditText mobileNumberEditText;
    private RadioGroup roleRadioGroup;
    private EditText subscriptionFeeEditText;
    private EditText depositAmountEditText;
    private EditText loanAmountEditText;
    private RadioGroup genderRadioGroup;
    private EditText dobEditText;
    private EditText dateOfJoiningEditText;
    private RadioGroup maritalStatusRadioGroup;
    private EditText dateOfMarriageEditText;
    private EditText casteEditText;
    private EditText categoryEditText;
    private EditText aadharNoEditText;
    private Button submitButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        memberNameEditText = findViewById(R.id.memberNameEditText);
        mobileNumberEditText = findViewById(R.id.mobileNumberEditText);
        roleRadioGroup = findViewById(R.id.roleRadioGroup);
        subscriptionFeeEditText = findViewById(R.id.subscriptionFeeEditText);
        depositAmountEditText = findViewById(R.id.depositAmountEditText);
        loanAmountEditText = findViewById(R.id.loanAmountEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        dobEditText = findViewById(R.id.dobEditText);
        dateOfJoiningEditText = findViewById(R.id.dateOfJoiningEditText);
        maritalStatusRadioGroup = findViewById(R.id.maritalStatusRadioGroup);
        dateOfMarriageEditText = findViewById(R.id.dateOfMarriageEditText);
        casteEditText = findViewById(R.id.casteEditText);
        categoryEditText = findViewById(R.id.categoryEditText);
        aadharNoEditText = findViewById(R.id.aadharNoEditText);
        submitButton = findViewById(R.id.submitButton);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String memberName = memberNameEditText.getText().toString();
                String mobileNumber = mobileNumberEditText.getText().toString();
                String loanAmount = loanAmountEditText.getText().toString();
                String subscriptionFee = subscriptionFeeEditText.getText().toString();
                String depositAmount = depositAmountEditText.getText().toString();
                String gender = getSelectedGender();
                String dateOfBirth = dobEditText.getText().toString();
                String dateOfJoining = dateOfJoiningEditText.getText().toString();
                String maritalStatus = getSelectedMaritalStatus();
                String dateOfMarriage = dateOfMarriageEditText.getText().toString();
                String caste = casteEditText.getText().toString();
                String category = categoryEditText.getText().toString();
                String aadharNo = aadharNoEditText.getText().toString();

                // Get the selected role from the radio group
                String selectedRole = getSelectedRole();

                // Create an instance of the Member class using the entered values
                model member = new model (
                        memberName, mobileNumber, selectedRole, subscriptionFee, depositAmount, loanAmount,
                        gender, dateOfBirth, dateOfJoining, maritalStatus, dateOfMarriage, caste, category, aadharNo,
                        aadharNo);

                // Perform further processing or save the member object
                processInsert(member);
                startActivity(new Intent(getApplicationContext(), fetchdata.class));
            }
        });
    }

    private void processInsert(model member) {
        dbmanager manager = new dbmanager(this);
        String res = manager.addRecord(member.getMemberMobileNumber(),member.getContact(),member.getRole(),member.getSubscriptionFee(),
                member.getDepositAmount(),member.getLoanAmount(),member.getGender(),member.getDateOfBirth(),member.getDateOfJoining(),member.getMaritalStatus(),member.getDateOfMarriage(),member.getCaste(),member.getReligion(),member.getCategory(),member.getAadharNo());
        // Add the member
        // Clear the input fields
        memberNameEditText.setText("");
        mobileNumberEditText.setText("");
        loanAmountEditText.setText("");
        subscriptionFeeEditText.setText("");
        depositAmountEditText.setText("");
        dobEditText.setText("");
        dateOfJoiningEditText.setText("");
        dateOfMarriageEditText.setText("");
        casteEditText.setText("");
        categoryEditText.setText("");
        aadharNoEditText.setText("");

        Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
    }

    private String getSelectedRole() {
        int selectedId = roleRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        if (selectedRadioButton != null) {
            return selectedRadioButton.getText().toString();
        } else {
            return "";
        }
    }

    private String getSelectedGender() {
        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        if (selectedRadioButton != null) {
            return selectedRadioButton.getText().toString();
        } else {
            return "";
        }
    }

    private String getSelectedMaritalStatus() {
        int selectedId = maritalStatusRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        if (selectedRadioButton != null) {
            return selectedRadioButton.getText().toString();
        } else {
            return "";
        }
    }
}