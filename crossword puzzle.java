package hw3;

public class Ex3 {

	public static String[] sentence(String s)
	{
		String temp="";
		String[] stringarray=new String [numofwords(s)];
		char n=' ';
		char v='.';
		char c=',';
		int k=0;

		while (s.charAt(k) == n||s.charAt(k) == c||s.charAt(k) == v) {
			k++;
		}
		int i=0;
		for (int j = k; j < s.length(); j++) {
			if (s.charAt(j) != n&&s.charAt(j) != c&&s.charAt(j) != v) {
				temp+=s.charAt(j);
			}
			else {
				if(!temp.isEmpty()&&i!=stringarray.length-1) {
					stringarray[i] = temp;
					temp="";
					i++;
				}
				else if (i==stringarray.length-1&&!temp.isEmpty()) {
					stringarray[i] = temp;
					temp="";
					return stringarray;
				} 
			}
		}
		if (!temp.isEmpty()) {
			stringarray[i] = temp;
			temp="";
		}
		return stringarray;
	}
	public static int numofwords(String s)
	{
		int size=s.length();
		int i=1;
		int counter=0;
		if(s.isEmpty())
			return 0;
		while (i<size) {
			if (s.charAt(i-1)!=' '&&s.charAt(i-1)!=','&&s.charAt(i-1)!='.') {
				if (s.charAt(i)==' '||s.charAt(i)==','||s.charAt(i)=='.'||i==size-1) {
					counter++;
				}
			}
			i++;
		}
		return counter;
	}
	
	public static String[] dictionary(String s) {
		String[] dictionart=nokfiluiout(s);
		String temp="";
		for (int i = 0; i < dictionart.length; i++) {
			for (int j = i+1; j < dictionart.length; j++) {
				if (dictionart[i].compareTo(dictionart[j])>0) {
					temp=dictionart[i];
					dictionart[i]=dictionart[j];
					dictionart[j]=temp;
				}	
			}
		}
		return dictionart;
	}

	public static String[] nokfiluiout(String s) {
		String h=s.toLowerCase();
		String[] stringarray=sentence(h);
		int counter=0;
		for (int i = 0; i < stringarray.length; i++) {
			for (int j = i+1; j <  stringarray.length; j++) {
				if (stringarray[i].equals(stringarray[j])) 
				{
					stringarray[j]="";
					counter++;
				}
			}
		}
		String[] stringarraytmp=new String[stringarray.length-counter];
		int k=0;
		for (int i = 0; i < stringarray.length; i++) {
			if (stringarray[i]!="") {
				stringarraytmp[k]=stringarray[i];
				k++;
			}
		}
		return stringarraytmp;
	}

	public static boolean sub(String s, String t) {
		boolean ismuchal=false;
		int j=0;
		String [] str1=dictionary(s);
		String [] str2=dictionary(t);
		if (str2.length>str1.length) {
			return ismuchal;
		}
		if (str2.length==str1.length) {
			for (int i = 0; i < str2.length; i++) {
				if (str1[i]!=str2[i]) {
					return ismuchal;
				}
			}
		    ismuchal=true;
		    return ismuchal;
		}
		for (int i = 0; i < str1.length;i++) {
			if (str1[i].equals(str2[j])&&j!=str2.length-1) {
				j++;
			}
			if (j==str2.length-1&&str1[i].equals(str2[j])) {
				ismuchal=true;
			}
		}
		return ismuchal;
	}
}
