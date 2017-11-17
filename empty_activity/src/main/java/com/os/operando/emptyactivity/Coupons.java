package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Coupons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);
    }

    public void gotoCoupons(View view)
    {
        startActivity(new Intent(getApplicationContext(),Coupons.class));
    }
    public void gotoPC(View view)
    {
        startActivity(new Intent(getApplicationContext(),preCheckout.class));
    }
    public void CouponOne (View view)
    {
        Intent CurInt = getIntent();
        Bundle CouponBundle = CurInt.getExtras();
        CouponBundle.remove("MinusFive");
        Intent PC_intent = new Intent(getApplicationContext(),preCheckout.class);
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        ArrayList<String> Coupon = new ArrayList<String>();
        Coupon.add("Minus 5");
        CouponBundle.putSerializable("MinusFive", Coupon );
        CouponBundle.putSerializable("UserInformation", UserInformation);
        PC_intent.putExtras(CouponBundle);
        startActivity(PC_intent);
    }
}
