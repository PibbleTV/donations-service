package com.pibbletv.donations_service.unit;

import com.pibbletv.donations_service.business.converters.DonationConverter;
import com.pibbletv.donations_service.business.implementations.DonationServiceImpl;
import com.pibbletv.donations_service.domain.Donation;
import com.pibbletv.donations_service.persistance.entities.DonationEntity;
import com.pibbletv.donations_service.persistance.repository.DonationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DonationServiceImplTest {

    @Mock
    private DonationRepository donationRepository;

    @InjectMocks
    private DonationServiceImpl donationService;

    @Test
    void makeDonation_ShouldSaveSuccessfully() {
        Donation donation = new Donation(null, 1L, 2L, 100, "Great stream!", LocalDateTime.now());
        DonationEntity donationEntity = DonationConverter.convertToEntity(donation);

        when(donationRepository.save(donationEntity)).thenReturn(Mono.just(donationEntity));

        StepVerifier.create(donationService.makeDonation(donation))
                .verifyComplete();

        verify(donationRepository, times(1)).save(donationEntity);
    }

//    @Test
//    void makeDonation_WhenRepositoryFails_ShouldEmitError() {
//
//        Donation donation = new Donation(null, 1L, 2L, 100, "Keep it up!", LocalDateTime.now());
//        DonationEntity donationEntity = DonationConverter.convertToEntity(donation);
//
//        when(donationRepository.save(donationEntity)).thenReturn(Mono.error(new RuntimeException("DB error")));
//
//        StepVerifier.create(donationService.makeDonation(donation))
//                .expectErrorMatches(throwable -> throwable instanceof RuntimeException &&
//                        throwable.getMessage().equals("DB error"))
//                .verify();
//    }

    @Test
    void getAllDonations_ShouldReturnListOfDonations() {

        Long userId = 1L;
        DonationEntity entity1 = new DonationEntity(1L, 2L, userId, 50, "Thanks!", LocalDateTime.now());
        DonationEntity entity2 = new DonationEntity(2L, 3L, userId, 30, "Enjoy!", LocalDateTime.now());

        when(donationRepository.findByReceiverId(userId)).thenReturn(Flux.just(entity1, entity2));

        StepVerifier.create(donationService.getAllDonations(userId))
                .expectNextMatches(d -> d.getId().equals(1L) && d.getDonationAmount() == 50)
                .expectNextMatches(d -> d.getId().equals(2L) && d.getDonationAmount() == 30)
                .verifyComplete();
    }

    @Test
    void getAllDonations_WhenNoDonationsExist_ShouldReturnEmptyFlux() {

        Long userId = 999L;
        when(donationRepository.findByReceiverId(userId)).thenReturn(Flux.empty());

        StepVerifier.create(donationService.getAllDonations(userId))
                .expectNextCount(0)
                .verifyComplete();
    }
}
