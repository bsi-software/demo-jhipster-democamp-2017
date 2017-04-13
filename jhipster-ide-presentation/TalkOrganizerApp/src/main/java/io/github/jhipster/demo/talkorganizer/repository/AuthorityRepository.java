package io.github.jhipster.demo.talkorganizer.repository;

import io.github.jhipster.demo.talkorganizer.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
