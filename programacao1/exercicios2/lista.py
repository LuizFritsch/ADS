import utils as utils
import sys

def isEven(number):
    return number % 2 == 0

def exe1():
    print(isEven(float(input("Digite um numero: "))))

def exe2():
    values = utils.readSomething("Digite o valor", 2, int)
    print("nao da pra dividir por zero :(" if values[1] == 0 else values[0]/values[1])

def isLeapYear(year):
    if(year % 4 == 0):
        return True
    return False

def exe3():
    print(isLeapYear(int(input("digite o ano:"))))

def calculateGrade(grade, weight):
    return grade * weight

def isGrauCNecessary(grades):
    grauAGrade = calculateGrade(grades[0], 0.3)
    grauBGrade = calculateGrade(grades[1], 0.7)
    finalGrade = grauAGrade + grauBGrade
    return finalGrade < 6

def exe4():
    grades = utils.readSomething("Digite a nota", 2, float)
    if (len([num for num in grades if num < 0])!= 0):
        print("Erro: nao aceito numeros negativos ")
        return
    print("Grau C necessario" if isGrauCNecessary(grades) else "Voce passou ja :)")

def isNumeric(s):
    try:
        float(s)
        return True
    except ValueError:
        return False

def isVogal(letter):
    vogals = ["a", "e", "i", "o", "u"]
    if([vogal for vogal in vogals if vogal == letter]):
        return True
    return False

def exe5():
    letter = input("digite uma letra: ")
    if(len(letter) > 1):
        print("vc digitou mais q uma letra :(")
        return
    elif(isNumeric(letter)):
        print("vc digitou um nmr :(")
        return
    print("Vc digitou uma vogal" if isVogal(letter) else "Vc digitou uma consoante")

def printInRange(max):
    for i in range(max):
        print(i)

def exe8():
    printInRange(1001)

def exe9():
    printInRange(2001)

def exe10():
    for i in range(1000, -1, -1):
        print(i)

def exe11():
    values = utils.readSomething("digite o valor", 10, int)
    total = 0
    for value in values:
        total = total + value
    print("O valor total eh: {}".format(total))

def exe13():
    for i in range (1, 101):
        print(i)

def exe14():
    naturalInts = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    userInput = int(input("digite um numero inteiro: "))
    for num in naturalInts:
        print("{} x {} = {}".format(userInput, num, (num*userInput)))

def exe15():
    quantidade = int(input("Quantos produtos deseja adicionar à lista? "))
    lista_de_compras = []

    for i in range(quantidade):
        produto = input(f"Informe o {i+1}º produto: ")
        lista_de_compras.append(produto)

    print("Sua lista de compras é:")
    for produto in lista_de_compras:
        print("- {}".format(produto))

exe = {
    'exe1': exe1,
    'exe2': exe2,
    'exe3': exe3,
    'exe4': exe4,
    'exe5': exe5,
    'exe8': exe8,
    'exe9': exe9,
    'exe10': exe10,
    'exe11': exe11,
    'exe13': exe13,
    'exe14': exe14,
    'exe15': exe15
}

if len(sys.argv) > 1:
    function_name = sys.argv[1]
    if function_name in exe:
        exe[function_name]()
    else:
        print("Exercicio invalido")
else:
    print("Digite um exercicio valido dentro desta lista:")
    for key in exe.keys():
        print(key)



