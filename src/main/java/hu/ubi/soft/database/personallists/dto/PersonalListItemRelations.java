package hu.ubi.soft.database.personallists.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonalListItemRelations {

    @Id
    @GeneratedValue
    private Long relationId;
    private Long personalListId;
    private Long beerItemId;

    private PersonalListItemRelations() {
    }

    public PersonalListItemRelations(Long personalListId, Long beerItemId) {
        this.personalListId = personalListId;
        this.beerItemId = beerItemId;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getPersonalListId() {
        return personalListId;
    }

    public void setPersonalListId(Long personalListId) {
        this.personalListId = personalListId;
    }

    public Long getBeerItemId() {
        return beerItemId;
    }

    public void setBeerItemId(Long beerItemId) {
        this.beerItemId = beerItemId;
    }
}
