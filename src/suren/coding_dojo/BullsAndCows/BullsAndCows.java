package suren.coding_dojo.BullsAndCows;

public class BullsAndCows {
    public String getHint(String scret, String guess) {
        if( !(isInputValid(scret) && isInputValid(guess))){
            throw new IllegalArgumentException("Input is invalid");
        }

        int bulls =0;
        int cows = 0;

        for(int i = 0; i <4 ; i++){
            if(scret.charAt(i) == guess.charAt(i)){
                bulls++;
            }else if(scret.contains(guess.charAt(i)+"")){
                cows++;
            }
        }

        return bulls +"B"+cows+"C";
    }

    private boolean isInputValid(String input) {
        if(input.length() != 4){
            return false;
        }
        for(char c : input.toCharArray()){
            if(c < 48 || c >57){
                return false;
            }
        }
        return true;
    }
}
