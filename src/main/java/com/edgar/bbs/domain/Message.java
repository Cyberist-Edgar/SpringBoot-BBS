package com.edgar.bbs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false, unique = true)
    Long id;

    /*
    通知的类型
     */
    @Column(name = "`type`", columnDefinition = "varchar(20)")
    String type;

    /*
    username
     */
    @Column(name = "username", columnDefinition = "varchar(30)")
    String username;


    /*
    通知标题
     */
    @Column(name = "title", columnDefinition = "varchar(100)")
    String title;

    /*
    通知的主要内容
     */
    @Column(name = "content", columnDefinition = "text")
    String content;

    /*
    通知发布的时间
     */
    @Column(name = "time", columnDefinition = "datetime default now()")
    String time;

    /*
    是否已经阅读
     */
    @Column(name = "`read`", columnDefinition = "boolean default false")
    Boolean read;

    /*
    信息对应的网址
     */
    @Column(name = "url", columnDefinition = "varchar(200)")
    String url;

}
