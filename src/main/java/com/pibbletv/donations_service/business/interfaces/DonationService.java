package com.pibbletv.donations_service.business.interfaces;


import com.pibbletv.donations_service.domain.Donation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface DonationService {

    Mono<Void> makeDonation(Donation donation);

    Flux<Donation> getAllDonations(UUID userId);

}
