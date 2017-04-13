package io.github.jhipster.demo.talkorganizer.service.mapper;

import io.github.jhipster.demo.talkorganizer.domain.*;
import io.github.jhipster.demo.talkorganizer.service.dto.SpeakerDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Speaker and its DTO SpeakerDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SpeakerMapper {

    SpeakerDTO speakerToSpeakerDTO(Speaker speaker);

    List<SpeakerDTO> speakersToSpeakerDTOs(List<Speaker> speakers);

    @Mapping(target = "talks", ignore = true)
    Speaker speakerDTOToSpeaker(SpeakerDTO speakerDTO);

    List<Speaker> speakerDTOsToSpeakers(List<SpeakerDTO> speakerDTOs);
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Speaker speakerFromId(Long id) {
        if (id == null) {
            return null;
        }
        Speaker speaker = new Speaker();
        speaker.setId(id);
        return speaker;
    }
    

}
