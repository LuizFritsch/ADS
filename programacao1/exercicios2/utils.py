import math as m
import numpy as np

def readSomething(text, howManyReads, *args):
    """
        text: texto que ira aparecer para cada leitura
        howManyReads: quantidade de leituras
        args: tipo do dado (int ou float)
    """
    values = []
    dataType = args[0]
    i = 0
    while i < howManyReads:
        values.append(input(text+" {}: ".format(i+1)))
        i = i + 1
    if(dataType == int):
        values = [ int(value) for value in values ]
    elif(dataType == float):
        values = [ float(value) for value in values ]
    return values

def multiplication(values):
    return np.prod(values)

def mean(grades):
    total = 0
    for value in grades:
        total = total + value
    return total/len(grades)

def printFinalResult(mean):
    if (mean == 6): 
        print(f"Sua média final é {mean:.2f}. Parabéns! Você passou na média!")
        return
    elif(mean > 6):
        print(f"Sua média final é {mean:.2f}. Parabéns! Você passou acima da média!")
        return
    print(f"Sua média final é {mean:.2f}. Infelizmente você não passou :(")

def convertMToCM(meter):
    return 100 * meter

def calculateArea(radius):
    return 3.14*(radius**2)

def isEven(number):
    return number % 2 == 0 