package io.github.jhipster.demo.talkorganizer.service;

import io.github.jhipster.demo.talkorganizer.domain.Speaker;
import io.github.jhipster.demo.talkorganizer.repository.SpeakerRepository;
import io.github.jhipster.demo.talkorganizer.service.dto.SpeakerDTO;
import io.github.jhipster.demo.talkorganizer.service.mapper.SpeakerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Speaker.
 */
@Service
@Transactional
public class SpeakerService {

    private final Logger log = LoggerFactory.getLogger(SpeakerService.class);
    
    private final SpeakerRepository speakerRepository;

    private final SpeakerMapper speakerMapper;

    public SpeakerService(SpeakerRepository speakerRepository, SpeakerMapper speakerMapper) {
        this.speakerRepository = speakerRepository;
        this.speakerMapper = speakerMapper;
    }

    /**
     * Save a speaker.
     *
     * @param speakerDTO the entity to save
     * @return the persisted entity
     */
    public SpeakerDTO save(SpeakerDTO speakerDTO) {
        log.debug("Request to save Speaker : {}", speakerDTO);
        Speaker speaker = speakerMapper.speakerDTOToSpeaker(speakerDTO);
        speaker = speakerRepository.save(speaker);
        SpeakerDTO result = speakerMapper.speakerToSpeakerDTO(speaker);
        return result;
    }

    /**
     *  Get all the speakers.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<SpeakerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Speakers");
        Page<Speaker> result = speakerRepository.findAll(pageable);
        return result.map(speaker -> speakerMapper.speakerToSpeakerDTO(speaker));
    }

    /**
     *  Get one speaker by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public SpeakerDTO findOne(Long id) {
        log.debug("Request to get Speaker : {}", id);
        Speaker speaker = speakerRepository.findOne(id);
        SpeakerDTO speakerDTO = speakerMapper.speakerToSpeakerDTO(speaker);
        return speakerDTO;
    }

    /**
     *  Delete the  speaker by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Speaker : {}", id);
        speakerRepository.delete(id);
    }
}
