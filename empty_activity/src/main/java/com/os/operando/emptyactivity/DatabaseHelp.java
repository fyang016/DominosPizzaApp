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
    private static final String DATABASE_NAME = "Try2.db";
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
    private static final String KEY_ID = "OrderID";
    private static final String KEY_TOPPING = "Topping";
    private static final String KEY_AMOUNT = "Amount";
    private static final String KEY_TIME = "OrderTime ";
    private static final String CREATE_FAVORDERS_TABLE = "CREATE TABLE Orders(OrderID INT, Email TEXT, Topping TEXT, Amount TEXT" +
            ",OrderTime TIME);";
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

    void addRecentOrders(RecentOrdersInfo recentOrdersInfo,LoginInfo logininfo)
    {
        udbs = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(KEY_ID,recentOrdersInfo.getOrderid());
        val.put(KEY_EMAIL,logininfo.getEmail());
        val.put(KEY_TOPPING,recentOrdersInfo.getTopping());
        val.put(KEY_AMOUNT,recentOrdersInfo.getAmount());
        val.put(KEY_TIME, String.valueOf(recentOrdersInfo.getOrdertime()));

        udbs.insert(TABLE_ORDERS,null,val);
        udbs.close();
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
    }
    public Integer searchID()
    {
        udbs = this.getReadableDatabase();
        String query = "SELECT MAX("+ KEY_ID +") FROM " + TABLE_ORDERS;
        Cursor cursor = udbs.rawQuery(query, null);
        Integer ID;
        ID = 0;
        if(cursor.moveToFirst())
        {
            do{
                ID=cursor.getInt(0);
            }while(cursor.moveToNext());
        }
        return ID;
    }
    public String searchTopp(String email)
    {
        udbs = this.getReadableDatabase();
        String query = "SELECT Topping FROM " + TABLE_ORDERS +" WHERE email = '" + email +"'";
       Cursor cursor = udbs.rawQuery(query,null);
        String top = "";
        if(cursor.moveToFirst())
        {
            do{
                top += cursor.getString(0);
                top += "\n";
            }while (cursor.moveToNext());
        }
        return top;
    }
    //RC created to check password
    public String searchPass(String email)
    {

        udbs = this.getReadableDatabase();
        String query = "select email, password from "+TABLE_USERS;
        Cursor cursor = udbs.rawQuery(query, null);
        //e - for email p - password
        String e, p;
        p = "Password Not Found";
        if (cursor.moveToFirst())
        {
            do{
                e = cursor.getString(0);
                p = cursor.getString(1);

                if (e.equals(email))
                {

                    p = cursor.getString(1);
                    break;
                }


            }
            while(cursor.moveToNext());
        }

        return p;

    }

    public void UpdatePass(String email, String password){
//



        udbs = this.getWritableDatabase();
        String TABLE = TABLE_USERS;
        String SET = "set password = '"+password + "'";
        String EMAIL = " where email = '"+email + "'";
        String query = "update "+ TABLE + SET + EMAIL;
        udbs.execSQL(query);

    }

    /*public boolean emailExist(String email) {
        udbs = this.getReadableDatabase();
        String query = "SELECT * where email = '" + email + "'";
        Cursor cursor = udbs.rawQuery(query, null);
        //e - for email p - password
        String emailbool;
        emailbool = "";
        if (cursor.moveToFirst()) {
            do {
                emailbool = cursor.getString(0);
            }
            while (cursor.moveToNext());
        }
        if (emailbool.equals("")) {
            return false;
        }
        return true;
    }*/
    /*



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
