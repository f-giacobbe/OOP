class Denaro:
    tagli_validi = [0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0]
    
    def __init__(self, valore: float = None, quantita: int = None, old: "Denaro" = None):
        if old is not None: #costruttore copia
            self._valore = old._valore
            self._quantita = old._quantita
        else:
            if valore in Denaro.tagli_validi and quantita >= 0:
                self._valore = valore
                self._quantita = quantita
            else:
                raise RuntimeError()


    def __lt__(self, other):
        if not isinstance(other, Denaro):
            raise RuntimeError()

        return self._valore > other.get_valore()

    def get_valore(self):
        return self._valore

    def get_quantita(self):
        return self._quantita

    def get_somma(self):
        return self._valore * self._quantita

    def set_quantita(self, quantita):
        if quantita < 0:
            raise RuntimeError

        self._quantita = quantita

    def __eq__(self, other):
        if not isinstance(other, Denaro):
            raise RuntimeError()

        return self._valore == other.get_valore()

    def __repr__(self):
        return f"Valore:{self._valore}; Quantità:{self._quantita}"

    def __hash__(self):
        return self._valore





class Soldi:
    def __init__(self):
        self._collezione = []

    def totale(self):
        totale = 0
        for d in self._collezione:
            totale += d.get_somma()

        return totale

    def add(self, d):
        #controllo se è già presente il taglio nella collezione
        for den in self._collezione:
            if den.get_valore() == d.get_valore():
                den.set_quantita(den.get_quantita() + d.get_quantita())
                return

        #se non è presente
        self._collezione.append(Denaro(old = d))
        self._collezione.sort()

    def sub(self, d):
        for den in self._collezione:
            if den.get_valore() == d.get_valore():
                if d.get_quantita() > den.get_quantita():
                    raise RuntimeError()

                den.set_quantita(den.get_quantita() - d.get_quantita())
                return

        raise RuntimeError("Taglio non presente")





if __name__ == "__main__":
    banconote_100 = Denaro(100, 4)
    banconote_20 = Denaro(20, 2)

    portafoglio = Soldi()

    portafoglio.add(banconote_20)
    portafoglio.add(banconote_100)

    print(portafoglio.totale())

    portafoglio.sub(Denaro(20, 1))

    print(portafoglio.totale())
    banconote_20.set_quantita(0)
    print(portafoglio.totale())
