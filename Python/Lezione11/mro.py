class D:
	pass

#viene restituita la linearizzazione (method resolution order)
print(D.mro())

#a volte capita che non si riesca a creare una classe con certi genitori in quanto Python non
#riesce a creare un method resolution order (non riesce a linearizzare)