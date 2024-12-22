package com.example.crm.service

import com.example.crm.entity.LeadEntity
import com.example.crm.repository.LeadRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LeadService(@Autowired private val leadRepository: LeadRepository) {

    fun getLeads(): List<LeadEntity> = leadRepository.findAll()

    fun getLeadById(id: Long): LeadEntity? = leadRepository.findById(id).orElse(null)

    fun createLead(lead: LeadEntity): LeadEntity = leadRepository.save(lead)

    fun updateLead(id: Long, updatedLead: LeadEntity): LeadEntity? {
        val existingLead = leadRepository.findById(id).orElse(null)
        return if (existingLead != null) {
            existingLead.fullName = updatedLead.fullName
            existingLead.email = updatedLead.email
            existingLead.phone = updatedLead.phone
            existingLead.status = updatedLead.status
            leadRepository.save(existingLead)
        } else {
            null
        }
    }

    fun deleteLead(id: Long): Boolean {
        return if (leadRepository.existsById(id)) {
            leadRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
