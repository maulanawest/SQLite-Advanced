package com.redudant.sqliteadvanced;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Create Database "Users"
            SQLiteDatabase eventsDB = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            //new table using ID
            eventsDB.execSQL("CREATE TABLE IF NOT EXISTS newUser (name, VARCHAR, age INTEGER(3), id INTEGER PRIMARY KEY)");

            //Create Table "users"
            //eventsDB.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            //add value table
            //eventsDB.execSQL("INSERT INTO newUser (name, age) VALUES ('Maulana', 25)");

            //eventsDB.execSQL("INSERT INTO newUser (name, age) VALUES ('Ahmad', 26)");

            //delete using name and limit
            //eventsDB.execSQL("DELETE FROM users WHERE name = 'Maulana' LIMIT 1");

            //update
            //eventsDB.execSQL("UPDATE users SET age = 100 WHERE name = 'Ahmad'");

            //delete by name
            //eventsDB.execSQL("DELETE FROM newUser WHERE name = 'Maulana'");

            //delete by id
            eventsDB.execSQL("DELETE FROM newUser WHERE id = 1");

            //Query
            //Cursor c = eventsDB.rawQuery("SELECT * FROM users", null);

            //Quesry dengan pengecualian dengan membatasi using WHERE
            // SELECT * FROM users WHERE name = 'Maulana'
            // "SELECT * FROM users WHERE age > 21"
            Cursor c = eventsDB.rawQuery("SELECT * FROM newUser", null);

            int nameIndext = c.getColumnIndex("name");
            int ageIndext = c.getColumnIndex("age");
            int idIndext = c.getColumnIndex("id");

            c.moveToFirst();

            while (c != null) {
                Log.i("UserResult - name", c.getString(nameIndext));
                Log.i("UserResult - age", Integer.toString(c.getInt(ageIndext)));
                Log.i("UserResult - id", Integer.toString(c.getInt(idIndext)));

                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
