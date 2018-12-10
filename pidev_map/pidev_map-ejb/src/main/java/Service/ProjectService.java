package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

import org.json.JSONObject;

import Entities.Project;
import Interfaces.ProjectServiceLocal;
import Interfaces.ProjectServiceRemote;
import Ut.client;

@Stateless
@LocalBean
public  class ProjectService implements ProjectServiceLocal,ProjectServiceRemote {

	@PersistenceContext
	private EntityManager em;


	@SuppressWarnings("unchecked")
	public static List<Project> getAll3() {
		 List<Project> list = new ArrayList<>();
		  
		 client c = new client();
		 try {
		             JSONArray json = client.readJsonFromUrl("http://localhost:54331/Api/affichage?format=json");
		             ArrayList<Project> listePatient = new  ArrayList<>();
		             for (int i = 0, count = json.length(); i < count; i++) {
		             	Project patient = new  Project();
		             
		             
		             	
		             JSONObject obj = (JSONObject)json.get(i);
		             
		             
		             patient.setName(obj.get("Name").toString());
		             
		          
		            // patient.setCours1(obj.get("course").toString());
		             listePatient.add(patient);
		          }
		             System.out.println(listePatient);
		         } catch (Exception e) {
		           
		         }
		 return list;
		 	}
	
		
	@Override
	public  List<Project> getAll() {
		 return em.createQuery("SELECT u from Project u").getResultList();
		
	}
	
	public ProjectService() {
		super();
	}


	@Override
	public List<Project> getAll2() {
		return getAll3();
	}


	      }
	
