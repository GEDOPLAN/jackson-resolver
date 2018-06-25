package de.gedoplan.jackson.entity;

import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = Speaker.TABLE_NAME)
public class Speaker {

    public static final String TABLE_NAME = "RS_SPEAKER";

    private String firstname;

    private String lastname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    protected Speaker() {
    }

    public Speaker(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @ManyToMany(mappedBy = "speakers", fetch = FetchType.EAGER)
    private List<Talk> talks;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
