from cash_register import CashRegister

class CashRegisterPersonalizzato(CashRegister):
	def __init__(self, nome_azienda):
		super().__init__()
		self._nome_azienda = nome_azienda

	def checkout(self):
		print(self._nome_azienda)
		super().checkout()