package com.xeno.Xeno.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String message;

    private String status; // e.g., DRAFT, SCHEDULED, SENT

    private Timestamp scheduledAt;

    private String audienceTag; // Optional: "High Value", "Inactive Users", etc.

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    // Constructors
    public Campaign() {}

    public Campaign(Long campaignId, String title, String message, String status, Timestamp scheduledAt, String audienceTag) {
        this.campaignId = campaignId;
        this.title = title;
        this.message = message;
        this.status = status;
        this.scheduledAt = scheduledAt;
        this.audienceTag = audienceTag;
    }

    // Getters and Setters
    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Timestamp scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public String getAudienceTag() {
        return audienceTag;
    }

    public void setAudienceTag(String audienceTag) {
        this.audienceTag = audienceTag;
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
        if (!(o instanceof Campaign)) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(campaignId, campaign.campaignId) &&
                Objects.equals(title, campaign.title) &&
                Objects.equals(message, campaign.message) &&
                Objects.equals(status, campaign.status) &&
                Objects.equals(scheduledAt, campaign.scheduledAt) &&
                Objects.equals(audienceTag, campaign.audienceTag) &&
                Objects.equals(createdAt, campaign.createdAt) &&
                Objects.equals(updatedAt, campaign.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campaignId, title, message, status, scheduledAt, audienceTag, createdAt, updatedAt);
    }
}
