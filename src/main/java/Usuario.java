import java.time.LocalDate;

public class Usuario {
    public String Nombre;
    public LocalDate Nacimiento;
    public String Sexo;
    public String EstadoCivil;

    public Usuario(String unNombre,int year,int month,int day,String unGenero, String unEstado){
        Nombre = unNombre;
        Nacimiento = LocalDate.of(year,month,day);
        Sexo = unGenero;
        EstadoCivil = unEstado;
    }
    public void setEstadoCivil (String unEstadoCivil) {EstadoCivil = unEstadoCivil;}
}
