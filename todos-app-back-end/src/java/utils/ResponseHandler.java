/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.google.gson.Gson;
import dtos.ErrorDTO;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;


public class ResponseHandler {

    public static void send(Object dto, StatusCode statusCode, HttpServletResponse resp) throws IOException {

        resp.setHeader("Content-Type", "application/json");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        
        resp.setStatus(statusCode.getCode());
        resp.getWriter().write(new Gson().toJson(dto));
    }

    public static void sendOk(Object dto, HttpServletResponse resp) throws IOException {

        ResponseHandler.send(dto, StatusCode.OK, resp);
    }

    public static void sendBadRequest(String msg, HttpServletResponse resp) throws IOException {

        ResponseHandler.send(new ErrorDTO(msg, StatusCode.BAD_REQUEST), StatusCode.BAD_REQUEST, resp);
    }

    public static void sendInternalServerError(String msg, HttpServletResponse resp) throws IOException {

        ResponseHandler.send(new ErrorDTO(msg, StatusCode.INTERNAL_SERVER_ERROR), StatusCode.INTERNAL_SERVER_ERROR, resp);
    }
}
