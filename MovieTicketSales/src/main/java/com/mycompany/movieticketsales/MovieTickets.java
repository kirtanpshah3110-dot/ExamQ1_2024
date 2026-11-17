/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kirta
 */
package com.mycompany.movieticketsales;

import com.mycompany.movieticketsales.MovieTicketData;
import com.mycompany.movieticketsales.IMovieTickets;

public class MovieTickets implements IMovieTickets {

    // Calculates the ticket total, including 14% VAT.
    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {

        double subtotal = numberOfTickets * ticketPrice;

        double vat = subtotal * 0.14;

        double totalPrice = subtotal + vat;

        return totalPrice;
    }

    // Validates the information entered by the user.
    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {

        if (movieTicketData == null) {
            return false;
        }

        if (movieTicketData.getMovieName() == null ||
                movieTicketData.getMovieName().trim().isEmpty()) {
            return false;
        }

        if (movieTicketData.getTicketPrice() <= 0) {
            return false;
        }

        if (movieTicketData.getNumberOfTickets() <= 0) {
            return false;
        }

        return true;
    }
}
