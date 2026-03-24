package space.luminari_labs.dashboard.controller;

import space.luminari_labs.dashboard.service.EvolutionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/whatsapp")
@CrossOrigin(origins = "*") // Permite peticiones desde Flutter Web o Postman
public class WhatsAppController {

    private final EvolutionApiService evolutionApiService;

    @Autowired
    public WhatsAppController(EvolutionApiService evolutionApiService) {
        this.evolutionApiService = evolutionApiService;
    }

    /**
     * POST: http://localhost:8081/api/whatsapp/crear-instancia?nombreInstancia=cliente_01
     */
    @PostMapping("/crear-instancia")
    public ResponseEntity<String> crearInstancia(@RequestParam String nombreInstancia) {
        String respuestaJson = evolutionApiService.crearInstancia(nombreInstancia);

        if (respuestaJson != null && !respuestaJson.contains("\"error\"")) {
            return ResponseEntity.ok(respuestaJson);
        } else {
            return ResponseEntity.status(400).body(respuestaJson);
        }
    }

    /**
     * GET: http://localhost:8081/api/whatsapp/obtener-qr/cliente_01
     */
    @GetMapping("/obtener-qr/{nombreInstancia}")
    public ResponseEntity<String> obtenerQr(@PathVariable String nombreInstancia) {
        String respuestaJson = evolutionApiService.obtenerQr(nombreInstancia);

        if (respuestaJson != null && !respuestaJson.contains("\"error\"")) {
            return ResponseEntity.ok(respuestaJson);
        } else {
            return ResponseEntity.status(400).body(respuestaJson);
        }
    }
}