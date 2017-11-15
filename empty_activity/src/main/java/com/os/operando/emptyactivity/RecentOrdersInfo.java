package com.os.operando.emptyactivity;

public class RecentOrdersInfo {
    String favoriteOrder;
    Integer cost;

    public RecentOrdersInfo()
    {}

    public RecentOrdersInfo(String favoriteOrder, Integer cost)
    {
        this.favoriteOrder = favoriteOrder;
        this.cost = cost;

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
