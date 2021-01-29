package com.challenge.mli;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.mli.model.Satellite;

interface SatelliteRepository extends JpaRepository<Satellite, String> {

}
