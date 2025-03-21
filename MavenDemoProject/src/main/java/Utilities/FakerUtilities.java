package Utilities;

import com.github.javafaker.Faker;

public class FakerUtilities {
	Faker faker = new Faker();  
 	public String creatARandomFirstName() { 
 	return faker.name().firstName(); 
 	} 
 	
 	public String creatARandomLastName() { 
 	return faker.name().lastName(); 
 	} 
  
 	public String generateAddress() { 
 	return faker.address().fullAddress();  
 	} 

 	public String generateEmail() { 
    return faker.internet().emailAddress();  
 	} 
  
 	public int generateRandomInt(int min, int max) { 
    return faker.number().numberBetween(min, max); 
 	} 

 	public String generateRandomDigits(int count) { 
 	return faker.number().digits(count); 
 	} 

 	public int generateRandomNumber() { 
    return faker.number().randomDigit(); 
 	}
}



//Faker Utilities class used for Username and password generation of random values in case there already exist the provided credentials in page 