import cv2
import numpy as np

def ajustar_saturacao_valor(imagem, saturacao, valor):
    imagem_hsv = cv2.cvtColor(imagem, cv2.COLOR_BGR2HSV)
    imagem_hsv = np.array(imagem_hsv, dtype=np.float64)
    imagem_hsv[..., 1] *= saturacao / 100.0
    imagem_hsv[..., 2] *= valor / 100.0
    imagem_hsv[..., 1][imagem_hsv[..., 1] > 255] = 255
    imagem_hsv[..., 2][imagem_hsv[..., 2] > 255] = 255
    imagem_hsv = np.array(imagem_hsv, dtype=np.uint8)
    return cv2.cvtColor(imagem_hsv, cv2.COLOR_HSV2BGR)

def ao_mudar_saturacao(val):
    global saturacao
    saturacao = val / 100.0
    atualizar_imagem()

def ao_mudar_valor(val):
    global valor
    valor = val / 100.0
    atualizar_imagem()

def atualizar_imagem():
    imagem_ajustada = ajustar_saturacao_valor(imagem, saturacao * 100, valor * 100)
    cv2.imshow('Imagem Ajustada', imagem_ajustada)

imagem = cv2.imread('imagem.jpg')
saturacao, valor = 1.0, 1.0

cv2.imshow('Imagem Original', imagem)

cv2.namedWindow('Imagem Ajustada')
cv2.createTrackbar('Saturação', 'Imagem Ajustada', 100, 200, ao_mudar_saturacao)
cv2.createTrackbar('Valor', 'Imagem Ajustada', 100, 200, ao_mudar_valor)

atualizar_imagem()

cv2.waitKey(0)
cv2.destroyAllWindows()