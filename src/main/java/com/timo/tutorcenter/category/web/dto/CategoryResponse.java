package com.timo.tutorcenter.category.web.dto;

import com.timo.tutorcenter.category.domain.CateMain;
import com.timo.tutorcenter.category.domain.CateSub;
import lombok.Getter;

@Getter
public class CategoryResponse {

    private final Long categoryId;

    private final String categoryName;

    public CategoryResponse(CateMain entity) {
        this.categoryId = entity.getId();
        this.categoryName = entity.getName();
    }

    public CategoryResponse(CateSub entity) {
        this.categoryId = entity.getId();
        this.categoryName = entity.getName();
    }
}
