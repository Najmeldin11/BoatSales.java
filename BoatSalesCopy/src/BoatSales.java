import java.util.Scanner;
public class BoatSales {
	//declaring variables
			static Scanner MyScanner;
			static  String iData;
			static String  oBoatTypes;
			static String  iBoatTypes ;
			static String   iLoops ="Y" ;
			static String  oAccessoryType;
			static double  cMarkupAmount;
			static double  iBoatCost;
			static double  iPrepCost;  
			static double  cAccessoryCost;
			static double  cGrandTotalSales= 0;
			static double  cTax = 0.06;
	        static double  cMarkupChoice;
			static double  cMarkupAMount;
			static double  cSubtotal;
			static double  TAX_RATE;
			static double  cTotal;
			boolean liquor = false;
			static int     iAccessoryType;
			static int     cGrandTotalNumOfSales = 0;
			static int     iQuantity;

public static void main(String[] args) {
	init();
	while (iLoops.equalsIgnoreCase("Y")) {
		input();
		validation();
		calcs();
		output();
		System.out.println("buy mor boats?(Y/N)");
		iLoops = MyScanner.next();
		while (!iLoops.equalsIgnoreCase("Y") && ! iLoops.equalsIgnoreCase("N")) {
		System.out.println(" please enter Y or N, buy mor boats?(Y/N)");
		iLoops = MyScanner.next();
	 }
	}
	closing();
	
}
public static void init() {
	MyScanner = new Scanner (System.in);    //instantiating the MyScanner object
	MyScanner.useDelimiter("\r\n");         //override default of spaces to return 
	
	
}
public static void input() {
	// TODO Auto-generated method stub
	System.out.println("enter boat Type. (B, P, S, C)");
	iBoatTypes = MyScanner.next();
	System.out.println("enter Accessory Type. (1, 2, 3)");
	iData = MyScanner.next();
	try {
		iAccessoryType = Integer.parseInt(iData);
		}
		catch(Exception e) {
		System.out.println(" Accessory Type must be a number. the default of 1 (Electroics)");
		iAccessoryType = 1;
		}
	System.out.println("enter Accessory Type. (1-25)");
	iData = MyScanner.next();
	try {
		iQuantity = Integer.parseInt(iData);
		}
		catch(Exception e) {
		System.out.println(" Quantity must be a number. the default of 1 ");
		iQuantity = 1;
		}
	System.out.println("enter  boat price . ($2,500 - $150,000)");
	iData = MyScanner.next().replaceAll(" ,", "");
	try {
		iBoatCost = Double.parseDouble(iData);
		}
		catch(Exception e) {
		System.out.println(" Boat price  must be a number. the default of $25,000");
		iBoatCost= 25000;
		}
	System.out.println("enter prep Cost  ($100-9999.99$)");
	iData = MyScanner.next().replaceAll(" ,", "");
	try {
		iPrepCost = Double.parseDouble(iData);
		}
		catch(Exception e) {
		System.out.println("  Prep Cost must be a number . the default of  $5,000");
		iPrepCost= 5000;
	}
	}
public static void validation() {
	// TODO Auto-generated method stub
	if(iBoatTypes.equalsIgnoreCase("B") || iBoatTypes.equalsIgnoreCase("P")||
		iBoatTypes.equalsIgnoreCase("S") || iBoatTypes.equalsIgnoreCase("C")) {
	}
	else {
		System.out.println(" Boat Types   must be  B, P, S or C. the default of S (Ski Package)");
		iBoatTypes= "S";
	}
 if( iAccessoryType == 1 || iAccessoryType == 2 ||iAccessoryType == 3 ) {
	 
 }
 else {
	 System.out.println(" Accessory must be  1, 2, Sor 3. the default of 1 (Electronics)");
		iAccessoryType= 1;
		
	} 
 if( iQuantity >25 || iQuantity <1 ) {
	 System.out.println(" Quantity  must be  between 1 & 25. the default of 1 ");
		iQuantity= 1; 
 }
	 


else {
}
if (iBoatCost >150000 || iBoatCost <2500) {
	System.out.println("Boat Cost must be bteween $2,00 & $150,00. Default of $5,000 ");
	iBoatCost = 2500;
}
else {
	
}
if (iPrepCost >9999.99 || iPrepCost <100) {
	System.out.println("Prep Cost must be bteween $100 & $9999,99. Default of $5,000 ");
	iPrepCost = 5000;
}
else {
	
  }
}
public static void calcs() {
    switch (iBoatTypes) {
					 
		case "B":
		
			oBoatTypes = "Bass";
			cMarkupChoice = .33;
			break;
		case "P":
		
			oBoatTypes = "Pontoon";
			cMarkupChoice = .25;
			break;		
		case "S":
		
			oBoatTypes = "Ski";
			cMarkupChoice = .425;
			break;
		case "C":
		
			oBoatTypes = "Canoe";	
			cMarkupChoice = .20;
			break;
    }
					
	switch(iAccessoryType) {
				
				case 1:
					oAccessoryType = "Electronics";
					cAccessoryCost = 5415.3;
					break;
					
				case 2:
					oAccessoryType = "Ski Package";
					cAccessoryCost = 3980;
					break;
					
					
				case 3:
					oAccessoryType = "Fishing Package";
					cAccessoryCost = 345.45;
					break;
					
	}
					
		cMarkupAmount = Math.ceil(iBoatCost*cMarkupChoice*100)/100;
		cSubtotal = Math.round(iBoatCost + cAccessoryCost + iPrepCost + cMarkupAmount)
	* iQuantity * 100 /100.0;
	
	cTax = Math.ceil(cSubtotal * TAX_RATE*100)/100;
	cTotal = cTax + cSubtotal;
	cGrandTotalNumOfSales += 1;
	cGrandTotalSales += Math.ceil(cTotal*100)/100;
}
	
public static void output() {

	
	System.out.println(oBoatTypes+"....." +iBoatCost);	
	System.out.println(oAccessoryType+"....."+cAccessoryCost);
	
	System.out.println("Quantity....." + iQuantity);	
	System.out.println("Prep Cost..... " + iPrepCost);
	System.out.println(" Tax....." +  cTax);	
	System.out.println("Total..... " + Math.round(cTotal*100)/100.0);
	
	System.out.println("Subtotal....." +  cSubtotal);	
	System.out.println("Markup Amount..... " + cMarkupAmount);
	
}
				
			
			
					
					
	public static void closing() {
		// TODO Auto-generated method stub
				
		System.out.println(" Number of sales....." +  cGrandTotalNumOfSales);	
		System.out.println("Total Sales..... " + Math.round(cGrandTotalSales*100)/100.0);
			
		}
	}


