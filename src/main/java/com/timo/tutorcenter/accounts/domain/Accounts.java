package com.timo.tutorcenter.accounts.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "Accounts")
public class Accounts {

    @Id
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", columnDefinition = "varchar(50)")
    private String name;

    @Column(name = "ContactEmail", columnDefinition = "varchar(100)")
    private String email;

    public Accounts(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
