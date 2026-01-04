/*
package Logica.Manejadores;

import Persistencia.Clases.Usuario;
import Persistencia.FabricaEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UsuarioManejador {
    //asi solo hay un manejador de usuarios, es el patron singleton
    private static UsuarioManejador instancia = null;
    public static UsuarioManejador getInstancia() {
        if (instancia == null)
            instancia = new UsuarioManejador();
        return instancia;
    }

    public Usuario obtenerUsuarioPorNickname(String nickname){
        EntityManager EM = FabricaEntityManager.getEntityManager();
        Usuario usr;
        try {
            TypedQuery<Usuario> query = EM.createQuery("SELECT Usuario FROM usuarios WHERE Usuario.nickname = nickname");
            usr = query.getSingleResult();
        } catch (NoResultException e) {
            usr = null;
        } finally {
            EM.close();
        }
        return usr;
    }
}
*/