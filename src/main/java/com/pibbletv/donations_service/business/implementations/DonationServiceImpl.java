package com.pibbletv.donations_service.business.implementations;


import com.pibbletv.donations_service.business.converters.DonationConverter;
import com.pibbletv.donations_service.business.interfaces.DonationService;
import com.pibbletv.donations_service.domain.Donation;
import com.pibbletv.donations_service.persistance.entities.DonationEntity;
import com.pibbletv.donations_service.persistance.repository.DonationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    @Override
    public Mono<Void> makeDonation(Donation donation) {
        DonationEntity donationEntity = DonationConverter.convertToEntity(donation);
        return donationRepository.save(donationEntity)
                .then();
    }

    @Override
    public Flux<Donation> getAllDonations(String userId) {
        return donationRepository.findByReceiverId(userId).map(DonationConverter::convertToObject);
    }


}
