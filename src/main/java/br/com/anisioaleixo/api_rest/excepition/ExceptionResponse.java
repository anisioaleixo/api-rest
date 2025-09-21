package br.com.anisioaleixo.api_rest.excepition;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
