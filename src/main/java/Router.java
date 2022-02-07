import spark.Filter;
import spark.Spark;

import static spark.Spark.after;

public class Router {
    public static UsuarioController usuarios = new UsuarioController();
    public static void configure() {
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, HEAD, PUT, PATCH, POST, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Accept");

        });
        Spark.get("/usuario", usuarios::getUsuario);
        Spark.post("/usuario", usuarios::postUsuario);
        Spark.post("/deleteUsuario", usuarios::deleteUsuario); //aca deberia ir un .delete pero #corsproblems
        Spark.post("/putUsuario", usuarios::cambiarEstadoCivil);
        Spark.get("/usuarios", usuarios::getUsuarios);
    }
}
