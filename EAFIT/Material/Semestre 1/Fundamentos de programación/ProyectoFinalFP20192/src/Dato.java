/**
 * El tipo Dato
 */
public class Dato {

    /**
     * El documento de identidad
     */
    int documento;

    /**
     * El nombre de la pesona
     */
    String nombre;

    /**
     * El apellido de la persona
     */
    String apellido;

    /**
     * El genero de la persona
     */
    String genero;

    /**
     * La edad de la persona
     */
    int edad;

    /**
     * El peso de la persona
     */
    int peso;

    /**
     * La estatura de la persona
     */
    int estatura;

    /**
     * El ritmo cardiaco de la persona
     */
    int ritmoCardiaco;

    /**
     * La presión sistólica de la persona
     */
    int presionSitolica;

    /**
     * La presión diastólica de la persona
     */
    int presionDiastolica;

    /**
     * Si una persona ha sufrido o no
     * de un infarto
     */
    String infarto;

    /**
     * El nivel de azucar glucosa
     * en la sangre de la persona
     */
    int azucar;

    /**
     * Instancia un nuevo Dato.
     *
     * @param documento el numero de documento
     * @param nombre el nombre
     * @param apellido el apellido
     * @param genero el genero
     * @param edad la edad
     * @param peso el peso
     * @param estatura la estatura
     * @param ritmoCardiaco el ritmo cardiaco
     * @param presionSitolica la presion sistolica
     * @param presionDiastolica la presion diastolica
     * @param infarto si ha sufrido o no de infartos
     * @param azucar el nivel de azucar en la sangre
     */
    public Dato(int documento, String nombre, String apellido,
                String genero, int edad, int peso, int estatura,
                int ritmoCardiaco, int presionSitolica,
                int presionDiastolica, String infarto, int azucar) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.ritmoCardiaco = ritmoCardiaco;
        this.presionSitolica = presionSitolica;
        this.presionDiastolica = presionDiastolica;
        this.infarto = infarto;
        this.azucar = azucar;
    }

    /**
     * Devuelve el numero de documento
     * @return documento
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * Modifica el numero de documento
     * @param documento
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * Devuelve el nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Modifica el apellido
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Devuelve el genero
     * @return h si es hombre, m si es mujer
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Modifica el genero
     * @param genero
     */
    public void setGenero(String genero) {
        if (genero == "h" || genero == "m") {
            this.genero = genero;
        } else {
            System.err.println("Género no válido");
        }
    }

    /**
     * Devuelve la edad
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Modifica la edad
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve el peso
     * @return peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Modifica el peso
     * @param peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Devuelve la estatura
     * @return estatura
     */
    public int getEstatura() {
        return estatura;
    }

    /**
     * Modifica la estatura
     * @param estatura
     */
    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    /**
     * Devuelve el ritmo cardiaco
     * @return ritmoCardiaco
     */
    public int getRitmoCardiaco() {
        return ritmoCardiaco;
    }

    /**
     * Modifica el ritmo cardiaco
     * @param ritmoCardiaco
     */
    public void setRitmoCardiaco(int ritmoCardiaco) {
        this.ritmoCardiaco = ritmoCardiaco;
    }

    /**
     * Devuelve la presion sistolica
     * @return presionSistolica
     */
    public int getPresionSitolica() {
        return presionSitolica;
    }

    /**
     * Modifica la presion sistolica
     * @param presionSitolica
     */
    public void setPresionSitolica(int presionSitolica) {
        this.presionSitolica = presionSitolica;
    }

    /**
     * Devuelve la presion diastolica
     * @return presionDiastolica
     */
    public int getPresionDiastolica() {
        return presionDiastolica;
    }

    /**
     * Modifica la presion diastolica
     * @param presionDiastolica
     */
    public void setPresionDiastolica(int presionDiastolica) {
        this.presionDiastolica = presionDiastolica;
    }

    /**
     * Devuelve s si ha tenido infartos
     * o n si no ha tenido infartos.
     * @return infarto
     */
    public String getInfarto() {
        return infarto;
    }

    public void setInfarto(String infarto) {
        if (infarto == "s" || infarto == "n") {
            this.infarto = infarto;
        } else {
            System.err.println("Valor para infarto no válido");
        }
    }

    /**
     * Devuelve el nivel de azucar
     * @return azucar
     */
    public int getAzucar() {
        return azucar;
    }

    /**
     * Modifica el nivel de azucar
     * @param azucar
     */
    public void setAzucar(int azucar) {
        this.azucar = azucar;
    }

    public int getValor(int i) {
        switch (i) {
            case 1:
                return getEdad();
            case 2:
                return getPeso();
            case 3:
                return getEstatura();
            case 4:
                return getRitmoCardiaco();
            case 5:
                return getPresionSitolica();
            case 6:
                return getPresionDiastolica();
            case 7:
                return getAzucar();
            default:
                System.out.println("Numero no valido");
        }
        return 0;
    }
}
