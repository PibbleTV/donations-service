package com.pibbletv.donations_service.persistance.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("donations")
public class DonationEntity {

    @Id
    private Long id;

    @NotNull
    @Column("donorId")
    private UUID donorId;

    @NotNull
    @Column("receiverId")
    private UUID receiverId;

    @Column("donationAmount")
    private Integer donationAmount;

    @Column("donationMessage")
    private String donationMessage;

    @Column("donated_at")
    private LocalDateTime donatedAt;
}