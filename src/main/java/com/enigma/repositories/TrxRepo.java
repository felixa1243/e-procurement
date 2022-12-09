package com.enigma.repositories;

import com.enigma.entities.transaction.Trx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrxRepo extends JpaRepository<Trx, String> {
}
