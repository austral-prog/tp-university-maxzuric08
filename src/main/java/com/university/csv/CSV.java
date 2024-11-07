package com.university.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class CSV<T,U>{
    private List<List<String >> ArchivoCsv = new ArrayList<>();
    private String Csv_toread;
    public CSV(String Csv_toread){
        this.Csv_toread = Csv_toread;
    }
    public List<List<String>> ReadCsv(){
        try (BufferedReader br = new BufferedReader(new FileReader(Csv_toread))) {
            String linea;
            // Leer la primera línea (cabeceras) si es necesario
            String cabecera = br.readLine(); // Puedes omitir esto si no necesitas las cabeceras

            while (((linea = br.readLine()) != null)) {
                String[] datos = linea.split(",");
                List<String> info = new ArrayList<>();
                for (int i = 0; i < datos.length; i++) {
                    String variable = datos[i].trim();
                    info.add(variable);
                    if (i == datos.length - 1) {
                        ArchivoCsv.add(info);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir el número de clase.");
        }
        return ArchivoCsv;

    }
    public abstract String WriteCsv(Map<T,List<U>> info);

}
