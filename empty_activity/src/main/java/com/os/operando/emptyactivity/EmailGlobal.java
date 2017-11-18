package com.os.operando.emptyactivity;


import android.app.Application;


public class EmailGlobal extends Application {
r
    private String uemail;

    public String getUemail()
    {
        return uemail;
    }
    public void setUemail(String uemail)
    {
        this.uemail=uemail;
    }

}
