package com.mascotas.tienda;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS para todas las rutas
                .allowedOrigins("http://localhost:3000") // Permite solicitudes desde este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite estos métodos HTTP
                .allowedHeaders("*") // Permite todos los encabezados
                .allowCredentials(true); // Permite el envío de credenciales (cookies, encabezados de autorización)
    }
    
}