package com.bitfest.BitFest.database.topic.repository;

import com.bitfest.BitFest.database.topic.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    // We will use the default one from JpaRepository
}
