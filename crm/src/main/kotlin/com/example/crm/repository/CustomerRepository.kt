package com.example.crm.repository

import com.example.crm.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository:JpaRepository<CustomerEntity,Long> {


}