package com.bug.tracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracker.entity.Issue;
import com.bug.tracker.repository.IssueRepository;
import com.bug.tracker.service.IssueService;

@Service
public class DefaultIssueService implements IssueService{

	@Autowired
	IssueRepository issueRepository;
	
	@Override
	public void save(Issue issue) {
		issueRepository.save(issue);
	}

}
