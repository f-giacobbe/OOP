import tkinter as tk

#esempio gestione eventi

def on_button_click():
	print("Pulsante cliccato!")

root = tk.Tk()
button = tk.Button(root, text="Click", command=on_button_click)
button.pack()
root.mainloop()