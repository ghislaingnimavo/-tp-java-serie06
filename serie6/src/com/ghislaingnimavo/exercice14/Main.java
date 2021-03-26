package com.ghislaingnimavo.exercice14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
			
		
				List<String> strings = new ArrayList<>();
				
				strings.add("one");
				strings.add("two");
				strings.add("three");
				strings.add("four");
				strings.add("five");
				strings.add("six");
				strings.add("seven");
				strings.add("eight");
				strings.add("nine");
				strings.add("ten");
				strings.add("eleven");
				strings.add("twelve");
						
				// Question 1 : 
				System.out.println("\nAffichage de la Liste :\n ");
				strings.stream().forEach(s->System.out.println(s));
				
				// Question 2 : 
				System.out.println("\nAffichage en majuscule :\n ");
				strings.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
				
				// Question 3 :
				System.out.println("\nAffichage des premiere lettre des elements du stream en Majuscule : ");
				strings.stream().map(s -> s.toUpperCase().charAt(0)).distinct().forEach(s -> System.out.println(s));
				
				// Question 4 :
				System.out.println("\nAffiche la longueur de chaque element de liste : ");
				strings.stream().map(s -> s.length()).forEach(s -> System.out.println(s));
				
				// Question 5 :  ici on aura besoin de la fonction size()
				System.out.println("\nAffichage de la taille de ce stream vaut  : " + strings.stream().count());
				
				// Question 6 : 
				System.out.println("\nAffichage des elements pairs de la liste  : ");
				strings.stream().filter(s -> (s.length()%2)==0).forEach(s -> System.out.println(s));
							
				// Question 7 : 
				System.out.println("\nAfficher la longueuer de la chaine la plus longue   : ");
				int n = strings.stream().mapToInt(s -> s.length()).max().orElseThrow();
				System.out.println(n);
				
				// Question 8 : 
				System.out.println("\nListe ne comportant que les chaines de longueur impaires mises en majuscules");
				
				List<String> list = strings.stream().filter(s -> (s.length()%2) == 1)
													.map(s -> s.toUpperCase())
													.collect(Collectors.toList());
				list.forEach(s -> System.out.println(s));
				
				//Question 9
				System.out.println("\nChaine de caractere resultat de la concatenation des chaines de caracteres de longueur inferieures à 5");
				
				String str = strings.stream().filter(s -> s.length() < 6)
									.sorted(Comparator.naturalOrder())
									.collect(Collectors.joining(", ", "{", "}"));
				
				System.out.println(str);
				
				//Question 10
				System.out.println("\nTable de hashage 1");
				
				Map<Integer, List<String>> map = strings.stream().collect(
						Collectors.groupingBy(
								s -> s.length(),
								Collectors.toList()
								)
						);
				map.forEach((k, v) -> System.out.println(k + " : " + v));
				
				//Question 11
				System.out.println("\nTable de hashage 2");
				Map<String, String> map1 = strings.stream().collect(
						Collectors.groupingBy(
								s -> s.substring(0, 1),
								Collectors.joining(", ")
								)
						);
				map1.forEach((k, v) -> System.out.println(k + " : " + v));
				
				}
				
	}

	

