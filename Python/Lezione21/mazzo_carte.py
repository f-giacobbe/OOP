import random

semi = ["denari", "bastoni", "spade", "coppe"]
valori = ["asso", "due", "tre", "quattro", "cinque", "sei", "sette", "donna", "cavallo", "re"]

			  ##
mazzo = [last := (valore, seme) for seme in semi for valore in valori]
print(last)
random.shuffle(mazzo)
print(mazzo)