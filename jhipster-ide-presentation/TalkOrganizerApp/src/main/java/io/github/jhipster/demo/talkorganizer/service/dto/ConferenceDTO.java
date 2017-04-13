package io.github.jhipster.demo.talkorganizer.service.dto;


import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Conference entity.
 */
public class ConferenceDTO implements Serializable {

    private Long id;

    @NotNull
    private Long conferenceId;

    @NotNull
    private String title;

    @NotNull
    private ZonedDateTime date;

    private Set<TalkDTO> talks = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Long conferenceId) {
        this.conferenceId = conferenceId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public Set<TalkDTO> getTalks() {
        return talks;
    }

    public void setTalks(Set<TalkDTO> talks) {
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

        ConferenceDTO conferenceDTO = (ConferenceDTO) o;

        if ( ! Objects.equals(id, conferenceDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ConferenceDTO{" +
            "id=" + id +
            ", conferenceId='" + conferenceId + "'" +
            ", title='" + title + "'" +
            ", date='" + date + "'" +
            '}';
    }
}
