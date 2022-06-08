package com.timo.tutorcenter.category.web;

import com.timo.tutorcenter.category.domain.CateMain;
import com.timo.tutorcenter.category.domain.CateMainRepository;
import com.timo.tutorcenter.category.domain.CateSubRepository;
import com.timo.tutorcenter.category.web.dto.CategoryResponse;
import com.timo.tutorcenter.global.web.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategoryRestController {

    private final CateMainRepository cateMainRepository;
    private final CateSubRepository cateSubRepository;

    @GetMapping("")
    public SuccessResponse<List<CategoryResponse>> getMainCategories() {
        return SuccessResponse.success(cateMainRepository.findAll()
                .stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{cateMainId}")
    public SuccessResponse<List<CategoryResponse>> getSubCategories(@PathVariable Long cateMainId) {
        CateMain cateMain = cateMainRepository.findById(cateMainId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리"));

        return SuccessResponse.success(cateSubRepository.findAllByCateMain(cateMain)
                .stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList()));
    }

}
