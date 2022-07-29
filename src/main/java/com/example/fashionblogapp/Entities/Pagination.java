package com.example.fashionblogapp.Entities;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public  class Pagination {
    private int pageNumber = 0;
    private int pageSize = 2;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "design";
}
