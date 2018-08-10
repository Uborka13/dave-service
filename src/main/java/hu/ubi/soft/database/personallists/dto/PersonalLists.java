package hu.ubi.soft.database.personallists.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hu.ubi.soft.database.users.dto.Users;

import javax.persistence.*;

@Entity
public class PersonalLists {

    @Id
    @GeneratedValue
    private Long personalListId;
    @ManyToOne
    @JoinColumn(name = "users", nullable = false)
    @JsonBackReference
    private Users users;
    @Column(nullable = false)
    private String personalListName;

    private PersonalLists() {
    }

    public PersonalLists(Users users, String personalListName) {
        this.users = users;
        this.personalListName = personalListName;
    }

    public Long getPersonalListId() {
        return personalListId;
    }

    public void setPersonalListId(Long personalListId) {
        this.personalListId = personalListId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getPersonalListName() {
        return personalListName;
    }

    public void setPersonalListName(String personalListName) {
        this.personalListName = personalListName;
    }

}
