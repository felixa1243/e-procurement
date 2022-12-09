package com.enigma.services.interfaces;

import com.enigma.entities.transaction.Trx;
import com.enigma.models.requests.TrxRequest;
import org.springframework.data.domain.Page;

public interface ITrxService{
    Trx create(TrxRequest sale) throws Exception;
    Page<Trx> getAll(int page, int size, String direction, String sortBy);
}
