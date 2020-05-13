package com.training.project102.service;

import com.training.project102.model.Names;

import java.util.List;

/**
 * created by pc on Mar, 2020
 */
public interface NamesService {


    Names createNames(Names name);

    List<Names> getAllNames();

    Names getNamesById(String id);

    boolean deleteNamesById(String id);
}