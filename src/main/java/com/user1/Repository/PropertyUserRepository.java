package com.user1.Repository;

import com.user1.Entity.PropertyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyUserRepository extends JpaRepository<PropertyUser, Long> {
}