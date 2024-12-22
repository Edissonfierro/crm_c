package com.example.crm.controller

import com.example.crm.entity.CustomerEntity
import com.example.crm.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController @Autowired constructor(
        private val customerService: CustomerService
) {

        // Obtener todos los clientes
        @GetMapping
        fun getCustomers(): List<CustomerEntity> {
                return customerService.getCustomers()
        }

        // Obtener un cliente por ID
        @GetMapping("/{id}")
        fun getCustomerById(@PathVariable id: Long): CustomerEntity? {
                return customerService.getCustomerById(id)
        }

        // Crear un nuevo cliente
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED) // Establecer código de estado 201 para "creado"
        fun createCustomer(@RequestBody customer: CustomerEntity): CustomerEntity {
                return customerService.createCustomer(customer)
        }

        // Actualizar un cliente existente
        @PutMapping("/{id}")
        fun updateCustomer(@PathVariable id: Long, @RequestBody updatedCustomer: CustomerEntity): CustomerEntity? {
                return customerService.updateCustomer(id, updatedCustomer)
        }

        // Eliminar un cliente
        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT) // Código de estado 204 para "sin contenido"
        fun deleteCustomer(@PathVariable id: Long) {
                if (!customerService.deleteCustomer(id)) {
                        throw RuntimeException("Customer not found")
                }
        }
}
