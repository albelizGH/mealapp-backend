package com.alejobeliz.pentabyte.projects.mealapp.infra.errores;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorPersonalizado {
        private LocalDateTime timestamp;
        private int status;
        private String message;
        private Map<String, String> errors;

        public ErrorPersonalizado(LocalDateTime timestamp, int status, String message, Map<String, String> errors) {
            this.timestamp = timestamp;
            this.status = status;
            this.message = message;
            this.errors = errors;
        }

}
