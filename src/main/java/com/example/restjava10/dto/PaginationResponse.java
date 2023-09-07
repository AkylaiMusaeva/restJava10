package com.example.restjava10.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Akylai Musaeva
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
public class PaginationResponse {
    private List<StudentResponse> students;
    private int currentPage;
    private int pageSize;


}
