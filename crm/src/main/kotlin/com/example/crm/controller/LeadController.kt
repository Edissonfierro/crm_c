package com.example.crm.controller

import com.example.crm.entity.LeadEntity
import com.example.crm.service.LeadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/leads")
class LeadController @Autowired constructor(
    private val leadService: LeadService
) {

    @GetMapping
    fun getLeads(): List<LeadEntity> = leadService.getLeads()

    @GetMapping("/{id}")
    fun getLeadById(@PathVariable id: Long): LeadEntity? = leadService.getLeadById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createLead(@RequestBody lead: LeadEntity): LeadEntity = leadService.createLead(lead)

    @PutMapping("/{id}")
    fun updateLead(@PathVariable id: Long, @RequestBody updatedLead: LeadEntity): LeadEntity? =
        leadService.updateLead(id, updatedLead)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteLead(@PathVariable id: Long) {
        if (!leadService.deleteLead(id)) {
            throw RuntimeException("Lead not found")
        }
    }


}
