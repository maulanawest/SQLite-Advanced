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

            //Create Table "users"
            //eventsDB.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            //add value table
            //eventsDB.execSQL("INSERT INTO users (name, age) VALUES ('Maulana', 25)");

            //eventsDB.execSQL("INSERT INTO users (name, age) VALUES ('Ahmad', 26)");

            //Query
            //Cursor c = eventsDB.rawQuery("SELECT * FROM users", null);

            //Quesry dengan pengecualian dengan membatasi using WHERE
            // use SELECT * FROM users WHERE name = 'Maulana'
            Cursor c = eventsDB.rawQuery("SELECT * FROM users WHERE name = 'Maulana'", null);

            int nameIndext = c.getColumnIndex("name");
            int ageIndext = c.getColumnIndex("age");

            c.moveToFirst();

            while (c != null)
            {
                Log.i("UserResult - name", c.getString(nameIndext));
                Log.i("UserResult - age", Integer.toString(c.getInt(ageIndext)));

                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
