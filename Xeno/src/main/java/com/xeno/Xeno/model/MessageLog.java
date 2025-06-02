package com.xeno.Xeno.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "message_logs")
public class MessageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(columnDefinition = "TEXT")
    private String messageContent;

    private String deliveryStatus; // e.g., SENT, FAILED, PENDING

    @CreationTimestamp
    private Timestamp sentAt;

    private String channel; // e.g., "Email", "SMS", "WhatsApp"

    // Constructors
    public MessageLog() {}

    public MessageLog(Campaign campaign, Customer customer, String messageContent, String deliveryStatus, String channel) {
        this.campaign = campaign;
        this.customer = customer;
        this.messageContent = messageContent;
        this.deliveryStatus = deliveryStatus;
        this.channel = channel;
    }

    // Getters and Setters
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Timestamp getSentAt() {
        return sentAt;
    }

    public void setSentAt(Timestamp sentAt) {
        this.sentAt = sentAt;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageLog)) return false;
        MessageLog that = (MessageLog) o;
        return Objects.equals(messageId, that.messageId) &&
                Objects.equals(campaign, that.campaign) &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(messageContent, that.messageContent) &&
                Objects.equals(deliveryStatus, that.deliveryStatus) &&
                Objects.equals(sentAt, that.sentAt) &&
                Objects.equals(channel, that.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, campaign, customer, messageContent, deliveryStatus, sentAt, channel);
    }
}
