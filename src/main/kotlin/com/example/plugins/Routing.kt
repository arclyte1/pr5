package com.example.plugins

import InputRequest
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/{text}") {
            val text = call.parameters["text"]
            val result = text?.let { it1 -> InputRequest(it1, ";").splitByValues() } ?: ""
            call.respondText(result)
        }
        get("/") {
            call.respondText {
                "Работу выполнил: Нематов Алибек Пулатович\n" +
                        "Номер группы: ИКБО-06-20\n" +
                        "Вариант индивидуального задания: 13\n" +
                        "Задача: «Сортировка слов и чисел в тексте».\n"
            }
        }
    }
}
