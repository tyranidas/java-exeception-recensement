package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.exceptions.RecensementException;
import fr.diginamic.exceptions.RechercherPopBorneServiceException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws RecensementException {
		
			
		
		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();
		if (choix == null)
		{
			throw new RecensementException("Vous n'avez pas choisi de Département");
		}
		
		List<Ville> villes = rec.getVilles();
		int somme = 0;
		for (Ville ville: villes){
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)){
				somme+=ville.getPopulation();
			}
			
		}
		if (somme<=0){
			throw new RecensementException("Le numéro du département est inconnu");
		}
		
	
		
		
		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		if (!(NumberUtils.isDigits(saisieMin)))
		{
			throw new RecensementException("Veuillez entrer un nombre");
		}
		int min = Integer.parseInt(saisieMin) * 1000;
		
		
	
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		
		String saisieMax = scanner.nextLine();
		if (!(NumberUtils.isDigits(saisieMax)))
		{
			throw new RecensementException("Veuillez entrer un nombre");
		}
		
		int max = Integer.parseInt(saisieMax) * 1000;
		
		if (min < 0   )
		{
			throw new RecensementException("Le minimum doit être supérieur à 0");
		}
		if (max < 0   )
		{
			throw new RecensementException("Le maximum doit être supérieur à 0");
		}
		if ( min > max  )
		{
			throw new RecensementException("Le minimum doit être inférieur au maximum");
		}
		
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
				
			}
			
		}
		
	}

}
