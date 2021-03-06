package com.edgar.bbs.dao.info;

public interface UserInfo {
    /*
    自定义查询结果集 获取用户的相关信息
     */

    String getUsername();

    String getAcademy();

    String getAvatar();

    String getEmail();

    String getGender();

    String getCreate_time();

    String getGrade();

    Integer getAge();

    String getDescription();

}
