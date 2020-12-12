package com.sivalabs.devzone;

import com.sivalabs.devzone.domain.models.LinksDTO;
import com.sivalabs.devzone.domain.services.LinkService;
import io.hypersistence.optimizer.HypersistenceOptimizer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ApplicationTest /*extends AbstractIntegrationTest*/ {
    @Autowired
    private HypersistenceOptimizer hypersistenceOptimizer;

    @Autowired
    private LinkService linkService;

    @Test
    void shouldReturnPagedLinks() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        LinksDTO linksDTO = linkService.getAllLinks(pageable);
        assertThat(linksDTO.getData()).isNotEmpty();
    }

    @AfterEach
    void afterEach() {
        System.out.println(hypersistenceOptimizer.getEvents().size());
        assertTrue(hypersistenceOptimizer.getEvents().isEmpty());
    }
}
