package com.Cechavo.JaD.Repositories;

import com.Cechavo.JaD.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

        //Interface adding method to look for nick of user


        @Query("SELECT u FROM User u WHERE u.nick = :nick")
        public User findByNick (@Param("nick") String nick);

        /*@Query("Select user_id from User u where u.nick = :nick")
        public User findIdByNick(@Param("nick") String nick);*/
}

