package com.bug.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.tracker.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
