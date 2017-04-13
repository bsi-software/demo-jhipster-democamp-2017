package io.github.jhipster.demo.talkorganizer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Talk.
 */
@Entity
@Table(name = "talk")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Talk implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "talk_speaker",
               joinColumns = @JoinColumn(name="talks_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="speakers_id", referencedColumnName="id"))
    private Set<Speaker> speakers = new HashSet<>();

    @ManyToMany(mappedBy = "talks")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Conference> conferences = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Talk title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Talk description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public Talk speakers(Set<Speaker> speakers) {
        this.speakers = speakers;
        return this;
    }

    public Talk addSpeaker(Speaker speaker) {
        this.speakers.add(speaker);
        speaker.getTalks().add(this);
        return this;
    }

    public Talk removeSpeaker(Speaker speaker) {
        this.speakers.remove(speaker);
        speaker.getTalks().remove(this);
        return this;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Set<Conference> getConferences() {
        return conferences;
    }

    public Talk conferences(Set<Conference> conferences) {
        this.conferences = conferences;
        return this;
    }

    public Talk addConference(Conference conference) {
        this.conferences.add(conference);
        conference.getTalks().add(this);
        return this;
    }

    public Talk removeConference(Conference conference) {
        this.conferences.remove(conference);
        conference.getTalks().remove(this);
        return this;
    }

    public void setConferences(Set<Conference> conferences) {
        this.conferences = conferences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Talk talk = (Talk) o;
        if (talk.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, talk.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Talk{" +
            "id=" + id +
            ", title='" + title + "'" +
            ", description='" + description + "'" +
            '}';
    }
}
