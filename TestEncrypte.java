import java.util.Scanner;

public class TestEncrypte{
	
	
	//Encode method
	public static void encode(String key, String plainText){
		char deafultValue [] = 	{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
		key += plainText;
		
		//create key value array
		int keyArray [] = new int [plainText.length()];
		for(int i=0; i<plainText.length(); i++){
			for(int j = 0; j<27; j++){
				if(key.charAt(i)==deafultValue[j]){
					keyArray[i] = j;
					break;
				}
			}
		}
		
		//create plain text value array
		int plainTextArray [] = new int [plainText.length()];
		for(int i=0; i<plainText.length(); i++){
			for(int j = 0; j<27; j++){
				if(plainText.charAt(i)==deafultValue[j]){
					plainTextArray[i] = j;
					break;
				}
			}
		}
		
		
		//create cipher text value array
		int cipherTextArray[] = new int [plainText.length()];
		for (int i=0; i<plainText.length(); i++){
			cipherTextArray[i] = keyArray[i] + plainTextArray[i];
			
		}
		//create cipher text
		String cipherText = "";
		for (int i=0; i<plainText.length(); i++){
			for(int j = 0; j<27; j++){
				if(cipherTextArray[i]>27){
					cipherTextArray[i]-=27;
				}
				if(cipherTextArray[i]==j){
					//cipherText[i]= deafultValue[j];
					cipherText += deafultValue[j];
				}
			}
		}
		
		System.out.print("cipherText := ");
		System.out.println(cipherText);
		
	}
	
	//Decode method
	public static void decode(String key, String cipherText){
		
		char deafultValue [] = 	{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
		
		
		//cipherTextConvertValue
		int cipherTextConvertValueArray [] = new int [cipherText.length()];
		for(int i=0; i<cipherText.length(); i++){
			for(int j = 0; j<27; j++){
				if(cipherText.charAt(i)==deafultValue[j]){
					cipherTextConvertValueArray[i] = j;
					break;
				}
			}
		}
		
		//create key value array
		int keyArray [] = new int [cipherText.length()];
		for(int i=0; i<key.length(); i++){
			for(int j = 0; j<27; j++){
				if(key.charAt(i)==deafultValue[j]){
					keyArray[i] = j;
					break;
				}
			}
		}
		
		
		
		//obtain plainText value
		int getPlainTextValueArray[] = new int [cipherText.length()];
		for (int i=0; i<cipherText.length(); i++){
			/*if (i<key.length()){
				getPlainTextValueArray[i] = cipherTextConvertValueArray[i]-keyArray[i];	
			}
			else{
				getPlainTextValueArray[i] = cipherTextConvertValueArray[i] - getPlainTextValueArray[i-key.length()];	
			}*/
			
			if(i>=key.length()){
				getPlainTextValueArray[i] = cipherTextConvertValueArray[i] - getPlainTextValueArray[i-key.length()];
			}
			else{
				getPlainTextValueArray[i] = cipherTextConvertValueArray[i]-keyArray[i];	
			}
			
		}
		//obtain plainText value
		String getPlainText = "";
		for (int i=0; i<cipherText.length(); i++){
			for(int j = 0; j<27; j++){
				if(getPlainTextValueArray[i]<0){
					getPlainTextValueArray[i]+=27;
				}
				if(getPlainTextValueArray[i]==j){
					//cipherText[i]= deafultValue[j];
					getPlainText += deafultValue[j];
				}
			}
		}
		System.out.print("converting plain text is : ");
		System.out.print(getPlainText);
		
		
		
	}
	
	
	
	
	
	//main method
	public static void main(String args[]){
		Scanner userInput = new Scanner(System.in);
		System.out.println("=======================================================");
		System.out.println("= My implementation of classical encryption technique =");
		System.out.println("========== 2020/CSC/079 - S.M.S. Chathuranga ==========");
		System.out.println("=======================================================");
		System.out.println("");
		char loop;
		do{
			
			System.out.println("Please enter your security key(simple letters) : ");
			String key = userInput.next();
			
			System.out.println("What did you need to Encode or Decode? (e/d) : ");
			char whatDo = userInput.next().charAt(0);
			
			if(whatDo == 'e'){
				System.out.println("Please enter the text you want to encode : ");
				String pText = userInput.next();
				encode(key,pText);

			}
			else{
				System.out.println("Please enter the cipher text you want to decode : ");
				String cText = userInput.next();
				decode(key,cText);

			}
			
			
			
			
			
			System.out.println("Did you need run again? (y/n)");
			
			loop = userInput.next().charAt(0);
		}while(loop =='y');
		
		//System.out.println(encode("abc","hello"));
		
		
		 
	}
}