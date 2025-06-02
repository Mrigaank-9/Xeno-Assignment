package com.xeno.Xeno.controller;

import com.xeno.Xeno.model.Segment;
import com.xeno.Xeno.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/segments")
public class SegmentController {

    @Autowired
    private SegmentService segmentService;

    // Get all segments
    @GetMapping
    public List<Segment> getAllSegments() {
        return segmentService.getAllSegments();
    }

    // Get segment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Segment> getSegmentById(@PathVariable Long id) {
        Optional<Segment> segment = segmentService.getSegmentById(id);
        return segment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new segment
    @PostMapping
    public Segment createSegment(@RequestBody Segment segment) {
        return segmentService.saveSegment(segment);
    }

    // Update segment
    @PutMapping("/{id}")
    public ResponseEntity<Segment> updateSegment(@PathVariable Long id, @RequestBody Segment updatedSegment) {
        Optional<Segment> segment = segmentService.updateSegment(id, updatedSegment);
        return segment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete segment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSegment(@PathVariable Long id) {
        segmentService.deleteSegment(id);
        return ResponseEntity.noContent().build();
    }
}
