import json
from collections import Counter, defaultdict

#esercizio COUNTER: data una lista contare le occorrenze
frutti = ["mela", "pera", "mela", "banana", "pera"]
conteggio = Counter(frutti)
print(conteggio)

#esercizio defaultDict
d = defaultdict(int)
L = [1, 2, 3, 4, 2, 4, 1, 2]
for i in L:
	d[i] += 1
print(d)






#ESEMPIO SERIALIZZAZIONE E DESERIALIZZAZIONE
dizionario = {"nome": "Alice", "eta": 25, "citta": "Roma"}

#serializzazione in json
json_data = json.dumps(dizionario)
print(json_data)

#deserializzazione da json
dizionario_ricostruito = json.loads(json_data)
print(dizionario_ricostruito)
