package com.xeno.Xeno.repository;

import com.xeno.Xeno.model.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, Long> {
}
