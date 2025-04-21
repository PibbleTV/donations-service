package com.pibbletv.donations_service.persistance.repository;

import com.pibbletv.donations_service.persistance.entities.DonationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends ReactiveCrudRepository<DonationEntity, Long> {
}
