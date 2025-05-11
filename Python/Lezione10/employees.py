class Employee:
    def __init__(self, name):
        self._name = name

    def get_name(self):
        return self._name

    def weekly_pay(self, hours_worked):
        return 0.0      #classe base (non esistono le classi astratte in python)



class HourlyEmployee(Employee):
    def __init__(self, name, wage):
        super().__init__(name)      #chiamata costruttore superclasse
        self._hourly_wage = wage

    #override implicito
    def weekly_pay(self, hours_worked):
        pay = hours_worked * self._hourly_wage

        if hours_worked > 40:
            #aggiungi straordinari
            pay += ((hours_worked - 40) * 0.5) * self._hourly_wage

        return pay



class SalariedEmployee(Employee):
    def __init__(self, name, salary):
        super().__init__(name)
        self._annual_salary = salary



class Manager(SalariedEmployee):
    def __init__(self, name, salary, bonus):
        super().__init__(name, salary)
        self._weekly_bonus = bonus

    def weeklyPay(self, hours_worked):
        return super().weekly_pay(hours_worked) + self._weekly_bonus