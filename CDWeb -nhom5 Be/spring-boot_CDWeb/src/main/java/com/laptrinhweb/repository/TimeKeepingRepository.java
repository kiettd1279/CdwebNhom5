package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.TimeKeepingEntity;

public interface TimeKeepingRepository extends JpaRepository<TimeKeepingEntity, Long>  {

}
