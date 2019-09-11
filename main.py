"""Program to learn polish and portuguese."""

import random

def ask_language():
    """ Asks user whether Polish to Portuguese or the other way around"""

    language = input("Type 1 for Portuguese-Polish, or 2 for Polish-Portuguese: ")
    while language not in ['1', '2']:
        return ask_language()
    return language

def create_dict(language):
    """Creates dictionary por-pol if language = 1, otherwise pol-por. """

    dict_por_pol = {
        'oi' : 'czesc',
        'bom dia' : 'dzien dobry',
        'bom' : 'dobrze',
        'cerveja' : 'piwo',
        'adeus' : 'do widzenia',
        'obrigado' : 'dziekuje',
        'por favor' : 'prosze',
        'o que' : 'co',
        'te amo' : 'kocham cie',
        'cansado' : 'zmeczony'
    }
    if language == '1':
        return dict_por_pol
    else:
        return {v:k  for k,v in dict_por_pol.items()}

def quiz(dictionary):
    """Asks the user to guess how a word is in the other language."""

    key = random.choice(list(dictionary.keys()))
    guess = input(("Type the translation of '" + key + "': " ))
    if dictionary[key] == guess:
        print("Congratulations!")
    else:
        print("False. Try again :)")

def main():
    language = ask_language()
    dictionary = create_dict(language)
    while True:
        quiz(dictionary)

if __name__ == '__main__':
    main()
