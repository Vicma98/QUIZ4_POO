public class Animales {
    private String especie;
    private int anio;

    public Animales() {
    }

    public Animales(String especie, int anio) {
        this.especie = especie;
        this.anio = anio;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getModelo() {
        return anio;
    }

    public void setModelo(int modelo) {
        this.anio = modelo;
    }

    @Override
    public String toString() {
        return "Animales{" +
                "especie='" + especie + '\'' +
                ", años=" + anio +
                '}';
    }
}
