package com.edgar.bbs.dao;

import com.edgar.bbs.domain.User;
import com.edgar.bbs.dao.info.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional  // 进行修改更新操作的时候需要该注解
public interface UserDao extends JpaRepository<User, Long> {
    /*
    @author: Edgar
    对于用户信息的查询操作
     */

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> findAll();

    @Query(value = "SELECT * FROM user WHERE username=:username", nativeQuery = true)
    Optional<User> findUserByUsername(@Param("username") String username);


    @Query(value = "SELECT * FROM user WHERE academy=:academy", nativeQuery = true)
    List<User> findUsersByAcademy(@Param("academy") String academy);

    @Query(value = "SELECT  username, academy, avatar, email, gender, create_time, grade, age, description FROM user WHERE username=:username", nativeQuery = true)
    UserInfo getInfoUsingUsername(@Param(value = "username") String username);

    @Modifying
    @Query(value = "INSERT INTO user(username, password, email, gender, academy, grade) VALUES(:username, :password, :email, :gender, :academy, :grade)", nativeQuery = true)
    void insertUser(@Param(value = "username") String username, @Param(value = "password") String password, @Param(value = "email") String email, @Param(value = "gender") String gender, @Param(value = "academy") String academy, @Param(value = "grade") String grade);

    @Modifying
    @Query(value = "UPDATE user SET password=:password WHERE username=:username", nativeQuery = true)
    void updatePasswordByUsername(@Param(value = "username") String username, @Param(value = "password") String password);

    @Modifying
    @Query(value = "DELETE FROM user WHERE username=:username", nativeQuery = true)
    void deleteUserByUsername(@Param(value = "username") String username);

    @Modifying
    @Query(value = "UPDATE user SET academy=?2, gender=?3, age=?4, grade=?5, email=?6, description=?7, avatar=?8 WHERE username=?1", nativeQuery = true)
    void updateInfo(String username, String academy, String gender, Integer age, String grade, String email, String description, String avatar);
}
