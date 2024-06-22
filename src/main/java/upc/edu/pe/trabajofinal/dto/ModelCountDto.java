package upc.edu.pe.trabajofinal.dto;

public class ModelCountDto {
    private String modelo;
    private Long cantidad;

    public ModelCountDto() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public ModelCountDto(String modelo, Long cantidad) {
        this.modelo = modelo;
        this.cantidad = cantidad;
    }
// Constructores, getters y setters


}
