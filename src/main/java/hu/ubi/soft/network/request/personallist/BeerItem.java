package hu.ubi.soft.network.request.personallist;

public class BeerItem {

    private Long beerItemId;

    public BeerItem(Long beerItemId) {
        this.beerItemId = beerItemId;
    }

    public Long getBeerItemId() {
        return beerItemId;
    }

    public void setBeerItemId(Long beerItemId) {
        this.beerItemId = beerItemId;
    }
}
