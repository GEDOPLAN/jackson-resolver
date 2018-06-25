package de.gedoplan.jackson.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.gedoplan.jackson.system.JPAResolver;

import java.util.ArrayList;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = Talk.TABLE_NAME)
public class Talk {

    public static final String TABLE_NAME = "RS_TALK";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 5)
    private String title;

    @JsonIdentityInfo(resolver = JPAResolver.class, generator = ObjectIdGenerators.PropertyGenerator.class, scope = Speaker.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Speaker> speakers = new ArrayList<>();

    @NotNull
    private TalkType talkType;

    @Min(15)
    private Integer duration;

    public Talk(String title, TalkType talkType, int duration, Speaker... speakers) {
        this.title = title;
        this.talkType = talkType;
        this.duration = duration;
        this.speakers = new ArrayList<>();
        for (Speaker speaker : speakers) {
            this.speakers.add(speaker);
        }
    }

    protected Talk() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Speaker> getSpeakers() {
        return this.speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public TalkType getTalkType() {
        return this.talkType;
    }

    public void setTalkType(TalkType talkType) {
        this.talkType = talkType;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
