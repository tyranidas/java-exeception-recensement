package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.exceptions.RecensementException;
import fr.diginamic.exceptions.RechercherPopBorneServiceException;
import fr.diginamic.recensement.entites.Recensement;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws RechercherPopBorneServiceException 
	 * @throws RecensementException 
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws RecensementException;
}
