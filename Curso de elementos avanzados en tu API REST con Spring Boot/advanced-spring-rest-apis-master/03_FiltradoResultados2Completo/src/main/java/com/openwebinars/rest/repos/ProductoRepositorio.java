package com.openwebinars.rest.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.openwebinars.rest.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

	Page<Producto> findByNombreContainsIgnoreCase(String txt, Pageable pageable);

}
