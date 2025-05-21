package com.pibbletv.donations_service.business.interfaces;


import com.pibbletv.donations_service.domain.Donation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DonationService {

    Mono<Void> makeDonation(Donation donation);

    Flux<Donation> getAllDonations(String userId);

}
