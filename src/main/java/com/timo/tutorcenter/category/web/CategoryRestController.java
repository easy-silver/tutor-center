package com.timo.tutorcenter.category.web;

import com.timo.tutorcenter.category.domain.CateMainRepository;
import com.timo.tutorcenter.category.web.dto.CategoryResponse;
import com.timo.tutorcenter.global.web.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategoryRestController {

    private final CateMainRepository cateMainRepository;

    @GetMapping("")
    public SuccessResponse<List<CategoryResponse>> getMainCategories() {
        return SuccessResponse.success(cateMainRepository.findAll()
                .stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList()));
    }

}
