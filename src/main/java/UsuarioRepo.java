import java.time.LocalDateTime;
import java.util.ArrayList;

public class UsuarioRepo {
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void agregarUsuario(Usuario unUsuario) {
        //falta el metodo para agregar con nombre?
        usuarios.add(unUsuario);
    }

    public void borrarUsuario(Usuario unUsuario) {
        usuarios.remove(unUsuario);
    }

    public void cambiarEstadoCivil(Usuario unUsuario, String unEstadoCivil) {
        unUsuario.EstadoCivil = unEstadoCivil;
    }

    public Usuario getUsuario(String unNombre) {
        for (Usuario unUsuario : usuarios) {
            if (unUsuario.Nombre == unNombre) {
                return unUsuario;
            }
        } throw new RuntimeException("No Existe ese Usuario");
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
