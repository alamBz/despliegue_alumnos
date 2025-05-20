package prueba.curso.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.curso.modelo.Modelo;
import prueba.curso.repositorio.IRepositorio;

import java.util.List;

@Service
public class Servicio implements IServicio{
    @Autowired
    private IRepositorio modelo;

    @Override
    public void savePersona(Modelo mod) {
        modelo.save(mod);
    }

    @Override
    public void deletePersona(Integer id) {
        modelo.deleteById(id);
    }

    @Override
    public void editPersona(Integer id, String nombre, String apellido, Integer dni) {
        Modelo persona = this.getModelo(id);
        persona.setId(id);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setDni(dni);

        this.savePersona(persona);

    }

    @Override
    public Modelo getModelo(Integer id) {
        Modelo o = modelo.findById(id).orElse(null);
        return o;
    }

    @Override
    public List<Modelo> getModelos() {
        List<Modelo> listaPersonas = modelo.findAll();
        return listaPersonas;
    }
}
