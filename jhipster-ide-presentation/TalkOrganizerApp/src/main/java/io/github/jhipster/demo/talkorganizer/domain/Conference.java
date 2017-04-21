package io.github.jhipster.demo.talkorganizer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * This is a sample application to demonstrate
 * JHipster IDE features to the Eclipse DemoCamp Zurich '17
 */
@ApiModel(description = "This is a sample application to demonstrate JHipster IDE features to the Eclipse DemoCamp Zurich '17")
@Entity
@Table(name = "conference")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Conference implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "date", nullable = false)
    private ZonedDateTime date;

    @OneToMany(mappedBy = "conference")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Location> locations = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "conference_talk",
               joinColumns = @JoinColumn(name="conferences_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="talks_id", referencedColumnName="id"))
    private Set<Talk> talks = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Conference title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Conference date(ZonedDateTime date) {
        this.date = date;
        return this;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public Conference locations(Set<Location> locations) {
        this.locations = locations;
        return this;
    }

    public Conference addLocation(Location location) {
        this.locations.add(location);
        location.setConference(this);
        return this;
    }

    public Conference removeLocation(Location location) {
        this.locations.remove(location);
        location.setConference(null);
        return this;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public Set<Talk> getTalks() {
        return talks;
    }

    public Conference talks(Set<Talk> talks) {
        this.talks = talks;
        return this;
    }

    public Conference addTalk(Talk talk) {
        this.talks.add(talk);
        talk.getConferences().add(this);
        return this;
    }

    public Conference removeTalk(Talk talk) {
        this.talks.remove(talk);
        talk.getConferences().remove(this);
        return this;
    }

    public void setTalks(Set<Talk> talks) {
        this.talks = talks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Conference conference = (Conference) o;
        if (conference.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, conference.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Conference{" +
            "id=" + id +
            ", title='" + title + "'" +
            ", date='" + date + "'" +
            '}';
    }
}
