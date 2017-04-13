package io.github.jhipster.demo.talkorganizer.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.demo.talkorganizer.service.SpeakerService;
import io.github.jhipster.demo.talkorganizer.web.rest.util.HeaderUtil;
import io.github.jhipster.demo.talkorganizer.web.rest.util.PaginationUtil;
import io.github.jhipster.demo.talkorganizer.service.dto.SpeakerDTO;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing Speaker.
 */
@RestController
@RequestMapping("/api")
public class SpeakerResource {

    private final Logger log = LoggerFactory.getLogger(SpeakerResource.class);

    private static final String ENTITY_NAME = "speaker";
        
    private final SpeakerService speakerService;

    public SpeakerResource(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    /**
     * POST  /speakers : Create a new speaker.
     *
     * @param speakerDTO the speakerDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new speakerDTO, or with status 400 (Bad Request) if the speaker has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/speakers")
    @Timed
    public ResponseEntity<SpeakerDTO> createSpeaker(@RequestBody SpeakerDTO speakerDTO) throws URISyntaxException {
        log.debug("REST request to save Speaker : {}", speakerDTO);
        if (speakerDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new speaker cannot already have an ID")).body(null);
        }
        SpeakerDTO result = speakerService.save(speakerDTO);
        return ResponseEntity.created(new URI("/api/speakers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /speakers : Updates an existing speaker.
     *
     * @param speakerDTO the speakerDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated speakerDTO,
     * or with status 400 (Bad Request) if the speakerDTO is not valid,
     * or with status 500 (Internal Server Error) if the speakerDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/speakers")
    @Timed
    public ResponseEntity<SpeakerDTO> updateSpeaker(@RequestBody SpeakerDTO speakerDTO) throws URISyntaxException {
        log.debug("REST request to update Speaker : {}", speakerDTO);
        if (speakerDTO.getId() == null) {
            return createSpeaker(speakerDTO);
        }
        SpeakerDTO result = speakerService.save(speakerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, speakerDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /speakers : get all the speakers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of speakers in body
     */
    @GetMapping("/speakers")
    @Timed
    public ResponseEntity<List<SpeakerDTO>> getAllSpeakers(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Speakers");
        Page<SpeakerDTO> page = speakerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/speakers");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /speakers/:id : get the "id" speaker.
     *
     * @param id the id of the speakerDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the speakerDTO, or with status 404 (Not Found)
     */
    @GetMapping("/speakers/{id}")
    @Timed
    public ResponseEntity<SpeakerDTO> getSpeaker(@PathVariable Long id) {
        log.debug("REST request to get Speaker : {}", id);
        SpeakerDTO speakerDTO = speakerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(speakerDTO));
    }

    /**
     * DELETE  /speakers/:id : delete the "id" speaker.
     *
     * @param id the id of the speakerDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/speakers/{id}")
    @Timed
    public ResponseEntity<Void> deleteSpeaker(@PathVariable Long id) {
        log.debug("REST request to delete Speaker : {}", id);
        speakerService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
