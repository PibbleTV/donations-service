package com.pibbletv.donations_service.controller;

import com.pibbletv.donations_service.business.interfaces.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

}
