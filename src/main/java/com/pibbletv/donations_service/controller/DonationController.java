package com.pibbletv.donations_service.controller;

import com.pibbletv.donations_service.business.interfaces.DonationService;
import com.pibbletv.donations_service.domain.Donation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

    @PostMapping(value = "/makeDonation")
    public Mono<Void> makeDonation(@RequestBody Donation donation) {
        return donationService.makeDonation(donation);
    }

    @GetMapping(value = "/getDonations")
    public Flux<Donation> getAllDonations(@RequestParam UUID userId) {
        return donationService.getAllDonations(userId);
    }

}
