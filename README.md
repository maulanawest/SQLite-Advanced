# SQLite-Advanced

### Query
"SELECT * FROM users"

![Screen Shot 2019-05-21 at 21 12 53](https://user-images.githubusercontent.com/43386555/58103580-686e7800-7c0d-11e9-91f1-d4c6f4a34d1a.png)

### Query WHERE age < 18
"SELECT * FROM users WHERE age < 18"

### Query WHERE name =
"SELECT * FROM users WHERE name = 'Maulana'"
![Screen Shot 2019-05-21 at 21 01 10](https://user-images.githubusercontent.com/43386555/58102975-60fa9f00-7c0c-11e9-902a-5b4bc69b9ab8.png)

### Query WHERE combine AND
"SELECT * FROM users WHERE name = 'Maulana' AND age 25"
![Screen Shot 2019-05-21 at 21 23 23](https://user-images.githubusercontent.com/43386555/58104241-aae48480-7c0e-11e9-97ec-372d17df8a2d.png)

### Query WHERE get a username by the prefix M name LIKE 'M%'
"SELECT * FROM users WHERE name LIKE 'M%'"
![Screen Shot 2019-05-21 at 21 26 44](https://user-images.githubusercontent.com/43386555/58104539-20e8eb80-7c0f-11e9-9d7d-082d7ddca1d8.png)

### %d% = get a username with several criteria with letter (d)
"SELECT * FROM users WHERE name LIKE '%d%'"

![Screen Shot 2019-05-21 at 21 35 44](https://user-images.githubusercontent.com/43386555/58105258-622dcb00-7c10-11e9-88d0-3e12ff2b8fd4.png)

### LIMIT hanya satu yang di print
"SELECT * FROM users WHERE name LIKE '%d%' LIMIT 1"
![Screen Shot 2019-05-21 at 21 35 44](https://user-images.githubusercontent.com/43386555/58105258-622dcb00-7c10-11e9-88d0-3e12ff2b8fd4.png)

### delete using name and limit
"DELETE FROM users WHERE name = 'Maulana' LIMIT 1"
eventsDB.execSQL("DELETE FROM users WHERE name = 'Maulana'");

### UPDATE
"UPDATE users SET age = 100 WHERE name = 'Ahmad'"
eventsDB.execSQL("UPDATE users SET age = 100 WHERE name = 'Ahmad'");

![Screen Shot 2019-05-21 at 22 16 28](https://user-images.githubusercontent.com/43386555/58108468-18e07a00-7c16-11e9-9b60-e6c15b1ba9fc.png)

### DELETE using name
"DELETE FROM users WHERE name = 'Maulana'"
eventsDB.execSQL("DELETE FROM users WHERE name = 'Maulana'");
![Screen Shot 2019-05-21 at 22 20 48](https://user-images.githubusercontent.com/43386555/58108833-bc318f00-7c16-11e9-8f9d-e1d5ae464167.png)

DELETE menggunakan LIMIT tidak di anjurkan yang di anjurkan menggunakan ID
      
      try
      {
     //Create Database "Users"
     SQLiteDatabase eventsDB = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
     
    //new table using ID
     eventsDB.execSQL("CREATE TABLE IF NOT EXISTS newUser (name, VARCHAR, age INTEGER(3), id INTEGER PRIMARY KEY)");

    //add value table
    eventsDB.execSQL("INSERT INTO newUser (name, age) VALUES ('Maulana', 25)");

    eventsDB.execSQL("INSERT INTO newUser (name, age) VALUES ('Ahmad', 26)");

    //Query
    Cursor c = eventsDB.rawQuery("SELECT * FROM users", null);
    
            int nameIndext = c.getColumnIndex("name");
            int ageIndext = c.getColumnIndex("age");
            int idIndext = c.getColumnIndex("id");

            c.moveToFirst();

            while (c != null)
            {
                Log.i("UserResult - name", c.getString(nameIndext));
                Log.i("UserResult - age", Integer.toString(c.getInt(ageIndext)));
                Log.i("UserResult - id", Integer.toString(c.getInt(idIndext)));
                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
![Screen Shot 2019-05-21 at 22 33 46](https://user-images.githubusercontent.com/43386555/58109809-7e356a80-7c18-11e9-8107-7a12686ccb99.png)

### DELETE by ID
"DELETE FROM newUser WHERE id = 1"
eventsDB.execSQL("DELETE FROM newUser WHERE id = 1");

![Screen Shot 2019-05-21 at 22 37 32](https://user-images.githubusercontent.com/43386555/58110076-074ca180-7c19-11e9-936e-6b3587e093e4.png)

### Source
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
