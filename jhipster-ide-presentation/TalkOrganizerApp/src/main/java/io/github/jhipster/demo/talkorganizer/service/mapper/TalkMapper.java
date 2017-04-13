package io.github.jhipster.demo.talkorganizer.service.mapper;

import io.github.jhipster.demo.talkorganizer.domain.*;
import io.github.jhipster.demo.talkorganizer.service.dto.TalkDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Talk and its DTO TalkDTO.
 */
@Mapper(componentModel = "spring", uses = {SpeakerMapper.class, })
public interface TalkMapper {

    TalkDTO talkToTalkDTO(Talk talk);

    List<TalkDTO> talksToTalkDTOs(List<Talk> talks);

    @Mapping(target = "conferences", ignore = true)
    Talk talkDTOToTalk(TalkDTO talkDTO);

    List<Talk> talkDTOsToTalks(List<TalkDTO> talkDTOs);
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Talk talkFromId(Long id) {
        if (id == null) {
            return null;
        }
        Talk talk = new Talk();
        talk.setId(id);
        return talk;
    }
    

}
