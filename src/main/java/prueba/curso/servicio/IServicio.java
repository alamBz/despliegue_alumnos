package prueba.curso.servicio;


import prueba.curso.modelo.Modelo;

import java.util.List;

public interface IServicio {
    //alta
    public void savePersona(Modelo mod);

    //baja
    public void deletePersona(Integer id);

    //modificacion
    public void editPersona(Integer id, String nombre, String apellido, Integer dni);

    //lectura de una persona
    public Modelo getModelo(Integer id);

    //lectura de personas
    public List<Modelo> getModelos();
}
