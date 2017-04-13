package io.github.jhipster.demo.talkorganizer.repository;

import io.github.jhipster.demo.talkorganizer.domain.Conference;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Conference entity.
 */
@SuppressWarnings("unused")
public interface ConferenceRepository extends JpaRepository<Conference,Long> {

    @Query("select distinct conference from Conference conference left join fetch conference.talks")
    List<Conference> findAllWithEagerRelationships();

    @Query("select conference from Conference conference left join fetch conference.talks where conference.id =:id")
    Conference findOneWithEagerRelationships(@Param("id") Long id);

}
