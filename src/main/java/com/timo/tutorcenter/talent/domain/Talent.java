package com.timo.tutorcenter.talent.domain;

import com.timo.tutorcenter.accounts.domain.Accounts;
import com.timo.tutorcenter.category.domain.CateMain;
import com.timo.tutorcenter.category.domain.CateSub;
import com.timo.tutorcenter.talent.application.command.NewTalentCommand;
import com.timo.tutorcenter.talent.infra.BooleanIntegerConverter;
import lombok.AccessLevel;
import lombok.Builder;
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
    private String title = "";

    @Column(name = "Status", nullable = false)
    private int status;

    @Column(name = "mCategory")
    private int mCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CateMain")
    private CateMain cateMain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CateSub")
    private CateSub cateSub;

    @Column(name = "MinPerson")
    private Integer minPerson;

    @Column(name = "MaxPerson")
    private Integer maxPerson;

    @Column(name = "GroupAvailable")
    private Integer groupAvailable;

    @Column(name = "TotalTimes")
    private Integer totalTimes;

    @Convert(converter = BooleanIntegerConverter.class)
    @ColumnDefault("0")
    @Column(name = "Is_Vod", nullable = false)
    private Boolean isVod;

    @Convert(converter = BooleanIntegerConverter.class)
    @ColumnDefault("0")
    @Column(name = "IsSoldOut", nullable = false)
    private Boolean isSoldOut;

    @Column(name = "RegisteredAtUtc", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "ModifiedAtUtc")
    private LocalDateTime modifiedAt;

    @Builder
    private Talent(Accounts owner, String title, int status, int mCategory, CateMain cateMain, CateSub cateSub,
                  Integer minPerson, Integer maxPerson, Integer groupAvailable, Integer totalTimes, Boolean isVod, Boolean isSoldOut) {
        this.owner = owner;
        this.title = title;
        this.status = status;
        this.mCategory = mCategory;
        this.cateMain = cateMain;
        this.cateSub = cateSub;
        this.minPerson = minPerson;
        this.maxPerson = maxPerson;
        this.groupAvailable = groupAvailable;
        this.totalTimes = totalTimes;
        this.isVod = isVod;
        this.isSoldOut = isSoldOut;
    }

    public static Talent createOfflineTalent(NewTalentCommand command) {
        return Talent.builder()
                .owner(command.getOwner())
                .cateMain(command.getCateMain())
                .cateSub(command.getCateSub())
                .minPerson(command.getMinPerson())
                .maxPerson(command.getMaxPerson())
                .groupAvailable(command.getGroupAvailable() == null ? null : command.getGroupAvailable().getValue())
                .totalTimes(command.getTotalTimes())
                .title("")
                .status(TalentStatus.CREATED.getValue())
                .mCategory(TalentType.OFFLINE.getValue())
                .isVod(false)
                .isSoldOut(false)
                .build();
    }
}
