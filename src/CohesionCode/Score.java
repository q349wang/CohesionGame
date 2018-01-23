package CohesionCode;


/**
 * File Name:	Score
 * Programmer:	Qiuhan (Leo) Wang
 * Date: January 23, 2017
 * Description: Object which holds all methods and variables used to read and write highscores of top 10 individuals
 */
public class Score  {

    private String name; // Name of individual
    private int score; // Score of individual
    private int rank; // Rank of individual
    
    public Score()  {
        
        this.name = "";
        this.score = 0;
        this.rank = 0;
        
    }
    
    public Score(int ranking, String text, int num)  {
        
        this.score = num;
        this.name = text;
        this.rank = ranking;
        
    }
    
    public void setScore(int num)    { // Sets score
        
        this.score = num;
        
    }
    
    public void setRank(int ranking)    { // Sets rank
        
        this.rank = ranking;
        
    }
    
    public void setName(String text)    { // Sets name
        
        this.name = text;
        
    }
    
    public String getName() { // Returns name
        
        return this.name;
        
    }
    
    public int getScore() { // Returns score
        
        return this.score;
        
    }
    
    public int getRank() { // Returns rank
        
        return this.rank;
        
    }

    
}