package edu.senac.pe.SistemaBancario_SPRING.repository;

import org.springframework.data.repository.CrudRepository;

import edu.senac.pe.SistemaBancario_SPRING.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

}
