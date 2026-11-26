package com.example.demo.controller;

import com.example.demo.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PeliculaController {

    // Lista compartida entre todos los metodos del Controller.
    private final List<Pelicula> peliculas = new ArrayList<>();

    @GetMapping("/inicializar")
    public String inicializar() {

        // Evitamos duplicados si pulsamos varias veces.
        peliculas.clear();

        peliculas.add(new Pelicula(
                "Titanic",
                "Romance",
                7.9,
                "https://www.imdb.com/title/tt0120338/",
                "/images/titanic.jpg",
                LocalDate.of(1997, 12, 19)
        ));

        peliculas.add(new Pelicula(
                "Interstellar",
                "Ciencia ficcion",
                8.7,
                "https://www.imdb.com/title/tt0816692/",
                "/images/interstellar.jpg",
                LocalDate.of(2014, 11, 7)
        ));

        peliculas.add(new Pelicula(
                "Alien",
                "Terror",
                8.5,
                "https://www.imdb.com/title/tt0078748/",
                "/images/alien.jpg",
                LocalDate.of(1979, 5, 25)
        ));

        return "redirect:/peliculas";
    }

    // Listar todas las peliclas

    @GetMapping("/peliculas")
    public String listarPeliculas(Model model) {

        model.addAttribute("peliculas", peliculas);

        return "peliculas-list";
    }
    // MOSTRAR DETALLE DE UNA PELICULA

    @GetMapping("/peliculas/{id}")
    public String detallePelicula(@PathVariable int id, Model model) {
        if (id < 0 || id >= peliculas.size()) {
            return "redirect:/peliculas";
        }

        Pelicula pelicula = peliculas.get(id);

        model.addAttribute("pelicula", pelicula);

        boolean clasica = pelicula.getFechaEstreno().getYear() < 2000;

        model.addAttribute("clasica", clasica);

        return "peliculas-detail";
    }
    // PAGINA PRINCIPAL

    @GetMapping("/")
    public String home() {
        return "index";
    }
}