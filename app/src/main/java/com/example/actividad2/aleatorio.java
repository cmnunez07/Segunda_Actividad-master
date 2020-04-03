package com.example.actividad2;

public class aleatorio {

    int Imagen, Sonido;
    long[] pattern;
    String aleatorio;

    public aleatorio(int Imagen,String aleatorio, int sonido, long[] pattern){
        this.Imagen = Imagen;
        this.aleatorio = aleatorio;
        this.Sonido = sonido;
        this.pattern = pattern;
    }

    public int getImagen() {
        return Imagen;
    }

    public String getAleatorio() {
        return aleatorio;
    }

    public int getSonido(){
        return Sonido;
    }

    public long[] getPattern() {
        return pattern;
    }

}
