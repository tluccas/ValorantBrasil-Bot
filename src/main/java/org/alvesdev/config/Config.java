package org.alvesdev.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;

@Getter
public class Config {
    private final String token;


    public Config() {
        this.token = System.getenv("BOT_TOKEN");
        if (this.token == null || this.token.isBlank()) {
            throw new IllegalStateException("Token do bot não configurado. Defina a variável de ambiente BOT_TOKEN");
        }
    }
}