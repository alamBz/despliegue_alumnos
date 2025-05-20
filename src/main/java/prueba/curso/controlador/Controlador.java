package prueba.curso.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import prueba.curso.modelo.Modelo;
import prueba.curso.servicio.IServicio;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    private IServicio personaservi;

    @GetMapping("/")
    public String home() {
        return "API funcionando";
    }

    @PostMapping("/añadir")
    public String añadirPersona(@RequestBody Modelo per){
        personaservi.savePersona(per);
        return "Persona añadida correctamente!";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Integer id){
        personaservi.deletePersona(id);
        return "Persona eliminada correctamente!";
    }

    @PutMapping("/modificar/{id}")
    public String modificacionPersona(@PathVariable Integer id, @RequestBody Modelo mod){
        mod.setId(id);
        personaservi.savePersona(mod);
        return "Persona modificada correctamente!";
    }

    @GetMapping("/persona/{id}")
    public Modelo mostrarPersona(@PathVariable Integer id){
        return personaservi.getModelo(id);
    }

    @GetMapping("/personas")
    public List<Modelo> mostrarPersonas(){
        return personaservi.getModelos();
    }
}
