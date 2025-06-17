package com.pibbletv.donations_service.controller;

import com.pibbletv.donations_service.business.interfaces.DonationService;
import com.pibbletv.donations_service.domain.Donation;
import io.sentry.SentryLevel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.lang.Exception;
import io.sentry.Sentry;

import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

    @PostMapping(value = "/makeDonation")
    public Mono<Void> makeDonation(@RequestBody Donation donation) {
        Sentry.captureMessage("User " + donation.getDonorId() + " donated "
                + donation.getDonationAmount() + " to " + donation.getReceiverId()
                + " with the message " + donation.getDonationMessage(), SentryLevel.INFO);
        return donationService.makeDonation(donation);
    }

    @GetMapping(value = "/getDonations")
    public Flux<Donation> getAllDonations(@RequestParam String userId) {
        return donationService.getAllDonations(userId)
                .map(donation -> {
                    if (donation.getDonationMessage() != null) {
                        donation.setDonationMessage(HtmlUtils.htmlEscape(donation.getDonationMessage()));
                    }
                    return donation;
                });
    }

    @GetMapping("/test-sentry")
    public String testSentry() {
        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
            Sentry.captureException(e);
            return "Exception sent to Sentry";
        }
    }
}


