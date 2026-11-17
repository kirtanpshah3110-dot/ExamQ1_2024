package movietickets;

import com.mycompany.movieticketsales.MovieTickets;
import com.mycompany.movieticketsales.MovieTicketData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTicketsTest {

    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {

        MovieTickets movieTickets = new MovieTickets();

        double result = movieTickets.CalculateTotalTicketPrice(3, 100.0);

        assertEquals(342.0, result, 0.001);
    }

    @Test
    public void ValidateData_InvalidNumberOfTickets_ReturnsFalse() {

        MovieTickets movieTickets = new MovieTickets();

        MovieTicketData ticketData =
                new MovieTicketData("Napoleon", 0, 100.0);

        assertFalse(movieTickets.ValidateData(ticketData));
    }

    @Test
    public void ValidateData_ValidData_ReturnsTrue() {

        MovieTickets movieTickets = new MovieTickets();

        MovieTicketData ticketData =
                new MovieTicketData("Napoleon", 3, 100.0);

        assertTrue(movieTickets.ValidateData(ticketData));
    }
}