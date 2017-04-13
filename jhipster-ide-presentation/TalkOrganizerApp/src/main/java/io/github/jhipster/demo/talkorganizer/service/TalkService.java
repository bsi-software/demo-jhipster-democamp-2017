package io.github.jhipster.demo.talkorganizer.service;

import io.github.jhipster.demo.talkorganizer.domain.Talk;
import io.github.jhipster.demo.talkorganizer.repository.TalkRepository;
import io.github.jhipster.demo.talkorganizer.service.dto.TalkDTO;
import io.github.jhipster.demo.talkorganizer.service.mapper.TalkMapper;
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
 * Service Implementation for managing Talk.
 */
@Service
@Transactional
public class TalkService {

    private final Logger log = LoggerFactory.getLogger(TalkService.class);
    
    private final TalkRepository talkRepository;

    private final TalkMapper talkMapper;

    public TalkService(TalkRepository talkRepository, TalkMapper talkMapper) {
        this.talkRepository = talkRepository;
        this.talkMapper = talkMapper;
    }

    /**
     * Save a talk.
     *
     * @param talkDTO the entity to save
     * @return the persisted entity
     */
    public TalkDTO save(TalkDTO talkDTO) {
        log.debug("Request to save Talk : {}", talkDTO);
        Talk talk = talkMapper.talkDTOToTalk(talkDTO);
        talk = talkRepository.save(talk);
        TalkDTO result = talkMapper.talkToTalkDTO(talk);
        return result;
    }

    /**
     *  Get all the talks.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TalkDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Talks");
        Page<Talk> result = talkRepository.findAll(pageable);
        return result.map(talk -> talkMapper.talkToTalkDTO(talk));
    }

    /**
     *  Get one talk by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public TalkDTO findOne(Long id) {
        log.debug("Request to get Talk : {}", id);
        Talk talk = talkRepository.findOneWithEagerRelationships(id);
        TalkDTO talkDTO = talkMapper.talkToTalkDTO(talk);
        return talkDTO;
    }

    /**
     *  Delete the  talk by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Talk : {}", id);
        talkRepository.delete(id);
    }
}
