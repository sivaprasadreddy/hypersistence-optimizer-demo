package com.sivalabs.devzone.config;

import com.sivalabs.devzone.domain.services.LinkService;
import com.sivalabs.devzone.domain.services.LinksImportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final LinkService linkService;
    private final LinksImportService linksImportService;

    @Override
    public void run(String... args) throws Exception {
        linkService.deleteAllLinks();
        linksImportService.importLinks("/data/links.csv");
    }
}
