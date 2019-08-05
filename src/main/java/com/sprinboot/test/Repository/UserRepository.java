package com.sprinboot.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sprinboot.test.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

//    @Modifying
//    @Query("delete from user where user_detail->'$.email' = ?1")
//    void removeByTaskProperty(String email);

    /**
     * will report error information ： unexpected token : >
     **/
}
