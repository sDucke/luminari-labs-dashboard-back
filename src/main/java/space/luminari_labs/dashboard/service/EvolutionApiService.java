package space.luminari_labs.dashboard.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EvolutionApiService {

    // URL de tu Evolution API y tu Global API Key.
    // Nota: Para producción, es mejor mover estos valores al archivo
    // application.properties
    private final String baseUrl = "http://evoapi.luminari-labs.space";
    private final String globalApiKey = "9P30CB28DRB5";
    private final RestTemplate restTemplate;

    public EvolutionApiService() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Crea una nueva instancia en Evolution API y devuelve el QR
     */
    public String crearInstancia(String nombreInstancia) {
        String endpoint = baseUrl + "/instance/create";

        // Cabeceras
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apikey", globalApiKey);

        // Cuerpo (Body) con los parámetros obligatorios
        Map<String, Object> body = new HashMap<>();
        body.put("instanceName", nombreInstancia);
        body.put("qrcode", false);
        body.put("integration", "WHATSAPP-BAILEYS"); // El motor requerido por Evolution API

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(endpoint, request, String.class);
            return response.getBody();
        } catch (Exception e) {
            System.err.println("Error al crear la instancia: " + e.getMessage());
            return "{\"error\": \"Error al crear la instancia en Evolution API\"}";
        }
    }

    /**
     * Obtiene un código QR actualizado para una instancia que ya existe
     */
    public String obtenerQr(String nombreInstancia) {
        String endpoint = baseUrl + "/instance/connect/" + nombreInstancia;

        // Cabeceras (Solo necesitamos la API Key, no hay Body)
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", globalApiKey);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    endpoint,
                    HttpMethod.GET,
                    request,
                    String.class);
            return response.getBody();
        } catch (Exception e) {
            System.err.println("Error al obtener el QR: " + e.getMessage());
            return "{\"error\": \"Error al obtener el QR de Evolution API\"}";
        }
    }
}