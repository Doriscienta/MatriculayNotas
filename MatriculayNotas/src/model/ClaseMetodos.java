package model;

public class ClaseMetodos {
	
	public String Curso1(int indice)
	{	String c1="";
		switch(indice)
		{	case 0: c1="Org y admi"; break;
			case 1: c1="Admin. redes"; break;
			case 2: c1="Logica program"; break;
			case 3: c1="Taller prom distri"; break;
			case 4: c1="Diseño grafico"; break;
			case 5: c1="Diseño web"; break;
		}
		return c1;
	}
	
	public String Curso2(int indice)
	{	String c2="";
		switch(indice)
		{	case 0: c2="TICS"; break;
			case 1: c2="Reparacion PC"; break;
			case 2: c2="Analisis"; break;
			case 3: c2="Taller prom concur"; break;
			case 4: c2="Multmedia"; break;
			case 5: c2="Program moviles"; break;
		}
		return c2;
	}
	public String Curso3(int indice)
	{	String c3="";
		switch(indice)
		{	case 0: c3="Logica"; break;
			case 1: c3="Coomuicacion"; break;
			case 2: c3="Base datos"; break;
			case 3: c3="Ingles 1"; break;
			case 4: c3="Ingles 2"; break;
			case 5: c3="Multimedia avanza"; break;
		}
		return c3;
	}
	public String Curso4(int indice)
	{	String c4="";
		switch(indice)
		{	case 0: c4="matematica"; break;
			case 1: c4="Lenguaje"; break;
			case 2: c4="Modelamiento"; break;
			case 3: c4="Oracle"; break;
			case 4: c4="Android"; break;
			case 5: c4="Mviles avanzado"; break;
		}
		return c4;
	}
	public double promedio(double n1,double n2, double n3, double n4)
	{	double pro= (n1+n2+n3+n4)/4;
		pro=Math.round(pro);		
		return pro;
	}
	public String observ(double pro)
	{	String obs="";
		if(pro >=0 && pro<=12.4)
			obs="Desaprobado";
		else
			obs= "Aprobado";
		return obs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
