package com.my.tiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.tiles.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
