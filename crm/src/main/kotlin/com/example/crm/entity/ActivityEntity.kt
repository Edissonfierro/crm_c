package com.example.crm.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "activity")
class ActivityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "lead_id")
    var lead: LeadEntity? = null,

    @Column(name = "activity_type")
    var activityType: String? = null,

    @Column(name = "activity_date")
    var activityDate: LocalDateTime? = null,

    var notes: String? = null
)
