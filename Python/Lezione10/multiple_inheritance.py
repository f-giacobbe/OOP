class Base:
	def __init__(self, value):
		print("Enter init of Base")
		self._value = value
		print("Exit init of Base")

	def get_value(self):
		return self._value

	def __repr__(self):
		return f"Base {self._value}"



class C1(Base):
	def __init__(self):
		print("Enter init of C1")
		super().__init__(0)
		print("Exit init of C1")


	def get_value(self):
		rv = super().get_value()
		self._value += 1
		return rv


	def __repr__(self):
		return f"C1 {self._value}"



class C2(Base):
	def __init__(self, val, scale = 1.0):
		print("Enter init of C2")
		super().__init__(val)

		if not isinstance(scale, float):
			raise TypeError()

		self._scale = scale
		print("Exit init of C2")


	def get_value(self):
		return super().get_value() * self._scale

	def __repr__(self):
		return f"C2 {self._value}"



#####esempio multi inheritance
class D(C1, C2):
	def __init__(self, val):
		print("Enter init of D")
		super().__init__()
		print("Exit init of D")


b = Base(3)
print("______")
c1 = C1()
print("______")
c2 = C2(4, 1.5)
print("______")
d = D(25)

#notiamo che entra nella base solo una volta, dunque crea ambiguità in quanto non sapremo se
#poi il valore passato al costruttore Base sarà 0 o val
