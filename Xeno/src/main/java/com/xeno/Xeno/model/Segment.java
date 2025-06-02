package com.xeno.Xeno.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "segments")
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long segmentId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String rulesJson; // stores filtering logic, possibly AI-generated

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    // Constructors
    public Segment() {}

    public Segment(String name, String description, String rulesJson) {
        this.name = name;
        this.description = description;
        this.rulesJson = rulesJson;
    }

    public Segment(Long segmentId, String name, String description, String rulesJson, Timestamp createdAt, Timestamp updatedAt) {
        this.segmentId = segmentId;
        this.name = name;
        this.description = description;
        this.rulesJson = rulesJson;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Long getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(Long segmentId) {
        this.segmentId = segmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRulesJson() {
        return rulesJson;
    }

    public void setRulesJson(String rulesJson) {
        this.rulesJson = rulesJson;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Segment)) return false;
        Segment segment = (Segment) o;
        return Objects.equals(segmentId, segment.segmentId) &&
                Objects.equals(name, segment.name) &&
                Objects.equals(description, segment.description) &&
                Objects.equals(rulesJson, segment.rulesJson) &&
                Objects.equals(createdAt, segment.createdAt) &&
                Objects.equals(updatedAt, segment.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segmentId, name, description, rulesJson, createdAt, updatedAt);
    }


}
