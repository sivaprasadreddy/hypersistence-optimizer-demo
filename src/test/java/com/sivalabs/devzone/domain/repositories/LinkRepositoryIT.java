package com.sivalabs.devzone.domain.repositories;

import com.sivalabs.devzone.domain.entities.Link;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.sivalabs.devzone.utils.TestConstants.PROFILE_IT;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles(PROFILE_IT)
class LinkRepositoryIT {

    @Autowired
    private LinkRepository linkRepository;

    @Test
    void shouldReturnAllLinks() {
        List<Link> allLinks = linkRepository.findAll();
        assertThat(allLinks).isNotNull();
    }
}
