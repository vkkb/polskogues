"""Program to learn polish and portuguese."""

import random

class Game(object):
    def __init__(self):
        self.score=0
        self.language = self.ask_language()
        self.dictionary = self.create_dict()
        self.start()
        
    def start(self):
        while len(self.dictionary)>0:
            self.quiz()
        print("Game over!")
        

    def ask_language(self):
        """ Asks user whether Polish to Portuguese or the other way around"""

        language = input("Type 1 for Portuguese-Polish, or 2 for Polish-Portuguese: ")
        while language not in ['1', '2']:
            return self.ask_language()
        return language

    def create_dict(self):
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
            'cansado' : 'zmeczony',
            'vinho' : 'wino',
            'abraçar' : 'przytulic',
            'namorado' : 'chlopak',
            'namorada' : 'dziewczyna',
            'filho' : 'syn',
            'filha' : 'corka',
            'coração' : 'serce'            
        }
        if self.language == '1':
            return dict_por_pol
        else:
            return {v:k  for k,v in dict_por_pol.items()}

    def quiz(self):
        """Asks the user to guess how a word is in the other language."""

        dictionary=self.dictionary
        key = random.choice(list(dictionary.keys()))
        guess = input(("Type the translation of '" + key + "': " ))
        if dictionary[key] == guess:
            print("Congratulations!")
            self.score += 1
            print("Your score is", self.score)
        else:
            print("False. Try again :)")
            self.score -= 1
            print("Your score is", self.score)
        self.dictionary.pop(key)
        
def main():
    polskogues = Game()
    
    

if __name__ == '__main__':
    main()
