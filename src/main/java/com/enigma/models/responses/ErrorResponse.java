package com.enigma.models.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse extends AbsResponse {
    public ErrorResponse(String status) {
        setFail(true);
        setStatus(status);
    }
}
