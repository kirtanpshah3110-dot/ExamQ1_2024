package movietickets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTicketsTest {

    // Test the total movie ticket sales calculation
    @Test
    public void CalculateTotalSales_ReturnsExpectedTotalSales() {

        MovieTickets movieTickets = new MovieTickets();

        int[] movieTicketSales = {3000, 1500, 1700};

        int expectedTotal = 6200;

        int actualTotal = movieTickets.TotalMovieSales(
                movieTicketSales);

        assertEquals(expectedTotal, actualTotal);
    }

    // Test the top performing movie
    @Test
    public void TopMovieSales_ReturnsTopMovie() {

        MovieTickets movieTickets = new MovieTickets();

        String[] movies = {"Napoleon", "Oppenheimer"};

        int[] totalSales = {6200, 6300};

        String expectedMovie = "Oppenheimer";

        String actualMovie = movieTickets.TopMovie(
                movies, totalSales);

        assertEquals(expectedMovie, actualMovie);
    }
}