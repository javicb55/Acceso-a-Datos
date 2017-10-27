package holamundoexcel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;



/**
 *  Esta clase almacena información de libros para generar ficheros de Excel
 * Un libro se compone de hojas
 * @author matinal
 */
public class Libro {
    
    private String nombreArchivo;
    private List<Hoja> hojas;
    
    public Libro(){
        this.hojas = new ArrayList<>();
        this.nombreArchivo = "nuevo.xlsx";
    }

    public Libro(String nombreArchivo) {
        this.hojas = new ArrayList<>();
        this.nombreArchivo = nombreArchivo;
    }
    
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public void addHoja(Hoja hoja){
        this.hojas.add(hoja);
    }
    
    public Hoja removeHoja(int index) throws ExcelAPIException{
        if(index < 0 || index>this.hojas.size()){
            throw new  ExcelAPIException("Libro::removeHoja(): Posición no válida.");
        }
        return this.hojas.remove(index);
    }
    
    public Hoja indexHoja(int index) throws ExcelAPIException {
        if(index < 0 || index>this.hojas.size()){
            throw new ExcelAPIException("Libro::removeHoja(): Posición no válida.");
        }
        return this.hojas.remove(index);
    }
    
    public void load(){
        FileInputStream fichero = null;
        
        File miFile = new File(nombreArchivo);
        
        
    }
    
    public void save() throws ExcelAPIException{
        
        SXSSFWorkbook wb = new SXSSFWorkbook();
          
        for(Hoja hoja : this.hojas){
            Sheet sh = wb.createSheet(hoja.getNombre());
            for(int i = 0; i < hoja.getNFilas(); i++){
                Row row = sh.createRow(i);
                for(int j = 0; j < hoja.getNColumnas(); j++){
                    Cell cell = row.createCell(j);
                    cell.setCellValue(hoja.getDato(i, j));
                }
            }
        }
        
        try {
            FileOutputStream out = new FileOutputStream(this.nombreArchivo);
            wb.write(out);
            out.close();                        
        } catch (IOException ex) {
            throw new ExcelAPIException("Error al guardar el archivo");
        } finally {
            wb.dispose();
        }
    }
   
    public void save(String filename) throws ExcelAPIException{
        this.nombreArchivo = filename;
        this.save();
    }
    
    
    private void testExtension(){
        //Comprobar que el nombre de archivo termine en xlsx, sino añadirselo
        
        int finExtension        = nombreArchivo.length() - 1;
        int inicioExtension     = finExtension -5;
        String extensionArchivo = nombreArchivo.substring(inicioExtension, finExtension);
        String miExtension      = ".xlsx";
        
        
        if(!nombreArchivo.equals(miExtension)){
            nombreArchivo += miExtension;
        }
    }
}


