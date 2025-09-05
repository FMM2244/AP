package com.finalassignment.tests;

import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Shared test utilities for working with temporary copies of resource files.
 *
 * IMPORTANT: Tests must copy dataset files from src/test/resources into a temp directory
 * to avoid mutating originals. Use copyResourceToTemp(...) to get a Path for each file.
 */
public abstract class TestBase {
    @TempDir
    Path tmp;

    protected Path copyResourceToTemp(String resourceName) throws IOException {
        Path target = tmp.resolve(resourceName);
        try (InputStream in = getClass().getResourceAsStream("/" + resourceName)) {
            if (in == null) {
                throw new IOException("Resource not found: " + resourceName + ". Place a copy under src/test/resources.");
            }
            Files.copy(in, target);
        }
        return target;
    }

    protected List<String> readAll(Path p) throws IOException {
        return Files.readAllLines(p);
    }
}

