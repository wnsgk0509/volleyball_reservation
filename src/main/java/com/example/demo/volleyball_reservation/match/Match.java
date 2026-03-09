package com.example.demo.volleyball_reservation.match;

import com.example.demo.volleyball_reservation.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "MATCHES")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", nullable = false)
    private User host;

    @Column(nullable = false)
    private LocalDateTime matchDateTime;

    @Column(nullable = false)
    private String locationName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MatchStatus status;

    @Column(nullable = false)
    private Integer maxParticipants;

    @Column(nullable = false)
    private Integer currentParticipants;

    @Column(nullable = false)
    private Boolean providesEquipment;
}
