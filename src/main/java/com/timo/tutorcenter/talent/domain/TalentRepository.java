package com.timo.tutorcenter.talent.domain;

import com.timo.tutorcenter.accounts.domain.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TalentRepository extends JpaRepository<Talent, Long> {

    Optional<Talent> findByIdAndOwner(Long id, Accounts owner);
}
