#!/bin/bash

# Loop for para executar o curl 100 vezes
for i in {1..10000}
do
   echo "Executando requisição $i"
   curl http://localhost/pedidos
done
