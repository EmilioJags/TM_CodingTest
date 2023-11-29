package com.tmexam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tmexam.model.Person;

public interface PersonDao extends JpaRepository<Person, Long>{

}
