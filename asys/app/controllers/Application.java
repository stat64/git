package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

//para trabajar con login
//public class Application extends GlobalController {
public class Application extends Controller{


	public static void index() {
   		
    		
        render();
    }
	
	public static void list(String search, Integer size, Integer page) {
        List<Usuario> docen = null;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
            docen = Usuario.all().fetch(page, size);
        } else {
            search = search.toLowerCase();
            docen = Usuario.find("lower(nombre) like ?1 OR lower(cedula) like ?2 ", "%"+search+"%", "%"+search+"%").fetch(page, size);
        }
        render(docen, search, size, page);
        System.out.println("Si se llama a la funcion");
    }
	

}