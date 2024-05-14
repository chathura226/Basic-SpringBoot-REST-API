package com.chathuralakshan.Demo.repository;

import com.chathuralakshan.Demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user WHERE id=?1",nativeQuery = true)
    User getUserByUserID(String userID);

    @Query(value = "SELECT * FROM user WHERE id=?1 AND address=?2",nativeQuery = true)
    User getUserByIDAndAddress(String userID,String address);
}
