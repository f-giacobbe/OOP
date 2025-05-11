import tkinter as tk

#keylogger

def on_key_press(event):
	print(f"Tasto premuto: {event.char}")

def on_mouse_click(event):
	print(f"Click del mouse a ({event.x}, {event.y})")

root = tk.Tk()

root.bind("<KeyPress>", on_key_press)
root.bind("<Button-1>", on_mouse_click)

root.mainloop()