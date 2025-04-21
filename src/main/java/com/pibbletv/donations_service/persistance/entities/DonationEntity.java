package com.pibbletv.donations_service.persistance.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("donations")
public class DonationEntity {

    @Id
    private Long id;

    @Column("donorId")
    private Long donorId;

    @Column("receiverId")
    private Long receiverId;

    @Column("donationAmount")
    private Integer donationAmount;

    @Column("donationMessage")
    private String donationMessage;

    @Column("donated_at")
    private LocalDateTime donatedAt;
}