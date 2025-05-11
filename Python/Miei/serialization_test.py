import pickle

class Persona:
    def __init__(self, nome: str, cognome: str):
        self._nome = nome
        self._cognome = cognome

    def __repr__(self):
        return self._nome + self._cognome


def carica_persone() -> list[Persona]:
    file = None
    try:
        file = open(Persone.filepath, "rb")
        return pickle.load(file)

    except IOError or FileNotFoundError:
        print("File non trovato. Inizializzo collezione vuota")
        return []

    finally:
        if file is not None:
            file.close()


class Persone:
    filepath: str = "persone.pkl"

    def __init__(self):
        self._collezione = carica_persone()

    def aggiungi_persona(self, persona: Persona) -> None:
        self._collezione.append(persona)

    def salva_persone(self) -> None:
        with open(Persone.filepath, "wb") as file:
            pickle.dump(self._collezione, file)

    def stampa_persone(self):
        for persona in self._collezione:
            print(persona)




if __name__ == "__main__":
    p1 = Persona("Francesco", "Giacobbe")
    p2 = Persona("Isiria", "Agresta")

    persone = Persone()
    persone.aggiungi_persona(p1)
    persone.aggiungi_persona(p2)
    persone.salva_persone()

    persone.stampa_persone()
