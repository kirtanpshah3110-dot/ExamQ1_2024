/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kirta
 */

package movietickets;

public interface IMovieTickets {

    int TotalMovieSales(int[] movieTicketSales);

    String TopMovie(String[] movies, int[] totalSales);

}