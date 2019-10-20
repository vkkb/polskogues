import os
import tkinter as tk

__location__ = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))
f = os.path.join(__location__, 'BR_PL_logo.gif')

window=tk.Tk()
window.title('polskogues')
canvas = tk.Canvas(window, width = 300, height = 190)
canvas.pack()
my_image = tk.PhotoImage(file=f)
canvas.create_image(0, 0, anchor =tk.NW, image=my_image)
w = tk.Label(window, text="Welcome to our polskogues! Have fun!")
w.pack()
window.mainloop()
           



