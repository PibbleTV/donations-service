package com.pibbletv.donations_service.business.converters;

import com.pibbletv.donations_service.persistance.entities.DonationEntity;
import com.pibbletv.donations_service.domain.Donation;

import java.util.Base64;

public final class DonationConverter {

    private DonationConverter() {
        throw new IllegalStateException("Category converter");
    }

    public static Donation convertToObject(DonationEntity entity)
    {
        if (entity == null) return null;

        return Donation.builder()
                .id(entity.getId())
                .donorId(entity.getDonorId())
                .receiverId(entity.getReceiverId())
                .donationAmount(entity.getDonationAmount())
                .donationMessage(entity.getDonationMessage())
                .donatedAt(entity.getDonatedAt())
                .build();
    }

    public static DonationEntity convertToEntity(Donation donation) {
        if (donation == null) return null;

        return DonationEntity.builder()
                .id(donation.getId())
                .donorId(donation.getDonorId())
                .receiverId(donation.getReceiverId())
                .donationAmount(donation.getDonationAmount())
                .donationMessage(donation.getDonationMessage())
                .donatedAt(donation.getDonatedAt())
                .build();
    }
}
