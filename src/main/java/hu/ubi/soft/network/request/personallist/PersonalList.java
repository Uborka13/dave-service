package hu.ubi.soft.network.request.personallist;

public class PersonalList {

    private String listName;

    private PersonalList() {
    }

    public PersonalList(String listName) {
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
