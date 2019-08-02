package com.mycompany.model;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.DefaultResourceLoader;

import com.mycompany.constants.Constants;

public class InputCommandsFileLoader {
  private static final DefaultResourceLoader loader = new DefaultResourceLoader();

  static {
    getReadingsInputFile();
  }

  private InputCommandsFileLoader() {}

  public static final File getReadingsInputFile() {
    File file = null;

    try {
      file = loader.getResource(Constants.READINGS_INPUT_FILE_NAME).getFile();
    } catch (final IOException e) {
      e.printStackTrace();
    }

    if (file.exists()) return file;
    else return null;
  }
}
