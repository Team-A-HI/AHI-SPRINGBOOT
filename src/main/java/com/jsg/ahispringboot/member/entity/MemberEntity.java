package com.jsg.ahispringboot.member.entity;

import com.jsg.ahispringboot.member.memberEnum.MemberRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    @Column(name = "name")
    private String name;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private MemberRole role;

//     @OneToOne(cascade = CascadeType.ALL)
//     @JoinColumn(name = "company_id")
//     private CompanyEntity companyEntity;

}
