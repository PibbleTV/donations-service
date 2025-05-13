package com.pibbletv.donations_service.integration;


import com.pibbletv.donations_service.business.converters.DonationConverter;
import com.pibbletv.donations_service.business.implementations.DonationServiceImpl;
import com.pibbletv.donations_service.domain.Donation;
import com.pibbletv.donations_service.persistance.entities.DonationEntity;
import com.pibbletv.donations_service.persistance.repository.DonationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureWebTestClient
public class DonationsControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @InjectMocks
    private DonationServiceImpl donationService;

    @Mock
    private DonationRepository donationRepository;


//    @Test
//    void testMakeDonation_shouldReturnStatusOk_whenDonationIsSavedSuccessfully() {
//
//        Donation donation = Donation.builder()
//                .donorId(1L)
//                .receiverId(2L)
//                .donationAmount(100)
//                .donationMessage("Keep going!")
//                .donatedAt(LocalDateTime.now())
//                .build();
//
//        DonationEntity entity = DonationConverter.convertToEntity(donation);
//
//        when(donationRepository.save(entity)).thenReturn(Mono.empty());
//        when(donationService.makeDonation(donation)).thenReturn(Mono.empty());
//
//        webTestClient.post()
//                .uri("/donations/makeDonation")
//                .bodyValue(donation)
//                .exchange()
//                .expectStatus().isOk();
//    }
//
//    @Test
//    void testGetDonations_shouldReturnStatusOk_whenDonationsAreSuccessfullyRetrieved() {
//
//        Long userId = 1L;
//        DonationEntity entity1 = new DonationEntity(1L, 2L, userId, 50, "Thanks!", LocalDateTime.now());
//        DonationEntity entity2 = new DonationEntity(2L, 3L, userId, 30, "Enjoy!", LocalDateTime.now());
//
//        Donation donation1 = DonationConverter.convertToObject(entity1);
//        Donation donation2 = DonationConverter.convertToObject(entity2);
//
//        when(donationRepository.findByReceiverId(userId)).thenReturn(Flux.just(entity1, entity2));
//        when(donationService.getAllDonations(userId)).thenReturn(Flux.just(donation1, donation2));
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/donations/getDonations")
//                        .queryParam("userId", userId)
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(Donation.class)
//                .hasSize(2);
//    }
//
//    @Test
//    void testMakeDonation_shouldReturnServerError_whenDatabaseFails() {
//
//        Donation donation = Donation.builder()
//                .donorId(1L)
//                .receiverId(2L)
//                .donationAmount(100)
//                .donationMessage("Keep going!")
//                .donatedAt(LocalDateTime.now())
//                .build();
//
//        DonationEntity entity = DonationConverter.convertToEntity(donation);
//
//        when(donationRepository.save(entity).thenReturn(Mono.error(new RuntimeException("DB save error"))));
//        when(donationService.makeDonation(donation)).thenReturn(Mono.error(new RuntimeException("DB save error")));
//
//        webTestClient.post()
//                .uri("/donations/makeDonation")
//                .bodyValue(donation)
//                .exchange()
//                .expectStatus().is5xxServerError();
//    }
//
//    @Test
//    void testGetDonations_shouldReturnStatusOk_whenAnEmptyListIsRetrieved() {
//        when(donationRepository.findByReceiverId(999L)).thenReturn(Flux.empty());
//        when(donationService.getAllDonations(999L)).thenReturn(Flux.empty());
//
//        webTestClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/donations/getDonations")
//                        .queryParam("userId", "999")
//                        .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(Donation.class)
//                .hasSize(0);
//    }
}


