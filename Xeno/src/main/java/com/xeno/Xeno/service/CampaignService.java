package com.xeno.Xeno.service;

import com.xeno.Xeno.model.Campaign;
import com.xeno.Xeno.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    // Create or update campaign
    public Campaign saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    // Get all campaigns
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    // Get campaign by ID
    public Optional<Campaign> getCampaignById(Long campaignId) {
        return campaignRepository.findById(campaignId);
    }


    // Find campaigns by status (e.g., DRAFT, SCHEDULED, SENT)
    public List<Campaign> getCampaignsByStatus(String status) {
        return campaignRepository.findByStatus(status);
    }

    // Delete campaign by ID
    public boolean deleteCampaign(Long campaignId) {
        if (campaignRepository.existsById(campaignId)) {
            campaignRepository.deleteById(campaignId);
            return true;
        }
        return false;
    }

    public Optional<Campaign> updateCampaign(Long campaignId, Campaign updatedCampaign) {
        return campaignRepository.findById(campaignId).map(campaign -> {
            campaign.setTitle(updatedCampaign.getTitle());
            campaign.setMessage(updatedCampaign.getMessage());
            campaign.setStatus(updatedCampaign.getStatus());
            campaign.setScheduledAt(updatedCampaign.getScheduledAt());
            campaign.setAudienceTag(updatedCampaign.getAudienceTag());
            // update other fields if needed
            return campaignRepository.save(campaign);
        });
    }


}
