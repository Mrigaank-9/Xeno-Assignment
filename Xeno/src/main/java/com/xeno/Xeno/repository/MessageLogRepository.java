package com.xeno.Xeno.repository;

import com.xeno.Xeno.model.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
}
