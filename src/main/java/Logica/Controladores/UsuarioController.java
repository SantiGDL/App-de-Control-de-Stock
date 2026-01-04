/*
package Logica.Controladores;

import Logica.Manejadores.UsuarioManejador;
import Persistencia.Clases.Usuario;
import Persistencia.DTOs.DTUsuario;

public class UsuarioController {

    @Override
    public void crearUsuario(DTUsuario dtusuario) throws Exception {
        UsuarioManejador UM = UsuarioManejador.getInstancia();
        Usuario u = UM.obtenerUsuarioPorNickname(dtusuario.getNickname());
        if (u != null)
            throw new Exception("El usuario con el nickname " + dtu.getNickname() + " ya esta registrado");

        if (dtu instanceof DTProponente dtp) {
            u = new Proponente(dtp.getNickname(), dtp.getNombre(), dtp.getApellido(),dtp.getPassword(), dtp.getCorreo(), dtp.getImagen(), dtp.getFechaNacimiento(), dtp.getDireccion(), dtp.getBio(), dtp.getSitioWeb());
        } else if (dtu instanceof DTColaborador dtc) {
            u = new Colaborador(dtc.getNickname(), dtc.getNombre(), dtc.getApellido(), dtc.getPassword(), dtc.getCorreo(), dtc.getImagen(), dtc.getFechaNacimiento());
        } else {
            throw new Exception("Tipo de usuario no reconocido");
        }
        mu.persistirUsuario(u);
    }
}
*/