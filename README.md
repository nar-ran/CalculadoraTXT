# Calculadora txt Java
Para este proyecto se podrá calcular mediante un archivo .txt las cuatro (4) operaciones matemáticas básicas, las cuales son:
- Suma (+)
- Resta (-)
- Multiplicación (*)
- División (/)

El archivo deberá ser pasado por el usuario mediante una URL, la URL puede ser local del dispositivo o estar alojada en la web.

Para poder realizar las operaciones del archivo se pasará cada entrada de la calculadora en una línea diferente del archivo.

Al ejecutar el programa y finalizar de leer la última línea del archivo se mostrará por consola la operación que está en el archivo y el resultado de la operación dado el caso de que la estructura sea correcta.
Por el contrario, si el archivo .txt es incorrecto, se mostrará un mensaje de que no se puede realizar las operaciones y debe arreglar la estructura.

## Validaciones y restricciones
- El archivo no puede estar vacío.
- El archivo debe tener al menos una operación.
- El archivo no puede iniciar por un carácter.
- Se validará que el archivo no tenga letras.
- No se puede realizar una división por cero.
- Los decimales deben llevar punto y no comas.
- La operación no puede tener varios signos seguidos.


## Diagrama de clases
Se presenta el diagrama de clases donde se encuentra la estructura del programa.


![Diagrama Clases Calculadora txt Final](https://github.com/nar-ran/CalculadoraTXT/assets/143750294/f666e798-9f14-43d3-bd3a-0653cc1a8d90))
