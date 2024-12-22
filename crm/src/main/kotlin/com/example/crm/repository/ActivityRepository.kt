package com.example.crm.repository

import com.example.crm.entity.ActivityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityRepository : JpaRepository<ActivityEntity, Long>
