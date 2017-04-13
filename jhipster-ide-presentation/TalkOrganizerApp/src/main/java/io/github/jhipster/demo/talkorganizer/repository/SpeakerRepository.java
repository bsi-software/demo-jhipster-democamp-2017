package io.github.jhipster.demo.talkorganizer.repository;

import io.github.jhipster.demo.talkorganizer.domain.Speaker;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Speaker entity.
 */
@SuppressWarnings("unused")
public interface SpeakerRepository extends JpaRepository<Speaker,Long> {

}
