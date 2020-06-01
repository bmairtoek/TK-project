### Schema of server:
![Schema](./server_schema.png)


## Run instruction
#### Server:
##### Prerequisites
``Maven``
``sbt``
``Docker``

##### Commands to run: 
``cd server && ./run.sh``

This command will build both server components: ``kafka-producer`` and ``rest-server``. 
After that it will prepare docker images, compose them and run server with containers ports bound to host.

##### Commands for running clients and generators:
Generator1:
``python ./generator1/main.py``
Generator2:
``./generator2/Generator2/MakeAndRun``
Client1:
``./client1/MakeAndRun``
Client2:
``python ./client2/client.py``

#### Required packeges
``librdkafka`` more information in client1 readme
``.NET Core`` more information in generator2 readme

#### Python dependencies
``kafka-python``
``wmi`` only when using real temperature data