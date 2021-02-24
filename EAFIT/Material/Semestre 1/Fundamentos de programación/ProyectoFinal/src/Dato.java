/**
 * The type Dato.
 */
public class Dato {
    /**
     * The Station.
     */
    String station;
    /**
     * The Name.
     */
    String name;
    /**
     * The Date.
     */
    String date;
    /**
     * The Prcp.
     */
    double prcp;
    /**
     * The Tavg.
     */
    double tavg;
    /**
     * The Tmax.
     */
    double tmax;
    /**
     * The Tmin.
     */
    double tmin;

    /**
     * Instantiates a new Dato.
     *
     * @param station the station
     * @param name    the name
     * @param date    the date
     * @param prcp    the prcp
     * @param tavg    the tavg
     * @param tmax    the tmax
     * @param tmin    the tmin
     */
    public Dato(String station,String name, String date, double prcp, double tavg, double tmax, double tmin ){
        this.station = station;
        this.name = name;
        this.date = date;
        this.prcp = prcp;
        this.tavg = tavg;
        this.tmax = tmax;
        this.tmin = tmin;
    }

    /**
     * Gets station.
     *
     * @return station
     */
    public String getStation() {
        return station;
    }

    /**
     * Gets name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets date.
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets prcp.
     *
     * @return prcp
     */
    public double getPrcp() {
        return prcp;
    }

    /**
     * Gets tavg.
     *
     * @return tavg
     */
    public double getTavg() {
        return tavg;
    }

    /**
     * Gets tmax.
     *
     * @return tmax
     */
    public double getTmax() {
        return tmax;
    }

    /**
     * Gets tmin.
     *
     * @return tmin
     */
    public double getTmin() {
        return tmin;
    }

    /**
     * Gets valor.
     *
     * @param i the
     * @return valor
     */
    public double getValor(int i) {
        switch(i) {
            case 1:
                return getPrcp();
            case 2:
                return getTavg();
            case 3:
                return getTmax();
            case 4:
                return getTmin();
            default:
                System.out.println("Numero no válido");
        }
        return 0;
    }
}
