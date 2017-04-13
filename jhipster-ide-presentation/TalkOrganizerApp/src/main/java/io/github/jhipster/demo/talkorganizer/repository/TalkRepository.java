package io.github.jhipster.demo.talkorganizer.repository;

import io.github.jhipster.demo.talkorganizer.domain.Talk;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Talk entity.
 */
@SuppressWarnings("unused")
public interface TalkRepository extends JpaRepository<Talk,Long> {

    @Query("select distinct talk from Talk talk left join fetch talk.speakers")
    List<Talk> findAllWithEagerRelationships();

    @Query("select talk from Talk talk left join fetch talk.speakers where talk.id =:id")
    Talk findOneWithEagerRelationships(@Param("id") Long id);

}
