package com.bbva.apimoviespring.repository;

import com.bbva.apimoviespring.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {


}