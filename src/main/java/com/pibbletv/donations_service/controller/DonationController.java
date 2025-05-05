package com.pibbletv.donations_service.controller;

import com.pibbletv.donations_service.business.interfaces.DonationService;
import com.pibbletv.donations_service.domain.Donation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

    @PostMapping(value = "/makeDonation")
    public Mono<Void> makeDonation(@RequestBody Donation donation) {
        return donationService.makeDonation(donation);
    }

}
