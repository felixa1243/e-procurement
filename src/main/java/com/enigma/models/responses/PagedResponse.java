package com.enigma.models.responses;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PagedResponse <T> {
    private Integer page;
    private Integer size;
    private Integer fetchedSize;
    private Long totalSize;
    private Integer totalPage;
    private List<T> content;
}
