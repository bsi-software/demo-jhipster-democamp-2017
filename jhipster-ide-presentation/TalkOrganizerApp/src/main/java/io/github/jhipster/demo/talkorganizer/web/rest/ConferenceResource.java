package io.github.jhipster.demo.talkorganizer.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.demo.talkorganizer.service.ConferenceService;
import io.github.jhipster.demo.talkorganizer.web.rest.util.HeaderUtil;
import io.github.jhipster.demo.talkorganizer.web.rest.util.PaginationUtil;
import io.github.jhipster.demo.talkorganizer.service.dto.ConferenceDTO;
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

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing Conference.
 */
@RestController
@RequestMapping("/api")
public class ConferenceResource {

    private final Logger log = LoggerFactory.getLogger(ConferenceResource.class);

    private static final String ENTITY_NAME = "conference";
        
    private final ConferenceService conferenceService;

    public ConferenceResource(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    /**
     * POST  /conferences : Create a new conference.
     *
     * @param conferenceDTO the conferenceDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new conferenceDTO, or with status 400 (Bad Request) if the conference has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/conferences")
    @Timed
    public ResponseEntity<ConferenceDTO> createConference(@Valid @RequestBody ConferenceDTO conferenceDTO) throws URISyntaxException {
        log.debug("REST request to save Conference : {}", conferenceDTO);
        if (conferenceDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new conference cannot already have an ID")).body(null);
        }
        ConferenceDTO result = conferenceService.save(conferenceDTO);
        return ResponseEntity.created(new URI("/api/conferences/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /conferences : Updates an existing conference.
     *
     * @param conferenceDTO the conferenceDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated conferenceDTO,
     * or with status 400 (Bad Request) if the conferenceDTO is not valid,
     * or with status 500 (Internal Server Error) if the conferenceDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/conferences")
    @Timed
    public ResponseEntity<ConferenceDTO> updateConference(@Valid @RequestBody ConferenceDTO conferenceDTO) throws URISyntaxException {
        log.debug("REST request to update Conference : {}", conferenceDTO);
        if (conferenceDTO.getId() == null) {
            return createConference(conferenceDTO);
        }
        ConferenceDTO result = conferenceService.save(conferenceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, conferenceDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /conferences : get all the conferences.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of conferences in body
     */
    @GetMapping("/conferences")
    @Timed
    public ResponseEntity<List<ConferenceDTO>> getAllConferences(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Conferences");
        Page<ConferenceDTO> page = conferenceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/conferences");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /conferences/:id : get the "id" conference.
     *
     * @param id the id of the conferenceDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the conferenceDTO, or with status 404 (Not Found)
     */
    @GetMapping("/conferences/{id}")
    @Timed
    public ResponseEntity<ConferenceDTO> getConference(@PathVariable Long id) {
        log.debug("REST request to get Conference : {}", id);
        ConferenceDTO conferenceDTO = conferenceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(conferenceDTO));
    }

    /**
     * DELETE  /conferences/:id : delete the "id" conference.
     *
     * @param id the id of the conferenceDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/conferences/{id}")
    @Timed
    public ResponseEntity<Void> deleteConference(@PathVariable Long id) {
        log.debug("REST request to delete Conference : {}", id);
        conferenceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
