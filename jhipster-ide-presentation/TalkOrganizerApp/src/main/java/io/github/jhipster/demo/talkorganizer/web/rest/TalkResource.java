package io.github.jhipster.demo.talkorganizer.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.demo.talkorganizer.service.TalkService;
import io.github.jhipster.demo.talkorganizer.web.rest.util.HeaderUtil;
import io.github.jhipster.demo.talkorganizer.web.rest.util.PaginationUtil;
import io.github.jhipster.demo.talkorganizer.service.dto.TalkDTO;
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
 * REST controller for managing Talk.
 */
@RestController
@RequestMapping("/api")
public class TalkResource {

    private final Logger log = LoggerFactory.getLogger(TalkResource.class);

    private static final String ENTITY_NAME = "talk";
        
    private final TalkService talkService;

    public TalkResource(TalkService talkService) {
        this.talkService = talkService;
    }

    /**
     * POST  /talks : Create a new talk.
     *
     * @param talkDTO the talkDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new talkDTO, or with status 400 (Bad Request) if the talk has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/talks")
    @Timed
    public ResponseEntity<TalkDTO> createTalk(@Valid @RequestBody TalkDTO talkDTO) throws URISyntaxException {
        log.debug("REST request to save Talk : {}", talkDTO);
        if (talkDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new talk cannot already have an ID")).body(null);
        }
        TalkDTO result = talkService.save(talkDTO);
        return ResponseEntity.created(new URI("/api/talks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /talks : Updates an existing talk.
     *
     * @param talkDTO the talkDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated talkDTO,
     * or with status 400 (Bad Request) if the talkDTO is not valid,
     * or with status 500 (Internal Server Error) if the talkDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/talks")
    @Timed
    public ResponseEntity<TalkDTO> updateTalk(@Valid @RequestBody TalkDTO talkDTO) throws URISyntaxException {
        log.debug("REST request to update Talk : {}", talkDTO);
        if (talkDTO.getId() == null) {
            return createTalk(talkDTO);
        }
        TalkDTO result = talkService.save(talkDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, talkDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /talks : get all the talks.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of talks in body
     */
    @GetMapping("/talks")
    @Timed
    public ResponseEntity<List<TalkDTO>> getAllTalks(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Talks");
        Page<TalkDTO> page = talkService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/talks");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /talks/:id : get the "id" talk.
     *
     * @param id the id of the talkDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the talkDTO, or with status 404 (Not Found)
     */
    @GetMapping("/talks/{id}")
    @Timed
    public ResponseEntity<TalkDTO> getTalk(@PathVariable Long id) {
        log.debug("REST request to get Talk : {}", id);
        TalkDTO talkDTO = talkService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(talkDTO));
    }

    /**
     * DELETE  /talks/:id : delete the "id" talk.
     *
     * @param id the id of the talkDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/talks/{id}")
    @Timed
    public ResponseEntity<Void> deleteTalk(@PathVariable Long id) {
        log.debug("REST request to delete Talk : {}", id);
        talkService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
