from item import Item

class CashRegister:
	def __init__(self):
		self._total = 0
		self._item_count = 0
		self._item_list = []

	def add_item(self, item):
		self._total += item.get_price()
		self._item_count += 1
		self._item_list.append(item)

	def get_total(self):
		return self._total

	def get_count(self):
		return self._item_count

	def reset(self):
		self._total = 0
		self._item_count = 0
		self._item_list = []

	def checkout(self):
		for item in self._item_list:
			print(item)
		print(f"Totale: {self._total}€")
		self.reset()

	def __hash__(self):
		return self._item_list.__hash__()