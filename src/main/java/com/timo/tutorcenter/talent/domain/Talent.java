package com.timo.tutorcenter.talent.domain;

import com.timo.tutorcenter.accounts.domain.Accounts;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "Talent")
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Owner_Id", nullable = false)
    private Accounts owner;

    @Column(name = "Title", columnDefinition = "text not null comment '클래스 제목'")
    private String title;

    @Column(name = "Status", nullable = false)
    private int status;

    @ColumnDefault("0")
    @Column(name = "Is_Vod", nullable = false)
    private int isVod;

    @ColumnDefault("0")
    @Column(name = "IsSoldOut", nullable = false)
    private int isSoldOut = 0;

    @Column(name = "RegisteredAtUtc", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "ModifiedAtUtc")
    private LocalDateTime modifiedAt;

    public Talent(Accounts owner, String title, boolean isVod) {
        this.owner = owner;
        this.title = title;
        this.status = TalentStatus.CREATED.getValue();
        this.isVod = isVod ? 1 : 0;
    }
}
