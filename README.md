# Challenge

* Version de java necesaria JAVA 11

### Pasos para ejecutar la aplicación

- Clonarse el proyecto con el comando $ git clone https://github.com/bigfatpancha/challengemli.git

- cd challengemli\mli

- ejecutar el build del projecto con el comando $ mvn package

- correr el jar generado con el comando $ java -jar target/mli-0.0.2.jar

- La aplicación queda corriendo en el puerto 5000


### Endpoints disponibles:
- topsecret
	POST
	
	url: http://localhost:5000/topsecret
	
	Headers:
	```
	undefinedaccept: application/json
	accept-encoding: gzip, deflate
	accept-language: en-US,en;q=0.8
	content-type: application/json
	user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36
	```
	
	Body:
	```
	{
		"satellites": [
			{
				"name": string,
				"distance": float,
				"message": string[]
			}
		]
	}
	```
		
- topsecret_split
	POST
	
	url: http://localhost:5000/topsecret_split/{satellite_name}
	
	Headers:
	```
	undefinedaccept: application/json
	accept-encoding: gzip, deflate
	accept-language: en-US,en;q=0.8
	content-type: application/json
	user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36
	```
	Body:
	```
	{
		"distance": float,
		"message": string[]
	}
	```
	
- topsecret_split
	GET

	url: http://localhost:5000/topsecret_split
	
	Headers:
	```
	undefinedaccept: application/json
	accept-encoding: gzip, deflate
	accept-language: en-US,en;q=0.8
	content-type: application/json
	user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36
	```
	
	
### Comentarios:
- Se tomó como hipótesis que la información de los satélites va a llegar siempre en el mismo orden (kenobi, skywalker, sato). Tanto para el POST topsecret como para la secuencia de POST topsecret_split/{name}
- Se necesita información de los 3 satelites para que el programa encuentre la solucición.
- Si falta información el programa lanzará un error 404, no se pudo encontrar la solución.
- Si la información está completa pero no se puede determinar la posicion o el mensaje el programa lanzará un error 404, no se pudo encontrar la solución.
- Si la información está completa y se puede encontrar la posición y descifrar el mensaje el programa responde con un 200 y el cuerpo de la respuesta tiene la forma 
	{
		"position": {
			"y": float,
			"x": float
		},
		"message": string
	}
	
	
	
Para el calculo de la posicion de la fuenta emisora del mensaje se busca el punto intersección entre los 3 círculos que se forman sabiendo el origen de cada satelite y su radio (la distancia a la fuente).
Para descifrar el mensaje primero se calcula el desfasaje de cada array de palabras, una vez calculado el desfasaje se ubican las palabras en la posicion correcta, luego se arma el mensaje final tomando la palabra correspondiente a cada posicion.


### HOSTING
El servicio se encuentra hosteado en:
http://challenge-env.eba-mwqcgnhc.us-east-2.elasticbeanstalk.com/

### Datos de prueba

topsecret
```
{
  "satellites": [
    {
      "name": "kenobi",
      "distance": 500.0,
      "message": ["", "este", "", "", "mensaje"]
    },
    {
      "name": "skywalker",
      "distance": 282.8427124746,
      "message": ["", "es", "", "", "secreto"]
    },
    {
      "name": "sato",
      "distance": 600.0,
      "message": ["este", "", "un", "", ""]
    }
  ]
}
```


topsecret_split/{kenobi}
```
{
  "distance": 500.0,
  "message": ["", "este", "", "", "mensaje"]
}
```
topsecret_split/{skywalker}
```
{
  "distance": 282.8427124746,
  "message": ["", "es", "", "", "secreto"]
}
```
topsecret_split/{sato}
```
{
  "distance": 600.0,
  "message": ["este", "", "un", "", ""]
}
```
