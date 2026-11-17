/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kirta
 */
package com.mycompany.movieticketsales;

public interface IMovieTickets {

    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);

    boolean ValidateData(MovieTicketData movieTicketData);
}
