package com.motta.dto;

import java.time.LocalDateTime;

public record TaskRequest(

        String title,
        String email,
        LocalDateTime dueDate,
        boolean notified

) {
}
