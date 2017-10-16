import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author B0344128 劉旻妮
 * Try to write some comments for your codes (methods, 15 points)
 * 這是一隻能夠產生撲克牌的程式。
 * 使用者會被要求輸入欲產生幾副撲克牌，程式便會幫你列出產生的撲克牌。
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: Deck這個方法是用來產生一或多副撲克牌
 * 裡面包括printDeck和getAllCards兩個方法
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		
		//產生幾副牌
		for(int i = 0; i < nDeck ;i++) 
		{
			//產生花色suit
			for(int j = 1; j <= 4; j++)
			{
				//產生數字rank
				for(int k = 1; k <= 13; k++)
				{
					Card card = new Card(j,k);
					//將撲克牌放入ArrayList
					cards.add(card);
				}
			}
		}		
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(Card c:cards)
		{
			c.printCard(c);
		}

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: Card這個方法是用來產生撲克牌（張）
 * 裡面包括printCard, getSuit和getRank這幾個方法
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */	
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(Card card){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		
		//用來儲存與花色相應的英文
		String s = "";
		//用來儲存與數字相應的英文
		String r = "";
		
		//判斷花色
		switch(card.suit)
		{
			case 1:
				s ="Clubs";
				break;
			case 2:
				s = "Diamonds";
				break;
			case 3:
				s = "Hearts";
				break;
			case 4:
				s = "Spades";
				break;
		}
		//判斷數字
		switch(card.rank)
		{
			case 1:
				r ="Ace";
				break;
			case 11:
				r = "Jack";
				break;
			case 12:
				r = "Queen";
				break;
			case 13:
				r = "King";
				break;
			//將A,J,Q,K之外的數值轉為string
			default:
				r = Integer.toString(card.rank);
				break;
		}
		//輸出撲克牌的花色與數字
		System.out.println(s+" "+r);
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
