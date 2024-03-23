package edu.umg.jsonSample;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClsJson {
    //convierte un objeto a Json en una linea simple o de un solo elemento

    public String convierteObjetoJson(Object objeto, String archivo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //pasa el archivo y lo guarda
        mapper.writeValue(new File(archivo), objeto);
        //pasa el json a un string
        String jsonString = mapper.writeValueAsString(objeto);
        return jsonString;


    }

    public Object converiteJsonAObjeto(){
        ObjectMapper mapper = new ObjectMapper();
        Object objArchivo = new Object();
        try {
            objArchivo = mapper.readValue(new File("C:\\TMP\\p3.json"), mdBot.class);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());

        }
        return objArchivo;

    }

    //lee un archivo json y lo pone en un objeto de type arraylist
    public ArrayList<mdBot> convierteJsonAObjeto() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<mdBot> listaObjetos = new ArrayList<>();

        try {
            //JSON de archivo a objeto
            listaObjetos = mapper.readValue(new File("C:\\tmp\\fuentes\\file.json"), new TypeReference<ArrayList<mdBot>>(){});
        } catch (Exception ex) {
          //  Logger.getLogger(ClsJson.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error:"+ex.getMessage());
        }
        return listaObjetos;
    }


    //graba en un archivo json un objeto de tipo arraylist
    public String convierteObjetoJson(ArrayList<mdBot> listaObjetos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Pasa el objeto a un archivo y lo guarda
        mapper.writeValue(new File("C:\\tmp\\fuentes\\file.json"), listaObjetos);
        //pasa el json a un string
        String jsonInString = mapper.writeValueAsString(listaObjetos);
        return jsonInString;
    }

//    public static void main(String[] args) {
//        ClsJson objJson = new ClsJson();
//        mdBot botData = new mdBot();
//
//        botData = (mdBot) objJson.converiteJsonAObjeto();
//        System.out.println("nombre= "+botData.getNombre());

//        botData.setNombre("Sergio");
//        botData.setMensaje("Hola");
//        botData.setId(12345678L);
//
//
}



