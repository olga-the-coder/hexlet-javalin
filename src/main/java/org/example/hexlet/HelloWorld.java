package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
            if (name == null) {
                ctx.result("Hello World!");
            } else {
                ctx.result("Hello, " + name + "!");
            }
        });
        app.get("/readers/{id}/post/{postId}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).getOrDefault(null);
            ctx.result("Reader Id is " + id + ", post Id is "+ ctx.pathParam("postId"));
        });
        
        app.start(7070);
    }
}