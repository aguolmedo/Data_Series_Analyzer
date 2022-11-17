# TSB_Data_Series_Analyzer



Se pide procesar un set de datos de series obtenido del sitio Kaggle en el link [IMDB TV Series Dataset | Kaggle](https://www.kaggle.com/datasets/harshitshankhdhar/tv-series-dataset). La versión depurada que utiliza este programa se encuentra en un archivo CSV ubicado en /src.

El archivo contiene un registro por línea, con los campos separados por comas, en el siguiente orden:

- Series_Title: título de la serie
- Runtime_of_Series: años inicial y final (si existe) de emisión
- Certificate: calificación
- Runtime_of_Episodes: duración de los episodios
- Genre: género (una cadena separada por pipes conteniendo varios géneros a los que pertenece la serie)
- IMDB_Rating: puntuación de los usuarios en el sitio IMDB
- Overview: argumento
- Star1: nombre de uno de los protagonistas
- Star2: nombre de uno de los protagonistas
- Star3: nombre de uno de los protagonistas
- Star4: nombre de uno de los protagonistas
- No_of_Votes: cantidad de votos recibidos

Utilizando la tabla hash desarrollada en la etapa anterior, con direccionamiento abierto y exploración cuadrática, implementar un índice que permita consultar los datos. La tabla debe contener un elemento por cada género y almacenar: 

- cantidad de series que corresponden al género (un valor)
- listado de las series que corresponden al género (una estructura de datos a elección)
- cantidad de series por puntuación, tomando sólo el valor entero de la misma (una estructura de datos a elección)

La interfaz debe implementarse de forma que permita al usuario elegir de una lista el género que se desea consultar. Una vez seleccionado el género, podrá decidir cuál de las tres dimensiones quiere ver: cantidad de series / detalle de series / cantidad por puntuación.

![image](https://user-images.githubusercontent.com/40676287/202347764-995fefad-cb67-417b-97c5-d7a4ee1b257d.png)

![image](https://user-images.githubusercontent.com/40676287/202347868-48c5875e-13cb-4245-8c5a-efcecacf2835.png)

![image](https://user-images.githubusercontent.com/40676287/202347951-ddac6447-52bc-4ad8-9bc2-974bffd1936b.png)




i love java fx
