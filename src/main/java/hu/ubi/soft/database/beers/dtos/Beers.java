package hu.ubi.soft.database.beers.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Beers {

    @Id
    @GeneratedValue
    private Long beerId;
    @Column(nullable = false)
    private String beerName;
    private Integer price;
    private Double rating;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "beerTypes", nullable = false)
    private BeerTypes beerTypes;

    private Beers() {
    }

    public Beers(String beerName, Integer price, Double rating) {
        this.beerName = beerName;
        this.price = price;
        this.rating = rating;
    }

    public BeerTypes getBeerTypes() {
        return beerTypes;
    }

    public void setBeerTypes(BeerTypes beerTypes) {
        this.beerTypes = beerTypes;
    }

    public Long getBeerId() {
        return beerId;
    }

    public void setBeerId(Long beerId) {

        this.beerId = beerId;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

}
