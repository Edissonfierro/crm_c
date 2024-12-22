package com.example.crm.repository

import com.example.crm.entity.LeadEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LeadRepository : JpaRepository<LeadEntity, Long>
