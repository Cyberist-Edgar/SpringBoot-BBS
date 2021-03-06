package com.edgar.bbs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "LoginLog")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginLog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false, unique = true)
    Long id;

    @Column(name = "username", columnDefinition = "varchar(40)")
    String username;

   @Column(name = "ip", columnDefinition = "varchar(20)", nullable = false)
    String ip;

   @Column(name = "address", columnDefinition = "varchar(50)")
    String address;

   @Column(name = "create_time", columnDefinition = "datetime default now()")
    String create_time;

}
