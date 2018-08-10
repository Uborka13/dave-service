package hu.ubi.soft.database.users.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hu.ubi.soft.database.personallists.dto.PersonalLists;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private Long userId;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<PersonalLists> personalLists = new HashSet<>();

    private Users() {
    }

    public Users(final String userName, final String email) {
        this.userName = userName;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<PersonalLists> getPersonalLists() {
        return personalLists;
    }

    public void setPersonalLists(Set<PersonalLists> personalLists) {
        this.personalLists = personalLists;
    }
}
