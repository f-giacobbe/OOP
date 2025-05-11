from math import gcd
from math import lcm



class Rational:
    def __init__(self, num, den):
        if den == 0:
            raise Exception     #lancio eccezione

        #per convenzione mi porto il segno al numeratore
        if den < 0:
            num *= -1
            den *= -1

        div = gcd(num, den)

        self._num = num // div
        self._den = den // div


    def num(self):
        return self._num


    def den(self):
        return self._den


    def __repr__(self):
        return f'Rational({self._num} / {self._den})'


    #col doppio underscore, sono metodi speciali, in questo caso sostituisce il +
    #da usare solo per concetti strettamente matematici
    def __add__(self, other):

        if isinstance(other, int):
            other_rational = Rational(other, 1)
        elif isinstance(other, Rational):
            other_rational = other
        else:
            raise TypeError("I can only be summed to another Rational or an int")

        m = lcm(self._den, other_rational._den)
        n = self._num * m // self._den + other_rational._num * m // other_rational._den

        return Rational(n, m)



    def __sub__(self, other):
        if isinstance(other, int):
            other_rational = Rational(other, 1)
        elif isinstance(other, Rational):
            other_rational = other
        else:
            raise TypeError("I can only be summed to another Rational or an int")

        m = lcm(self._den, other_rational._den)
        n = self._num * m // self._den - other_rational._num * m // other_rational._den

        return Rational(n, m)


    def __eq__(self, other):
        return self._num == other._num and self._den == other._den

    #minore
    def __lt__(self, other):
        return self._num * other._den < self._den * other._num


    def __ne__(self, other):
        return not self == other


    #per quando avviene il casting a float
    def __float__(self):
        return self._num / self._den