class Counter:
    z = 0       #variabile di classe (statica)

    #costruttore (__init__ è un override della classe Object, presente anche in py)
                             #valore di default
    def __init__(self, value = 0):
        self._value = value     #variabile di istanza (per convenzione inizia con _)

    def incr(self):
        self._value += 1
        return self     #restituisce sé stesso

    def get_value(self):
        return self._value

    def reset(self):
        self._value = 0
        return self

    #override del toString
    def __repr__(self):
        return f"value = {self.get_value()}"

c = Counter(3)
c.incr()
print(c.get_value())

#si può fare (non esiste il private in python), ma per convenzione NON si fà (per via del _)
print(c._value)

print(c)



#INHERITANCE
class UpDownCounter(Counter):
    def down(self):
        if self.get_value() > 0:
            self._value -= 1

        return self



count = Counter()
count.incr().incr().incr()  #serve a questo restituire il self

count2 = UpDownCounter()
count2.incr()
count2.incr().down().incr().down()
print(count2)