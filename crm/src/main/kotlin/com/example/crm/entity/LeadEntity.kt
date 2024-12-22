package com.example.crm.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "leads")  // Cambiar a "leads" para seguir la convención plural de nombres
class LeadEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var fullName: String? = null,
    var email: String? = null,
    var phone: String? = null,

    var status: String? = null,  // Este es el campo que se actualizará

    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")  // Nuevo campo para fecha de actualización
    var updatedAt: LocalDateTime? = null // Nuevo campo
)
