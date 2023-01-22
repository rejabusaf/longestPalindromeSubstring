package longestPalindromeSubstring;

public class longestPalindromeSubstring {
	
	public static boolean isPalindrome (String checkString) {
		char ch;
		String str = "";
		for(int i=0;i<checkString.length();i++) {
			ch = checkString.charAt(i);
			str = ch + str;
		}
		if (str.equals(checkString))
			return true;
		else
			return false;
	}

	public static String longestPalindrome (String s) {

		int middle = 0;
		int i = 0;
		int left = 0;
		int right = 0;
		char rightchar = 0;
		char leftchar = 0;
		int fails = 0;
		String longest = "";
		String word = "";
		if (s.length() == 1)
			return s;
		if (s.length() == 2)
			if (s.charAt(0) != s.charAt(1))
				return "" + s.charAt(0);
			else
				return s;

		outerloop:
			while (middle < s.length()) {
				fails = 0;
				if (word.length() >= longest.length())
					if (isPalindrome (word))
						longest = word;
					else 
						if (isPalindrome(word.charAt(word.length() - 1) + word.substring(0, word.length() - 1)))
							longest = word.charAt(word.length() - 1) + word.substring(0, word.length() - 1);
				leftchar = s.charAt(middle);
				rightchar = 0;
				word = leftchar + "";
				for(i = 0; i < s.length() ; i++) {
					if (i % 2 == 0) {
						right = (i/2)+1;
						if (right < (s.length() - middle)) {
							rightchar = s.charAt(middle + right);}
						else {
							if (!(isPalindrome(word)))
								if (word.length() > 2)
									word = word.substring(1);
							middle++;
							continue outerloop;
						}
						if(rightchar != leftchar) {
							fails++;
						}
						else
							if (fails > 0)
								fails--;
						if (fails < 2)
							word = word + rightchar;
						else {
							if (word.length()>2) {
								if(i % 2 == 0)
									word = word.substring(1);
								else
									word = word.substring(0,word.length()-1);
							}
							if (!(isPalindrome(word))) {
								if (word.length()>2) {
									if(i % 2 == 0)
										word = word.substring(1);
									else
										word = word.substring(0,word.length()-1);
								}
							}
							middle++;
							continue outerloop;
						}
					}
					else {
						left = (i+1)/2;
						if (left <= middle) {
							leftchar = s.charAt(middle - left); }
						else {
							if (!(isPalindrome(word)))
								if (word.length() > 2)
									word = word.substring(0,word.length() - 1);
							middle++;
							continue outerloop;
						}
						if(rightchar != leftchar) {
							fails++;
						}
						else
							if (fails > 0)
								fails--;
						if (fails < 2)
							word = leftchar + word;
						else {
							if (word.length()>2) {
								if(i % 2 == 0)
									word = word.substring(1);
								else
									word = word.substring(0,word.length()-1);
							}
							if (!(isPalindrome(word))) {
								if (word.length()>2) {
									if(i % 2 == 0)
										word = word.substring(1);
									else
										word = word.substring(0,word.length()-1);
								}
							}
							middle++;
							continue outerloop;
						}
					}
				}
				middle ++;
			}
		if (longest.length() == 0)
			return "" + s.charAt(0);
		return longest;
	}
	
	public static void main(String[] args) {
		String input = "uxpABCBAqnk";
		System.out.println("output is " + longestPalindrome(input));
		System.out.println("input was " + input);

	}

}
