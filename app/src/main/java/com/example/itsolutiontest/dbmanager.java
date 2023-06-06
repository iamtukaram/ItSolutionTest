package com.example.itsolutiontest;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbmanager extends SQLiteOpenHelper {
    private static final String dbname = "dbcontact";

    public dbmanager(Context context) {
        super(context, dbname, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "CREATE TABLE tbl_contact (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "member_mobile_number TEXT, contact TEXT, role TEXT, subscription_fee TEXT, " +
                "deposit_amount TEXT, loan_amount TEXT, gender TEXT, date_of_birth TEXT, " +
                "date_of_joining TEXT, marital_status TEXT, date_of_marriage TEXT, " +
                "caste TEXT, religion TEXT, category TEXT, aadhar_no TEXT)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry = "DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public String addRecord(String memberMobileNumber, String contact, String role,
                            String subscriptionFee, String depositAmount, String loanAmount,
                            String gender, String dateOfBirth, String dateOfJoining,
                            String maritalStatus, String dateOfMarriage, String caste,
                            String religion, String category, String aadharNo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("member_mobile_number", memberMobileNumber);
        cv.put("contact", contact);
        cv.put("role", role);
        cv.put("subscription_fee", subscriptionFee);
        cv.put("deposit_amount", depositAmount);
        cv.put("loan_amount", loanAmount);
        cv.put("gender", gender);
        cv.put("date_of_birth", dateOfBirth);
        cv.put("date_of_joining", dateOfJoining);
        cv.put("marital_status", maritalStatus);
        cv.put("date_of_marriage", dateOfMarriage);
        cv.put("caste", caste);
        cv.put("religion", religion);
        cv.put("category", category);
        cv.put("aadhar_no", aadharNo);

        long res = db.insert("tbl_contact", null, cv);

        if (res == -1)
            return "Failed";
        else
            return "Successfully inserted";
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "SELECT * FROM tbl_contact ORDER BY id DESC";
        return db.rawQuery(qry, null);
    }


}
