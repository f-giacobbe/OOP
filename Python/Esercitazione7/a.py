import tkinter as tk

#creazione della finestra principale
root = tk.Tk()
root.title("A")

#aggiunta etichetta
label = tk.Label(root, text="Ciao")
label.pack()

#avvio del loop pricncipale
root.mainloop()
