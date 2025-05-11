class Item:
	def __init__(self, code:int, name:str, price:float):
		if code < 0 and price < 0:
			raise ValueError("Item code/Price must be greater than zero")

		self._code = code
		self._name = name
		self._price = price

	def get_code(self):
		return self._code

	def get_name(self):
		return self._name

	def get_price(self):
		return self._price

	def __str__(self):
		return f"Articolo: {self._name}; Prezzo: {self._price}"

	def __eq__(self, __value):
		if type(self) == type(__value):
			return self.get_code() == __value.get_code()

		return False

	def __hash__(self):
		return self._code * 31

	def __lt__(self, obj):
		return self._name < obj.get_name()