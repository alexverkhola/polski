from tkinter import *
from tkinter.filedialog import *
from tkinter.messagebox import *
from tkinter.font import Font
from tkinter.scrolledtext import *
import file_menu
import edit_menu
import format_menu
import help_menu

root = Tk()

root.title("TextEditor-newfile")
root.geometry("300x250+0+0")
root.minsize(width=1500, height=800)

text = ScrolledText(root, state='normal', height=400, width=400, wrap='word', pady=20, padx=30, undo=True)
text.pack(fill=Y, expand=1)
text.focus_set()

menubar = Menu(root)

file_menu.main(root, text, menubar)
edit_menu.main(root, text, menubar)
format_menu.main(root, text, menubar)
help_menu.main(root, text, menubar)
root.mainloop()
