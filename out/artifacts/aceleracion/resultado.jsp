<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Resultados Cinemática</title>
  <link rel="stylesheet" type="text/css" href="style.css"> <!-- Vincula el mismo archivo CSS -->
</head>
<body>

<div class="result-container">
  <h1>Resultados del Movimiento Rectilíneo Uniformemente Acelerado</h1>
  <p>Aceleración: ${aceleracion} m/s²</p>
  <p>Tiempo para alcanzar 100 m/s: ${tiempoParaVelocidad} segundos</p>
  <p>Distancia recorrida en ese tiempo: ${distanciaRecorrida} metros</p>
  <p>Velocidad final después de ${tiempoAdicional} segundos: ${velocidadFinal} m/s</p>
  <p>Distancia total recorrida en esos ${tiempoAdicional} segundos: ${distanciaTotal} metros</p>

  <a href="index.html">Volver al formulario</a>
</div>

</body>
</html>
