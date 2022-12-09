package com.enigma.models.responses;

import lombok.Data;

@Data
public abstract class AbsResponse{
    protected String status;
    protected boolean isFail;
}
