import java.util.Random;

public class UnoCard_Class
{
    public String color;
    public int value;
    public String name;
    private Random r;
    private String face;

    public UnoCard_Class(int v, String c)
    {
        value = v;
        color = c; 
    }

    // default constructor Creates a random card
   
    public UnoCard_Class()
    {
        r = new Random();
        value = r.nextInt(11);    
        
               
       
        
        // Assigning color
        r = new Random();
        switch(r.nextInt(4) )
        {
            case 0: color = "Yellow"; 
                break;
                
            case 1: color = "Blue"; 
                break;
                
            case 2: color = "Green"; 
                break;
                
            case 3: color = "Red"; 
                break;
                
        }
        
        // If the card is a +1 or +2 or a wild card
        if(value == 8)
        	{
        	int ch = (int)(Math.random()*2);
        	
        	
        	if(ch == 1)
        		color = "Blue";
        
        	else 
        		color = "Red";
        	}
       
        else if(value == 9)
    	{
    	int ch = (int)(Math.random()*2);
    	
    	
    	if(ch == 1)
    		color = "Blue";
    
    	else 
    		color = "Red";
    	}
    
        
        else if (value >= 10)
            color = "none";
    }

    public String getFace()
    {
        // Returns the card 
         
        face ="";
        
        if (color != "none")
        {
            face += this.color + " ";
        }

        switch(this.value)
        {
            default: face += this.getName() +" "+ String.valueOf(this.value); 
                break;
                
            case 8: face += "Ernie and Bert Draw 1"; 
                break;
            
            case 9: face += "Draw 2"; 
                break;
            
            case 10: face += "Wild (Yellow/ Blue/ Red/ Green)"; 
                break;
        }
        
        return face;
    }

    public String getName()
    {
    	name = "";
    	switch(value)
        {
        	
        case 1: name = "Big Bird";
        	break;
        	
        case 2: name = "Zoe";
        	break;
        
        case 3: name = "Cookie Monster";
        	break;
        	
        case 4: name = "Elmo";
        	break;
        	
        case 5: name = "Baby bear";
        	break;
        	
        case 6: name = "Rosita";
        	break;
        
        case 7: name = "Grover";
        	break;
        
        
        }
    	
    	return name;
    }
    
    
    
    public boolean matches(UnoCard_Class o, String c)
    {
        if (this.color == c)
            return true;
        
        else if (this.value == o.value)
            return true;
        
        else if (this.color == "none") 			// Wild cards
            return true;
        
        return false;
    }
}


