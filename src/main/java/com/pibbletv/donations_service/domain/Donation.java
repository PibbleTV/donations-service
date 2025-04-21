package com.pibbletv.donations_service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Donation {

    private Long id;

    private Long donorId;

    private Long receiverId;

    private Integer donationAmount;

    private String donationMessage;

    private LocalDateTime donatedAt;
}
