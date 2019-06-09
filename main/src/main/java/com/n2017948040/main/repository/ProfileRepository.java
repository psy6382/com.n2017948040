package com.n2017948040.main.repository;

import com.n2017948040.main.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
