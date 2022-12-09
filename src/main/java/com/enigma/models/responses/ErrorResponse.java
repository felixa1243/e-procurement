package com.enigma.models.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse extends AbsResponse {
    String message;

    public ErrorResponse(String status, String message) {
        setFail(true);
        setStatus(status);
        setMessage(message);
    }
}
