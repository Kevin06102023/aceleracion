Proyecto: Cinemática y Movimiento Rectilíneo Uniformemente Acelerado (MRUA)

Descripción del Proyecto

Este proyecto es una aplicación web desarrollada con Java, utilizando Servlets y JSP, que permite realizar cálculos sobre el Movimiento Rectilíneo Uniformemente Acelerado (MRUA). La aplicación permite a los usuarios ingresar datos de aceleración, velocidad inicial y tiempo adicional para calcular la velocidad final, distancia recorrida y el tiempo necesario para alcanzar una velocidad determinada.

Funcionalidades Principales:
1. Calcular el tiempo necesario para alcanzar una velocidad determinada.
2. Determinar la distancia recorrida en ese tiempo.
3. Calcular la velocidad final después de un tiempo adicional de aceleración.
4. Calcular la distancia total recorrida durante ese tiempo adicional.

Tecnologías Utilizadas

- Java: Para la lógica de negocio, utilizando Servlets para procesar la información y JSP para mostrar los resultados.
- Servlets y JSP: Para manejar la lógica de las solicitudes y la presentación de resultados.
- HTML y CSS: Para crear y diseñar la interfaz de usuario.
- Apache Tomcat: Como servidor para desplegar la aplicación.

 Estructura del Proyecto

El proyecto está organizado en varias partes clave:

1. Formulario HTML (index.html): Recibe los datos del usuario, tales como la aceleración, la velocidad inicial y el tiempo adicional para la aceleración.
2. Servlet Java (CinematicaServlet.java): Procesa los datos recibidos desde el formulario HTML, realiza los cálculos de cinemática y redirige a la página JSP con los resultados.
3. Página JSP (resultado.jsp): Muestra los resultados calculados al usuario.
4. CSS (style.css): Estiliza la interfaz de usuario para mejorar la experiencia visual.

Cálculos de Cinemática

Las ecuaciones utilizadas para los cálculos son las siguientes:

- Tiempo para alcanzar una velocidad determinada:  
  \( t = \frac{v - v_0}{a} \)
  
- Distancia recorrida en ese tiempo:  
  \( d = v_0 t + \frac{1}{2} a t^2 \)
  
- Velocidad final después de un tiempo adicional:  
  \( v_f = v_0 + at \)
  
- Distancia total recorrida durante el tiempo adicional:  
  \( d_{\text{total}} = v_0 t + \frac{1}{2} a t^2 \)

Ejemplo de Código del Servlet (CinematicaServlet.java)

@WebServlet("/CinematicaServlet")
public class CinematicaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double aceleracion = Double.parseDouble(request.getParameter("aceleracion"));
        double velocidadInicial = Double.parseDouble(request.getParameter("velocidadInicial"));
        double tiempoAdicional = Double.parseDouble(request.getParameter("tiempoAdicional"));

        // Cálculos de cinemática
        double tiempoParaAlcanzarVelocidad = (100 - velocidadInicial) / aceleracion;  // Para 100 m/s
        double distanciaRecorrida = velocidadInicial * tiempoParaAlcanzarVelocidad + 0.5 * aceleracion * Math.pow(tiempoParaAlcanzarVelocidad, 2);
        double velocidadFinal = velocidadInicial + aceleracion * tiempoAdicional;
        double distanciaTotal = velocidadInicial * tiempoAdicional + 0.5 * aceleracion * Math.pow(tiempoAdicional, 2);

        // Establecer los resultados como atributos de solicitud
        request.setAttribute("tiempo", tiempoParaAlcanzarVelocidad);
        request.setAttribute("distancia", distanciaRecorrida);
        request.setAttribute("velocidadFinal", velocidadFinal);
        request.setAttribute("distanciaTotal", distanciaTotal);

        // Redirigir a la página JSP con los resultados
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}

Página JSP para mostrar los resultados (resultado.jsp)

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultados de Cinemática</title>
</head>
<body>
    <h1>Resultados del Movimiento Rectilíneo Uniformemente Acelerado</h1>
    <p>Aceleración: ${aceleracion} m/s²</p>
    <p>Tiempo para alcanzar 100 m/s: ${tiempo} segundos</p>
    <p>Distancia recorrida en ese tiempo: ${distancia} metros</p>
    <p>Velocidad final después de 10 segundos: ${velocidadFinal} m/s</p>
    <p>Distancia total recorrida en esos 10 segundos: ${distanciaTotal} metros</p>
</body>
</html>

Formulario HTML para ingresar los datos (index.html)

<form action="CinematicaServlet" method="post">
    <label for="aceleracion">Aceleración (m/s²):</label>
    <input type="number" id="aceleracion" name="aceleracion" required><br>
    
    <label for="velocidadInicial">Velocidad Inicial (m/s):</label>
    <input type="number" id="velocidadInicial" name="velocidadInicial" value="0" required><br>
    
    <label for="tiempoAdicional">Tiempo Adicional (segundos):</label>
    <input type="number" id="tiempoAdicional" name="tiempoAdicional" required><br>
    
    <input type="submit" value="Calcular">
</form>
Estilos CSS (style.css)

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 20px;
    background-color: #f4f4f4;
}

h1 {
    color: #333;
}

label, p {
    font-size: 1.2em;
}

input[type="number"], input[type="submit"] {
    padding: 10px;
    margin: 10px 0;
    width: 100%;
    max-width: 300px;
    font-size: 1em;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}
Configuración del Servidor
Apache Tomcat se configuró como servidor en IntelliJ IDEA para desplegar la aplicación. Asegúrate de tener Tomcat correctamente instalado y configurado en tu entorno de desarrollo para poder ejecutar el proyecto.
Cómo Ejecutar el Proyecto
Clonar el repositorio a tu máquina local o descargalo directamente.

Configura tu IDE (como IntelliJ IDEA):

Instala el plugin de Java.
Asegúrate de tener Tomcat configurado en tu IDE.
Compila y despliega el proyecto en Tomcat desde el IDE.

Accede a la aplicación desde tu navegador en http://localhost:8080/nombre-del-proyecto/ para ingresar los datos y ver los resultados.

Posibles Mejoras Futuras
Validaciones de Formulario: Agregar validaciones para asegurarse de que los valores ingresados sean razonables (por ejemplo, que la aceleración no sea negativa o cero).
Interactividad: Mejorar la experiencia del usuario usando JavaScript para mostrar los resultados sin necesidad de recargar la página.
Soporte para Frenado: Añadir la posibilidad de ingresar un valor negativo para la aceleración (frenado) y ajustar los cálculos en consecuencia.
