package com.pibbletv.donations_service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Donation {

    private Long id;

    private UUID donationId;

    private UUID donorId;

    private UUID receiverId;

    private Integer donationAmount;

    private String donationMessage;

    private LocalDateTime donatedAt;
}
