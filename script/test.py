from pynput.keyboard import Key, Controller
import time

time.sleep(2)
keyboard = Controller()


for i in range(1, 10):
    with keyboard.pressed(Key.alt_r):
        keyboard.press('a')
        keyboard.release('a')
        time.sleep(0.1)

