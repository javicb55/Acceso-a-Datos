package holamundoexcel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javier Collado
 */
public class Hoja {
    private String[][] datos;
    private String nombre;
    private int nFilas;
    private int nColumnas;

    /**
     * Crea una hoja de cálculo nueva
     */
    public Hoja() {
        this.datos     = new String[5][5];
        this.nFilas    = 5;
        this.nColumnas = 5;
        this.nombre    = "";
    }
    
    /**
     * Crea una hoja nueva de tamaño nFilas por nColumnas
     * @param nFilas el número de filas
     * @param nColumnas el número de celdas que tiene cada fila
     */
    public Hoja(int nFilas, int nColumnas) {
        this.datos     = new String[nFilas][nColumnas];
        this.nombre    = "";
        this.nFilas    = nFilas;
        this.nColumnas = nColumnas;
    }
    
    public Hoja(String nombre, int nFilas, int nColumnas) {
        this.datos  = new String[nFilas][nColumnas];
        this.nombre = nombre;
    }    


    public String getDato(int fila, int columna) {
        return datos[fila][columna];
    }

    public void setDato(String dato, int fila, int columna) {
        this.datos[fila][columna] = dato;
        /*
            Hacer una excepción si accedemos a una posición no válida.
        */
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getNFilas() {
        return nFilas;
    }

    public int getNColumnas() {
        return nColumnas;
    }
    
    public boolean compare(Hoja hoja){
        
        boolean iguales = true;
        
        if(this.nColumnas==hoja.getNColumnas() 
                && this.nFilas==hoja.getNFilas()
                && this.nombre.equals(hoja.getNombre())){
            for(int i = 0; i < this.nFilas; i++){
                for(int j = 0; j<this.nColumnas; j++){
                    if(!this.datos[i][j].equals(hoja.getDato(i, j))){
                    iguales = false;
                    break;
                }
            }
            if(!iguales)break;
           }
        }else 
        {
            iguales = false;
        }
        
        return iguales;
        
    }
 
}
