package com.pibbletv.donations_service.business.implementations;


import com.pibbletv.donations_service.business.interfaces.DonationService;
import com.pibbletv.donations_service.persistance.repository.DonationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

}
