package io.github.jhipster.demo.talkorganizer.service;

import io.github.jhipster.demo.talkorganizer.domain.Conference;
import io.github.jhipster.demo.talkorganizer.repository.ConferenceRepository;
import io.github.jhipster.demo.talkorganizer.service.dto.ConferenceDTO;
import io.github.jhipster.demo.talkorganizer.service.mapper.ConferenceMapper;
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
 * Service Implementation for managing Conference.
 */
@Service
@Transactional
public class ConferenceService {

    private final Logger log = LoggerFactory.getLogger(ConferenceService.class);
    
    private final ConferenceRepository conferenceRepository;

    private final ConferenceMapper conferenceMapper;

    public ConferenceService(ConferenceRepository conferenceRepository, ConferenceMapper conferenceMapper) {
        this.conferenceRepository = conferenceRepository;
        this.conferenceMapper = conferenceMapper;
    }

    /**
     * Save a conference.
     *
     * @param conferenceDTO the entity to save
     * @return the persisted entity
     */
    public ConferenceDTO save(ConferenceDTO conferenceDTO) {
        log.debug("Request to save Conference : {}", conferenceDTO);
        Conference conference = conferenceMapper.conferenceDTOToConference(conferenceDTO);
        conference = conferenceRepository.save(conference);
        ConferenceDTO result = conferenceMapper.conferenceToConferenceDTO(conference);
        return result;
    }

    /**
     *  Get all the conferences.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<ConferenceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Conferences");
        Page<Conference> result = conferenceRepository.findAll(pageable);
        return result.map(conference -> conferenceMapper.conferenceToConferenceDTO(conference));
    }

    /**
     *  Get one conference by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public ConferenceDTO findOne(Long id) {
        log.debug("Request to get Conference : {}", id);
        Conference conference = conferenceRepository.findOneWithEagerRelationships(id);
        ConferenceDTO conferenceDTO = conferenceMapper.conferenceToConferenceDTO(conference);
        return conferenceDTO;
    }

    /**
     *  Delete the  conference by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Conference : {}", id);
        conferenceRepository.delete(id);
    }
}
