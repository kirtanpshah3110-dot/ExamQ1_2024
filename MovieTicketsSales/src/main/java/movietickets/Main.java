/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kirta
 */
package movietickets;

public class Main {

    public static void main(String[] args) {

        // Create an object of MovieTickets
        MovieTickets movieTickets = new MovieTickets();

        // Single-dimensional array for movie names
        String[] movies = {"Napoleon", "Oppenheimer"};

        // Single-dimensional array for months
        String[] months = {"JAN", "FEB", "MAR"};

        // Two-dimensional array for movie ticket sales
        int[][] movieTicketSales = {
            {3000, 1500, 1700},
            {3500, 1200, 1600}
        };

        // Array to store total sales for each movie
        int[] totalSales = new int[movies.length];

        // Calculate the total sales for each movie
        for (int i = 0; i < movies.length; i++) {

            totalSales[i] = movieTickets.TotalMovieSales(
                    movieTicketSales[i]);
        }

        // Display the movie ticket sales report
        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println();

        System.out.printf("%-15s", "");

        for (int i = 0; i < months.length; i++) {
            System.out.printf("%-10s", months[i]);
        }

        System.out.println();

        System.out.println("--------------------------------------------");

        // Display movie names and monthly ticket sales
        for (int i = 0; i < movies.length; i++) {

            System.out.printf("%-15s", movies[i]);

            for (int j = 0; j < movieTicketSales[i].length; j++) {

                System.out.printf("%-10d", movieTicketSales[i][j]);
            }

            System.out.println();
        }

        System.out.println();

        // Display total sales for each movie
        for (int i = 0; i < movies.length; i++) {

            System.out.println("Total movie ticket sales for "
                    + movies[i] + " " + totalSales[i]);
        }

        System.out.println();

        // Find and display the top performing movie
        String topMovie = movieTickets.TopMovie(movies, totalSales);

        System.out.println("Top performing movie: " + topMovie);
    }
}