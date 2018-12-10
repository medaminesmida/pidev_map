package Ut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Entities.Project;
import Interfaces.ProjectServiceLocal;
import Interfaces.UserServiceLocal;
import Service.ProjectService;
import Service.UserService;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
client c = new client();
try {
            JSONArray json = c.readJsonFromUrl("http://localhost:54331/Api/affichage?format=json");
            ArrayList<Project> listePatient = new  ArrayList<>();
            for (int i = 0, count = json.length(); i < count; i++) {
            	Project patient = new  Project();
            
            
            	
            JSONObject obj = (JSONObject)json.get(i);
            
            
            patient.setName(obj.get("Name").toString());
         
           // patient.setCours1(obj.get("course").toString());
            listePatient.add(patient);
         }
            System.out.println(listePatient);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}
}