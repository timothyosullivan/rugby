package com.rugbystats.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService implements IMatchService {

    @Autowired
    private MatchRepository repository;

    @Override
    public List<Match> findAll() {
        return (List<Match>) repository.findAll();
    }

}