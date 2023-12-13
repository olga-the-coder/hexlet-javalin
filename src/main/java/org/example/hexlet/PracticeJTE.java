package org.example.hexlet;

import io.javalin.Javalin;

public class PracticeJTE {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> ctx.render("index.jte"));
        app.start(7070);
    }
}
