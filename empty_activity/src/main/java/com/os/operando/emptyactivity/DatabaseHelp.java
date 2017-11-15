package com.os.operando.emptyactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelp extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserInfo.db";
    private static final String TABLE_USERS = "Users ";
    private static final String KEY_EMAIL = "Email ";
    private static final String KEY_PASS = "Password ";
    private static final String KEY_FIRST = "FirstName ";
    private static final String KEY_LAST = "LastName ";
    private static final String KEY_PHONENO = "PhoneNumber ";
    private static final String CREATE_USERS_TABLE = "CREATE TABLE Users(Email TEXT Primary Key NOT NULL" +
            ", Password TEXT NOT NULL, FirstName TEXT NOT NULL, LastName TEXT NOT NULL," +
            " PhoneNumber TEXT NOT NULL); ";

    private static final String TABLE_ORDERS = "Orders";
    private static final String KEY_FAVORDERS = "FavoriteOrder";
    private static final String KEY_COST = "Cost";
    private static final String CREATE_FAVORDERS_TABLE = "CREATE TABLE " + TABLE_ORDERS +" (" + KEY_EMAIL +
            " TEXT FOREIGN KEY NOT NULL, " + KEY_FAVORDERS + "TEXT ," + KEY_COST + " INT);";
    SQLiteDatabase udbs;

    public DatabaseHelp(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase udbs) {
        udbs.execSQL(CREATE_USERS_TABLE);
        udbs.execSQL(CREATE_FAVORDERS_TABLE);
        this.udbs = udbs;
    }

    @Override
    public void onUpgrade(SQLiteDatabase udbs, int i, int i1) {
        String drop = "DROP TABLE IF EXISTS" + TABLE_USERS;
        udbs.execSQL(drop);
        this.onCreate(udbs);

    }

    void addUsers(LoginInfo logininfo)
    {
        udbs = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(KEY_EMAIL,logininfo.getEmail());
        val.put(KEY_PASS,logininfo.getPassword());
        val.put(KEY_FIRST,logininfo.getFirstName());
        val.put(KEY_LAST,logininfo.getLastName());
        val.put(KEY_PHONENO,logininfo.getPhoneNumber());

        udbs.insert(TABLE_USERS,null,val);
        udbs.close();
    }

    void addRecentOrders(RecentOrdersInfo recentOrdersInfo)
    {
        
    }
    public LoginInfo readUsers()
    {
        udbs = this.getReadableDatabase();

        Cursor cursor = udbs.query(TABLE_USERS, new String[]{KEY_EMAIL,KEY_PASS,KEY_FIRST,KEY_LAST,KEY_PHONENO},
               null,null,null,null,null,null);

        if(cursor != null)
        {
            cursor.moveToFirst();
        }

        LoginInfo logininfo = new LoginInfo(cursor.getString(0), cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));

        return logininfo;
    }

    public List<LoginInfo> allUsers()
    {
        List<LoginInfo> loginInfoList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase dbs = this.getWritableDatabase();
        Cursor cursor = dbs.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do{
                LoginInfo logininfo = new LoginInfo();

                logininfo.setEmail(cursor.getString(0));
                logininfo.setPassword(cursor.getString(1));
                logininfo.setFirstName(cursor.getString(2));
                logininfo.setLastName(cursor.getString(3));
                logininfo.setPhoneNumber(cursor.getString(4));

                loginInfoList.add(logininfo);
            }while (cursor.moveToNext());


        }
        return loginInfoList;
    }/*
    public int updatedUser(LoginInfo logininfo)
    {
        SQLiteDatabase dbs = this.getWritableDatabase();
        ContentValues vals = new ContentValues();
        vals.put(KEY_EMAIL,logininfo.getEmail());
        vals.put(KEY_PASS,logininfo.getPassword());

        return dbs.update(TABLE_USERS, vals,KEY_EMAIL,new String[]{logininfo.getEmail()});
    }

    public void deleteUsers(LoginInfo logininfo)
    {
        SQLiteDatabase dbs = this.getWritableDatabase();
        dbs.delete(TABLE_USERS,KEY_EMAIL,new String[]{logininfo.getEmail()});
        dbs.close();
    }
*/
}
