package com.example.crm.service

import com.example.crm.entity.ActivityEntity
import com.example.crm.entity.LeadEntity
import com.example.crm.repository.ActivityRepository
import com.example.crm.repository.LeadRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ActivityService(
    @Autowired private val activityRepository: ActivityRepository,
    @Autowired private val leadRepository: LeadRepository
) {

    fun getActivities(): List<ActivityEntity> = activityRepository.findAll()

    fun getActivityById(id: Long): ActivityEntity? = activityRepository.findById(id).orElse(null)

    fun createActivity(activity: ActivityEntity): ActivityEntity = activityRepository.save(activity)

    fun deleteActivity(id: Long): Boolean {
        return if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id)
            true
        } else {
            false
        }
    }

    fun getActivitiesForLead(leadId: Long): List<ActivityEntity> {
        return activityRepository.findAll().filter { it.lead?.id == leadId }
    }

    // Modificar el estado de un lead
    fun setStatusForLead(leadId: Long, status: String): Boolean {
        val lead = leadRepository.findById(leadId).orElse(null)
        return if (lead != null) {
            lead.status = status
            leadRepository.save(lead)
            true
        } else {
            false
        }
    }
}
