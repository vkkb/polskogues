from tkinter import *
window = Tk()
window.title('polskogues')
canvas = Canvas(window, width = 300, height = 190)
canvas.pack()
my_image = PhotoImage(file='C:\\Users\\Marta\\Documents\\Victor\\Phyton\\BR_PL_logo.gif')
canvas.create_image(0, 0, anchor =NW, image=my_image)
w = Label(window, text="Welcome to our polskogues! Have fun!")
w.pack()

           



