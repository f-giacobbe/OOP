from item import Item
from cash_register_personalizzato import CashRegisterPersonalizzato

mela = Item(80, "mela melinda", 1)
pomodoro = Item(81, "pomodoro", 2)

cr = CashRegisterPersonalizzato("Conad")

cr.add_item(mela)
cr.add_item(mela)
cr.add_item(pomodoro)
print(cr.get_total())
print(cr.get_count())
cr.checkout()