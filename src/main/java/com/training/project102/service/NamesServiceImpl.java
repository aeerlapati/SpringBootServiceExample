package com.training.project102.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project102.model.Names;
import com.training.project102.repository.NameRepository;

import java.util.List;
import java.util.Optional;

/**
 * created by pc on Mar, 2020
 */

@Service
public class NamesServiceImpl implements NamesService {

    @Autowired
    private NameRepository namesRepository;


    @Override
    public Names createNames(Names name) {
        return namesRepository.save(name);
    }

    @Override
    public List<Names> getAllNames() {
        return (List<Names>) namesRepository.findAll();
    }

    @Override
    public Names getNamesById(String id) {
        Optional<Names> dbOrder = namesRepository.findById(id);
        return dbOrder.orElse(null);
    }

    @Override
    public boolean deleteNamesById(String id) {
    	namesRepository.deleteById(id);
        return getNamesById(id) == null;
    }
}