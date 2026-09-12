/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import utils.StatusCode;

public class ErrorDTO {

    private final StatusCode status;
    private final String message;

    public ErrorDTO(String message, StatusCode statusCode) {
        this.status = statusCode;
        this.message = message;
    }

    public StatusCode getStatusCode() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
