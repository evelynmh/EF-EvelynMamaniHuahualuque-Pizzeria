package com.idat.microservicioidat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.microservicioidat.entity.PizzeriaDetalle;

@Repository
public interface DetallePizzeriaRepository extends JpaRepository<PizzeriaDetalle, Integer>{

}
