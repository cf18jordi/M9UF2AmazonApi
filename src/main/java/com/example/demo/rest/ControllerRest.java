package com.example.demo.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PresenciasDAO;
import com.example.demo.models.Presencia;

@RestController
@RequestMapping("/")  
public class ControllerRest {
 
@Autowired
  private PresenciasDAO presenciasDAO;
 
@PostMapping  
public ResponseEntity<Presencia> crearPresencia(String name, double latitud, double longitud) {
 
double latAustria = 41.4161732;
double longAustria = 2.1991057;
String comentario = "";
double distancia= distancia(latAustria,longAustria,latitud,longitud);
boolean esta_dentro= distancia<25;

System.out.println(distancia);
 
if (esta_dentro)
comentario="Esta dentro del radio. Ha fichado "+String.format("%.2f",distancia);
else
comentario="Esta fuera del radio. No ha fichado "+String.format("%.2f",distancia);
 
Presencia presencia = new Presencia(name, latitud, longitud);
Presencia newPre = presenciasDAO.save(presencia);
return ResponseEntity.ok(newPre);
 
}
 
@GetMapping("")  
public ResponseEntity<List<Presencia>> getPresencias() {
List<Presencia> presencias = presenciasDAO.findAll();
return ResponseEntity.ok(presencias);
}
 

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double distancia(double lat1,double lon1,double lat2, double lon2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * 6378137;
        return s;
    }
 
}
