package com.mycompany.util;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;

public class InputCommandsFileLoader {
  private static final Logger log = LogManager.getLogger(InputCommandsFileLoader.class);
  private static final DefaultResourceLoader loader = new DefaultResourceLoader();

  private InputCommandsFileLoader() {}

  public static final File getReadingsInputFile(final String filePath) {
    File file = null;

    try {
      file = loader.getResource(filePath).getFile();
    } catch (final IOException e) {
      log.error("error in parsing the file", e);
    }

    if (file.exists()) return file;
    else return null;
  }
}
