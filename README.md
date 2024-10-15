# Evaluación Parcial - Taller de Programación III (TP3)

## Información del proyecto

### - _Alumnos: Franco David Singer, Elías Jesús Céspedes Osores e Ignacio Julián Castro Centeno_

### - _Nombre del Proyecto: Nectar_

### - _Materia: Taller de Programación III (TP3)_

### - _Profesores: Martín Rivas Sarquis y Luciana Sorbelli_

### - _Fecha de entrega: 15/10/2024 - 19.30hs_

## Preguntas teóricas:

### Link al repositorio: _https://github.com/ignaciocastrocenteno/TP3-Nectar/tree/master_

### Hash del último commit entregado por su grupo: 

### ¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla?: _Implementamos una arquitectura en capas, donde separamos la capa de Front-End (en la carpeta 'screens') y Back-End (en la carpeta 'data'). Luego de haber finalizado la implementación del proyecto, el equipo dio cuenta de que hubiese sido una mejor idea aplicar el patrón de diseño MVVM (Model-View-Viewmodel). Este último podría ser incorporado en una próxima versión futura. _

### Hash del último commit a /master: _be5ebff3e492a179ba89ec196d830f1871559aef_

### ¿Qué mejoras detectan que podrían realizarle a la app? ¿Tendrían side effect si escala el volumen de datos? Comenten al menos 2 cuestiones a refactorizar y tener en cuenta: _Se podría modularizar la renderización de algunos composables que tenían el mismo formato y también aplicar un DataClass de producto generalizado con sus propiedades._

### ¿Qué manejo de errores harían? ¿dónde los contemplan a nivel código? Mencionen la estrategia de mapeo que más se adecúe: _Se realizó un manejo de errores, al momento de establecer la comunicación con la API, sugerida para el proyecto. En caso de que la conexión sea fallida, se informará de manera correspondiente a través de una gestión excepciones._

### En el caso de uso de persistencia para Favoritos, ¿que estrategia sugieren?: _No se utilizó persistencia para la sección de Favoritos._

### Si la tendríamos que convertir a Español y conservar el Inglés, qué estrategia utilizarían para extenderla. Y si necesitamos agregar otros idiomas?: _La mejor estrategia para agregar nuevos idiomas disponibles para la aplicación, sería utilizando un esquema de internacionalización, utilizando etiquetas propias de librerías, para determinar qué componentes y textos deben ser convertidos en tiempo real, del idioma base (español) al idioma de elección del usuario (ej. inglés). Esta metodología se podría llevar adelante para establecer la implementación de varios lenguajes distintos, sobre la aplicación móvil, sin tener la necesidad de crear de forma tradicional, diferentes archivos de código fuente, cada uno con su idioma específico._
