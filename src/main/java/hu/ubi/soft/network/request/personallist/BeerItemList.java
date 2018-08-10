package hu.ubi.soft.network.request.personallist;

import java.util.List;

public class BeerItemList {

    private List<BeerItem> beerItemList;

    public BeerItemList(List<BeerItem> beerItemList) {
        this.beerItemList = beerItemList;
    }

    public List<BeerItem> getBeerItemList() {
        return beerItemList;
    }

    public void setBeerItemList(List<BeerItem> beerItemList) {
        this.beerItemList = beerItemList;
    }
}
