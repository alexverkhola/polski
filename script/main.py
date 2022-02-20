import time
import random
from pynput import keyboard

#
# open text file 
#
lessonName = "lekcja_1"
file = open("../language_data/" + lessonName)

textArray = []

for line in file:
    textArray.append(line)

print(textArray)



k = keyboard.Controller()  # Create the controller

def type_string_with_delay(string):
    for character in string:  # Loop over each character in the string
        k.type(character)  # Type the character
        delay = random.uniform(0.1, 0.3)  # Generate a random number between 0 and 10
        time.sleep(delay)  # Sleep for the amount of seconds generated

# type_string_with_delay("test message")

def nextLine():
    message = textArray.pop(0).split(":")[1]
    type_string_with_delay(message)

def on_press(key):
    try:
        # print('Alphanumeric key pressed: {0} '.format(key.char))
        pass
    except AttributeError:
        print('special key pressed: {0}'.format(key))

def on_release(key):
    # print('Key released: {0}'.format(key))

    if key == keyboard.Key.esc:
        # Stop listener
        return False

    if key == keyboard.Key.right:
        nextLine()

# Collect events until released
with keyboard.Listener(on_press=on_press, on_release=on_release) as listener:
    listener.join()