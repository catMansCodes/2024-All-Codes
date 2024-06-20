package org.catmanscode.springbootkafkaconsumer.repository;

import org.catmanscode.springbootkafkaconsumer.model.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {

}
