package com.microservice.impresoras.persistence;
import com.microservice.impresoras.entities.Impresora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpresoraRepository extends JpaRepository<Impresora, Long> {

}