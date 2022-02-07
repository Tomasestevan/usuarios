import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.ArrayList;

public class UsuarioController {
    public UsuarioRepo Repo = new UsuarioRepo();

    public String postUsuario(Request req, Response res) {
        Usuario user = new Gson().fromJson(req.body(), Usuario.class);
        Repo.agregarUsuario(user);
        return ("Bienvenido/a");
    }

    public String deleteUsuario(Request req, Response res) {
        Usuario user = new Gson().fromJson(req.body(), Usuario.class);
        Usuario unUser = Repo.getUsuario(user.Nombre);
        Repo.borrarUsuario(unUser);
        return ("Eliminado/a");

    }

    public String getUsuario(Request req, Response res) throws JsonProcessingException {
        Usuario unusuario = new Gson().fromJson(req.body(), Usuario.class);
        Usuario unuser = Repo.getUsuario(unusuario.Nombre);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(unuser);
        return json;
    }

    public String cambiarEstadoCivil(Request req, Response res) throws JsonProcessingException {
        Usuario estadocivil = new Gson().fromJson(req.body(), Usuario.class);
        Usuario cambio = Repo.getUsuario(estadocivil.Nombre);
        if (estadocivil.EstadoCivil != null) {cambio.setEstadoCivil(estadocivil.EstadoCivil);}
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(cambio);
        return json;
    }
    public String getUsuarios(Request req, Response res)throws JsonProcessingException{
        ArrayList<Usuario> unalista = Repo.getUsuarios();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(unalista);
        return json;
    }
}
