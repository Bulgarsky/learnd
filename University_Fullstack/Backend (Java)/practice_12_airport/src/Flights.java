import java.util.Objects;

public class Flights <price> {
    private String flightNO;
    private String airportName;
    private String carrierName;
    private String destination;
    private String departureTime;
    private price ticketPrice;

    Flights (){}
    Flights(String flightNO, String airportName, String carrierName, String destination, String departureTime, price ticketPrice) {
        this.flightNO = flightNO;
        this.airportName = airportName;
        this.carrierName = carrierName;
        this.destination = destination;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
    }

    //getters
    public String getFlightNO () { return flightNO;}
    public String getAirportName() {
        return airportName;
    }
    public String getCarrierName() {
        return carrierName;
    }
    public String getDestination() {
        return destination;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public price getTicketPrice() {
        return ticketPrice;
    }

    //Setters
    public void setFlightNO(String flightNO) {
        this.flightNO = flightNO;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public void setTicketPrice(price ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    //methods
    public void printFlightDetails () {
        System.out.println("Рейс ["+getFlightNO()+"] вылет из аэропорта ["+getAirportName()+"], на борту компании ["+getCarrierName()+"], цена билета ["+getTicketPrice()+"]");
    }
    public void printTicket () {
        System.out.println("Ticket ["+getFlightNO()+"], price "+getTicketPrice()+", time "+getDepartureTime()+", "+getDestination()+" from "+getAirportName()+" on "+getCarrierName()+" board\n");
    }

    //methods override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flights<?> flights = (Flights<?>) o;
        return Objects.equals(flightNO, flights.flightNO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNO);
    }

    @Override
    public String toString() {
        return
                "рейс '" + flightNO + '\'' +
                ", из аэропорта '" + airportName + '\'' +
                ", на борту '" + carrierName + '\'' +
                ", пункт назначения '" + destination + '\'' +
                ", время отбытия '" + departureTime + '\'' +
                ", цена билета '" + ticketPrice + "\'"+
                '}';
    }
}
