package com.xeno.Xeno.service;

import com.xeno.Xeno.model.Segment;
import com.xeno.Xeno.repository.SegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SegmentService {

    @Autowired
    private SegmentRepository segmentRepository;

    // Save or update a segment
    public Segment saveSegment(Segment segment) {
        return segmentRepository.save(segment);
    }

    // Get all segments
    public List<Segment> getAllSegments() {
        return segmentRepository.findAll();
    }

    // Get segment by ID
    public Optional<Segment> getSegmentById(Long id) {
        return segmentRepository.findById(id);
    }

    // Delete segment by ID
    public void deleteSegment(Long id) {
        segmentRepository.deleteById(id);
    }

    public Optional<Segment> updateSegment(Long id, Segment updatedSegment) {
        return segmentRepository.findById(id).map(existingSegment -> {
            existingSegment.setName(updatedSegment.getName());
            return segmentRepository.save(existingSegment);
        });
    }

}
