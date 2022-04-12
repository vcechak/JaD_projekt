package com.Cechavo.JaD.Repositories;

import com.Cechavo.JaD.Entities.Role;
import com.Cechavo.JaD.Entities.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT u FROM Role u WHERE u.name = :name")
    Role findByName(@Param("name") String name);
}

