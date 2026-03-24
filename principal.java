package com.daw.demo_cookies.controladoras;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class principal {

    @GetMapping
    public String inicio() {
        return "index";
    }

    @PostMapping("/crear-cookie")
    public String crearCookie(HttpServletResponse response) {

        // 1 Crear la cookie
        ResponseCookie cuki = ResponseCookie.from("prueba", "contenido de la cookie")
                .maxAge(60)
                .path("/")
                .httpOnly(true) // Seguridad
                .sameSite("lax")
                .build();

        // 2 Añadir la cookie a la cabecera
        response.addHeader(HttpHeaders.SET_COOKIE, cuki.toString());

        return "redirect:/";
    }

    @GetMapping("/crear-otra-cookie")
    public String crearOtraCookie(HttpServletResponse response) {

        // 1er paso .- crear la cookie
        ResponseCookie cuki = ResponseCookie.from("pruebaOtra", "OTRA_cookie")
                .maxAge(60)
                .path("/")
                .httpOnly(true)
                .sameSite("lax")
                .build();

        // 2do paso .- añadir la cookie a la cabecera
        response.addHeader(HttpHeaders.SET_COOKIE, cuki.toString());

        return "redirect:/";
    }

}
