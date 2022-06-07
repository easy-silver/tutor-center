package com.timo.tutorcenter.category.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "CateSub")
public class CateSub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Category")
    private CateMain cateMain;

    @Column(name = "DisplayOrder")
    private int displayOrder;

    public CateSub(String name, CateMain cateMain, int displayOrder) {
        this.name = name;
        this.cateMain = cateMain;
        this.displayOrder = displayOrder;
    }

}
