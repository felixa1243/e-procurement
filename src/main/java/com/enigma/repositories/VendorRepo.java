package com.enigma.repositories;

import com.enigma.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepo extends JpaRepository<Vendor, String> {
}
