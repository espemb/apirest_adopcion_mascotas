package com.proyectofinal.data;

import java.util.Optional;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.proyectofinal.model.Mascota;

public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long> {

	Optional<Mascota> findMascotaByNombre(String nombre);


} 