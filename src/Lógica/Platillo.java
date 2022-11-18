package Lógica;

import java.util.logging.Logger;

/**
 *
 * @author 50236
 */
public class Platillo {
    private int idplatillo;
    private String nombrePlatillo;
    private double precioPlatillo;

    public Platillo(int idplatillo, String nombrePlatillo, double precioPlatillo) {
        this.idplatillo = idplatillo;
        this.nombrePlatillo = nombrePlatillo;
        this.precioPlatillo = precioPlatillo;
    }


    public Platillo() {
    }

    public int getIdplatillo() {
        return idplatillo;
    }

    public void setIdplatillo(int idplatillo) {
        this.idplatillo = idplatillo;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public double getPrecioPlatillo() {
        return precioPlatillo;
    }

    public void setPrecioPlatillo(double precioPlatillo) {
        this.precioPlatillo = precioPlatillo;
    }

    
}
