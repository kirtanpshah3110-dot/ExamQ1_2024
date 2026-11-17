/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kirta
 */
package movietickets;

public class MovieTickets implements IMovieTickets {

    // Calculate the total ticket sales for a movie
    @Override
    public int TotalMovieSales(int[] movieTicketSales) {

        int total = 0;

        for (int i = 0; i < movieTicketSales.length; i++) {
            total = total + movieTicketSales[i];
        }

        return total;
    }

    // Find the movie with the highest ticket sales
    @Override
    public String TopMovie(String[] movies, int[] totalSales) {

        int highestSales = totalSales[0];
        int highestIndex = 0;

        for (int i = 1; i < totalSales.length; i++) {

            if (totalSales[i] > highestSales) {

                highestSales = totalSales[i];
                highestIndex = i;
            }
        }

        return movies[highestIndex];
    }
}
