package com.os.operando.emptyactivity;

import java.sql.Time;

public class RecentOrdersInfo {
    Integer orderid;
    String email;
    String topping;
    String amount;
    Integer cost;
    Time ordertime;

    public RecentOrdersInfo()
    {}

    public RecentOrdersInfo(Integer orderid,String email,String topping, String amount, Integer cost,Time ordertime)
    {
        this.orderid = orderid;
        this.email = email;
        this.topping = topping;
        this.amount = amount;
        this.cost = cost;
        this.ordertime = ordertime;

    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Time getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Time ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
