import colorsys
import tkinter as tk
import colorsys

def rgb_para_hsv(r, g, b):
    r, g, b = r / 255.0, g / 255.0, b / 255.0
    h, s, v = colorsys.rgb_to_hsv(r, g, b)
    return round(h * 360), round(s * 100), round(v * 100)

def rgb_para_hsl(r, g, b):
    r, g, b = r / 255.0, g / 255.0, b / 255.0
    h, l, s = colorsys.rgb_to_hls(r, g, b)
    return round(h * 360), round(s * 100), round(l * 100)

def rgb_para_cmyk(r, g, b):
    r, g, b = r / 255.0, g / 255.0, b / 255.0
    k = 1 - max(r, g, b)
    c = (1 - r - k) / (1 - k) if k < 1 else 0
    m = (1 - g - k) / (1 - k) if k < 1 else 0
    y = (1 - b - k) / (1 - k) if k < 1 else 0
    return (round(c * 100), round(m * 100), round(y * 100), round(k * 100))


def atualizar_cor(*args):
    r = escala_r.get()
    g = escala_g.get()
    b = escala_b.get()

    cor_rgb = f'#{r:02x}{g:02x}{b:02x}'
    exibir_cor.config(bg=cor_rgb)

    hsv = rgb_para_hsv(r, g, b)
    hsl = rgb_para_hsl(r, g, b)
    cmyk = rgb_para_cmyk(r, g, b)

    label_hsv.config(text=f"HSV: {hsv}")
    label_hsl.config(text=f"HSL: {hsl}")
    label_cmyk.config(text=f"CMYK: {cmyk}")

root = tk.Tk()
root.title("Visualizador de Sistemas de Cores")

escala_r = tk.Scale(root, from_=0, to=255, orient=tk.HORIZONTAL, label='R', command=atualizar_cor)
escala_r.pack()
escala_g = tk.Scale(root, from_=0, to=255, orient=tk.HORIZONTAL, label='G', command=atualizar_cor)
escala_g.pack()
escala_b = tk.Scale(root, from_=0, to=255, orient=tk.HORIZONTAL, label='B', command=atualizar_cor)
escala_b.pack()

exibir_cor = tk.Label(root, text="Cor", bg="white", width=20, height=10)
exibir_cor.pack()

label_hsv = tk.Label(root, text="HSV: ")
label_hsv.pack()

label_hsl = tk.Label(root, text="HSL: ")
label_hsl.pack()

label_cmyk = tk.Label(root, text="CMYK: ")
label_cmyk.pack()

atualizar_cor()

root.mainloop()
