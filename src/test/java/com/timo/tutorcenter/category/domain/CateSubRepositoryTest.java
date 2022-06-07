package com.timo.tutorcenter.category.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class CateSubRepositoryTest {

    @Autowired CateSubRepository repository;
    @Autowired CateMainRepository cateMainRepository;

    @Test
    void test() {

        //given
        CateMain cateMain = new CateMain("취미");
        CateSub cateSub = new CateSub("음악", cateMain, 1);

        //when
        CateSub savedCategory = repository.save(cateSub);

        //then
        Assertions.assertThat(savedCategory.getCateMain()).isEqualTo(cateMain);
    }

    @Test
    void findAllByCateMain() {
        //given
        CateMain cateMain = cateMainRepository.findById(1L).get();
        //when
        List<CateSub> list = repository.findAllByCateMainOrderByDisplayOrderAsc(cateMain);
        //then
    }

}