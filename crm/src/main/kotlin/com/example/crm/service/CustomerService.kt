package com.example.crm.service

import com.example.crm.entity.CustomerEntity
import com.example.crm.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService(@Autowired private val customerRepository: CustomerRepository) {

    // Obtener todos los clientes
    fun getCustomers(): List<CustomerEntity> {
        return customerRepository.findAll()
    }

    // Buscar un cliente por ID
    fun getCustomerById(id: Long): CustomerEntity? {
        return customerRepository.findById(id).orElse(null)
    }

    // Crear un nuevo cliente
    fun createCustomer(customer: CustomerEntity): CustomerEntity {
        return customerRepository.save(customer)
    }

    // Actualizar un cliente existente
    fun updateCustomer(id: Long, updatedCustomer: CustomerEntity): CustomerEntity? {
        val existingCustomer = customerRepository.findById(id).orElse(null)
        return if (existingCustomer != null) {
            // Actualizamos manualmente las propiedades sin usar copy()
            existingCustomer.fullName = updatedCustomer.fullName
            existingCustomer.email = updatedCustomer.email
            existingCustomer.phone = updatedCustomer.phone
            existingCustomer.address = updatedCustomer.address

            customerRepository.save(existingCustomer)
        } else {
            null
        }
    }

    // Eliminar un cliente
    fun deleteCustomer(id: Long): Boolean {
        return if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
