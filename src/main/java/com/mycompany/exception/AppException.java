package com.mycompany.exception;

public final class AppException extends Exception {
  private static final long serialVersionUID = 1L;

  public AppException() {
    super();
  }

  public AppException(final String message) {
    super(message);
  }

  public AppException(final StringBuilder message) {
    super(message.toString());
  }

  public AppException(final Throwable cause) {
    super(cause);
  }

  public AppException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public AppException(final StringBuffer message, final Throwable cause) {
    super(message.toString(), cause);
  }
}
