import tkinter as tk

root = tk.Tk()

label1 = tk.Label(root, text="Nome: ")
label1.grid(row=0, column=0)

entry1 = tk.Entry(root)
entry1.grid(row=0, column=1)

root.mainloop()
