package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CinematicaServlet")
public class CinematicaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        double aceleracion = Double.parseDouble(request.getParameter("aceleracion"));
        double velocidadInicial = Double.parseDouble(request.getParameter("velocidad_inicial"));
        double tiempoAdicional = Double.parseDouble(request.getParameter("tiempo_adicional"));

        // Cálculos
        double velocidadFinal = velocidadInicial + aceleracion * 5; // Velocidad final después de 5 segundos
        double distanciaRecorrida = velocidadInicial * 5 + 0.5 * aceleracion * Math.pow(5, 2); // Distancia en 5 segundos
        double tiempoParaVelocidad = (100 - velocidadInicial) / aceleracion; // Tiempo para alcanzar 100 m/s
        double distanciaParaVelocidad = velocidadInicial * tiempoParaVelocidad + 0.5 * aceleracion * Math.pow(tiempoParaVelocidad, 2); // Distancia para alcanzar 100 m/s

        // Enviar los resultados a la página JSP
        request.setAttribute("aceleracion", aceleracion);
        request.setAttribute("tiempoParaVelocidad", tiempoParaVelocidad);
        request.setAttribute("distanciaRecorrida", distanciaRecorrida);
        request.setAttribute("velocidadFinal", velocidadFinal);
        request.setAttribute("distanciaTotal", distanciaRecorrida + distanciaParaVelocidad);
        request.setAttribute("tiempoAdicional", tiempoAdicional);

        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}
