package com.jsg.ahispringboot.member.entity;

import com.jsg.ahispringboot.member.memberEnum.MemberRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String name;
    private String password;
    private Long phoneNumber;
    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

}