package hu.ubi.soft.database.beers.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BeerTypes {

    @Id
    @GeneratedValue
    private Long beerTypeId;
    @Column(nullable = false)
    private String name;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beerTypes", fetch = FetchType.EAGER)
    private Set<Beers> beers = new HashSet<>();

    private BeerTypes() {
    }

    public BeerTypes(String name) {
        this.name = name;
    }

    public Long getBeerTypeId() {
        return beerTypeId;
    }

    public void setBeerTypeId(Long beerTypeId) {
        this.beerTypeId = beerTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Beers> getBeers() {
        return beers;
    }

    public void setBeers(Set<Beers> beers) {
        this.beers = beers;
    }
}
