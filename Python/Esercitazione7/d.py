import tkinter as tk

def on_click():
	print(check_var.get())

root = tk.Tk()

frame = tk.Frame(root)
frame.pack()

check_var = tk.BooleanVar()
checkbutton = tk.Checkbutton(frame, text="Opzione 1", variable=check_var, command=on_click)
checkbutton.pack()

radio_var = tk.StringVar()
radiobutton1 = tk.Radiobutton(frame, text="Opzione A", variable=radio_var, value="A")
radiobutton2 = tk.Radiobutton(frame, text="Opzione B", variable=radio_var, value="B")
radiobutton1.pack(side=tk.LEFT)
radiobutton2.pack(side=tk.RIGHT)


root.mainloop()