package com.enigma.controllers;

import com.enigma.entities.transaction.Trx;
import com.enigma.models.requests.TrxRequest;
import com.enigma.models.responses.CommonResponse;
import com.enigma.models.responses.PagedResponse;
import com.enigma.services.interfaces.ITrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trx")
public class TransactionController {
    @Autowired
    ITrxService service;

    @PostMapping("make/vendor/{id}/product/{productId}")
    public ResponseEntity addTransaction(@PathVariable String id,
                                         @PathVariable String productId,
                                         @RequestBody TrxRequest request) throws Exception {
        CommonResponse response = new CommonResponse();

        response.setStatus("OK");
        response.setFail(false);

        request.setProductId(productId);
        request.setVendorId(id);
        response.setContent(service.create(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<PagedResponse<Trx>> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "direction", required = false, defaultValue = "ASC") String direction,
            @RequestParam(name = "sortBy", required = false, defaultValue = "trxId") String sortBy
    ) {

        Page<Trx> products = service.getAll(page, size, direction, sortBy);
        PagedResponse<Trx> response = new PagedResponse<>();
        response.setContent(products.toList());
        response.setPage(page);
        response.setSize(size);
        response.setFetchedSize(products.getNumberOfElements());
        response.setTotalSize(products.getTotalElements());
        response.setTotalPage(products.getTotalPages());
        response.setHasNext(products.hasNext());

        return ResponseEntity.status(200).body(response);
    }

}
