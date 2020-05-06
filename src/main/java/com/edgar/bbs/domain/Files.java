package com.edgar.bbs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false, unique = true)
    Long id;

    @Column(name = "userId", columnDefinition = "bigint", nullable = false)
    Long userId;

    @Column(name = "fileName", columnDefinition = "varchar(100)", nullable = false)
    String fileName;

    @Column(name = "type", columnDefinition = "varchar(10)", nullable = false)
    String type;

    @Column(name = "downloadTimes", columnDefinition = "bigint default 0")
    Long downloadTimes;

    @Column(name = "uploadTime", columnDefinition = "datetime default now()")
    String uploadTime;

    @Column(name = "description", columnDefinition = "text")
    String description;

    @Column(name = "path", columnDefinition = "varchar(200)", nullable = false)
    String path;

}
