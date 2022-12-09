package com.enigma.controllers;

import com.enigma.models.requests.TrxRequest;
import com.enigma.models.responses.CommonResponse;
import com.enigma.services.interfaces.ITrxService;
import org.springframework.beans.factory.annotation.Autowired;
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
//        CommonResponse response = new CommonResponse();
//
//        response.setStatus("OK");
//        response.setFail(false);
//
//        request.setProductId(productId);
//        request.setVendorId(id);
//        response.setContent("");
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        throw new RuntimeException("NOT YET IMPLEMENTED");
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(null);
    }
}
