package space.luminari_labs.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.luminari_labs.dashboard.entity.Usuario;
import space.luminari_labs.dashboard.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/buscarPorId")
    public Usuario listTags(@RequestParam Long id) {

    return service.buscarPorId(id);
    }
}
