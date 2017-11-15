package com.os.operando.emptyactivity;

import java.sql.Time;

public class RecentOrdersInfo {
    String favoriteOrder;
    Integer cost;
    Time ordertime;

    public RecentOrdersInfo()
    {}

    public RecentOrdersInfo(String favoriteOrder, Integer cost)
    {
        this.favoriteOrder = favoriteOrder;
        this.cost = cost;
        this.ordertime = ordertime;

    }

    public Time getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Time ordertime) {
        this.ordertime = ordertime;
    }

    public String getFavoriteOrder() {
        return favoriteOrder;
    }

    public void setFavoriteOrder(String favoriteOrder) {
        this.favoriteOrder = favoriteOrder;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
