public class Humanos {
    private String sexo;
    private int anios;

    public Humanos() {
    }

    public Humanos(String sexo, int anios) {
        this.sexo = sexo;
        this.anios = anios;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    @Override
    public String toString() {
        return "Humanos{" +
                "sexo='" + sexo + '\'' +
                "años=" + anios +
                '}';
    }
}
