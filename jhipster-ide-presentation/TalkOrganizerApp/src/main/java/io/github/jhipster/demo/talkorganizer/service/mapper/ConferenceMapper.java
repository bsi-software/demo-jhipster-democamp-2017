package io.github.jhipster.demo.talkorganizer.service.mapper;

import io.github.jhipster.demo.talkorganizer.domain.*;
import io.github.jhipster.demo.talkorganizer.service.dto.ConferenceDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Conference and its DTO ConferenceDTO.
 */
@Mapper(componentModel = "spring", uses = {TalkMapper.class, })
public interface ConferenceMapper {

    ConferenceDTO conferenceToConferenceDTO(Conference conference);

    List<ConferenceDTO> conferencesToConferenceDTOs(List<Conference> conferences);

    @Mapping(target = "locations", ignore = true)
    Conference conferenceDTOToConference(ConferenceDTO conferenceDTO);

    List<Conference> conferenceDTOsToConferences(List<ConferenceDTO> conferenceDTOs);
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Conference conferenceFromId(Long id) {
        if (id == null) {
            return null;
        }
        Conference conference = new Conference();
        conference.setId(id);
        return conference;
    }
    

}
