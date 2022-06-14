import java.io.Serializable;

public class Plane implements Serializable {

    private float fuelLevel;
    private String pilotCallSign;
    private String squadNumber;

    private boolean flaps = true;
    private boolean landingGear = false;
    private boolean ejectionSystem = false;
    private boolean seatOccupation = true;

    public boolean isSeatOccupation() {
        return seatOccupation;
    }

    public Plane(float fuelLevel, String pilotCallSign, String squadNumber) {
        this.fuelLevel = fuelLevel;
        this.pilotCallSign = pilotCallSign;
        this.squadNumber = squadNumber;
    }

    public void toggleFlaps() {
        flaps = !flaps;
        if (flaps == true) {
            System.out.println("Flaps: arriba");
        } else {
            System.out.println("Flaps: abajo");
        }
    }

    public void toggleLandingGear() {
        landingGear = !landingGear;
        if (landingGear == true) {
            System.out.println("Tren de aterrizaje: arriba");
        } else {
            System.out.println("Tren de aterrizaje: abajo");
        }
    }

    public void ejectionSystem() {
        ejectionSystem = !ejectionSystem;
        if (ejectionSystem == true) {
            System.out.println("Estado de sistema de eyección: Armado");
        } else {
            System.out.println("Estado de sistema de eyección: Desarmado");
        }
    }

    public void setSeatOccupation(boolean pilotSeated) {
        seatOccupation = pilotSeated;
        if (ejectionSystem == true) {
            System.out.println("Estado del asiento: Ocupado");
        } else {
            System.out.println("Estado del asiento: Desocupado");
        }
    }

    @Override
    public String toString() {
        return "Plane{" +
                "fuelLevel=" + fuelLevel +
                ", pilotCallSign='" + pilotCallSign + '\'' +
                ", squadNumber='" + squadNumber + '\'' +
                ", flaps=" + flaps +
                ", landingGear=" + landingGear +
                ", ejectionSystem=" + ejectionSystem +
                ", seatOccupation=" + seatOccupation +
                '}';
    }
}
